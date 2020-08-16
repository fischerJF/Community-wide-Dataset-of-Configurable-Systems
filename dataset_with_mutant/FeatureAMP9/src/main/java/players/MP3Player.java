/*if[MP3]*/
package players;

import java.io.File;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import players.Player;
import players.TrackMetadata;

import javazoom.jl.decoder.JavaLayerException;

import com.mpatric.mp3agic.*;

/**
 * A simple MP3Player, which is able to play an .mp3-file and pause, resume, and
 * stop the playblack.
 */
public class MP3Player extends Player {

	private AudioInputStream audioStream;

	private Clip clip;

	private TrackMetadata metadata;

	private FloatControl volume;

	private String filename;

	/**
	 * Creates a new MP3Player from given InputStream.
	 * 
	 * @param filename
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws LineUnavailableException
	 */
	public MP3Player(String filename) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (specifications.Configuration.mp3) {
			File file = new File(filename);
			this.filename = filename;
			audioStream = AudioSystem.getAudioInputStream(file);
			AudioFormat baseFormat = audioStream.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
					baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream stream = AudioSystem.getAudioInputStream(decodedFormat, audioStream);
			clip = AudioSystem.getClip();
			clip.open(stream);
			volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		}
	}

	public MP3Player(TrackMetadata track) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (specifications.Configuration.mp3) {
			this.filename = track.getFileName();
			File file = new File(track.getFileName());
			this.metadata = track;
			audioStream = AudioSystem.getAudioInputStream(file);
			AudioFormat baseFormat = audioStream.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
					baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream stream = AudioSystem.getAudioInputStream(decodedFormat, audioStream);
			clip = AudioSystem.getClip();
			clip.open(stream);
			metadata.setRuntime(clip.getMicrosecondLength() / 1000000);
			volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		}
	}

	/**
	 * Starts playback (resumes if paused).
	 * 
	 * @throws JavaLayerException
	 *             when there is a problem decoding the file.
	 */
	public void play() {
		synchronized (clip) {
			if (clip != null && clip.isOpen()) {
				if (playerStatus == State.PLAYING && clip.getMicrosecondPosition() == clip.getMicrosecondLength()) {
					clip.stop();
					clip.setFramePosition(0);
					playerStatus = State.READY;
				}
				clip.start();
				playerStatus = State.PLAYING;
			}
		}
	}

	/**
	 * Pauses playback.
	 */
	public void pause() {
		synchronized (clip) {
			if (playerStatus == State.PLAYING) {
				clip.stop();
				playerStatus = State.PAUSED;
			}
		}
	}

	/**
	 * Resumes playback.
	 */
	public void resume() {
		synchronized (clip) {
			if (playerStatus == State.PAUSED) {
				clip.start();
				playerStatus = State.PLAYING;
			}
		}
	}

	/**
	 * Stops playback. If not playing, does nothing.
	 */
	public void stop() {
		synchronized (clip) {
			clip.stop();
			clip.setFramePosition(0);
			playerStatus = State.READY;
		}
	}

	/**
	 * Closes the player, regardless of current state.
	 */
	public void close() {
		synchronized (clip) {
			if (clip != null && clip.isOpen()) {
				clip.stop();
				clip.close();
			}
		}
		clip = null;
		volume = null;
		try {
			audioStream.close();
			audioStream = null;
		} catch (IOException e) {
			// we are terminating, thus ignore exception
		}
	}

	public void setVolume(int vol) {
		double gain = vol / 100.0f;
		volume.setValue((float) (Math.log(gain) / Math.log(10.0) * 20.0));
	}

	public long position() {
		synchronized (clip) {
			long micros = clip.getMicrosecondPosition();
			return micros / 1000000;
		}
	}

	public TrackMetadata getTrackMetadata() {
		if (this.metadata == null) {
			this.metadata = getTrackMetadata(this.filename);
			metadata.setRuntime(clip.getMicrosecondLength() / 1000000);
		}
		return this.metadata;
	}

	public static TrackMetadata getTrackMetadata(String filename) {
		try {
			TrackMetadata metadata = new TrackMetadata();
			Mp3File mp3file = new Mp3File(filename);
			if (mp3file.hasId3v2Tag()) {
				ID3v2 tag = mp3file.getId3v2Tag();
				metadata.setTitle(tag.getTitle());
				metadata.setArtist(tag.getArtist());
				metadata.setRuntime(mp3file.getLengthInSeconds());
				metadata.setAlbum(tag.getAlbum());
				if (tag.getTrack() != null) {
					try {
						metadata.setTrackNumber(Integer.parseInt(tag.getTrack()));
					} catch (NumberFormatException e) {
						metadata.setTrackNumber(-1);
					}
				}
				byte[] d = tag.getAlbumImage();
				if (d != null) {
					Image cover = ImageIO.read(new ByteArrayInputStream(d));
					metadata.setCover(cover.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
				}
			} else if (mp3file.hasId3v1Tag()) {
				ID3v1 tag = mp3file.getId3v1Tag();
				metadata.setTitle(tag.getTitle());
				metadata.setArtist(tag.getArtist());
				metadata.setAlbum(tag.getAlbum());
				metadata.setRuntime(mp3file.getLengthInSeconds());
				if (tag.getTrack() != null) {
					try {
						metadata.setTrackNumber(Integer.parseInt(tag.getTrack()));
					} catch (NumberFormatException e) {
						metadata.setTrackNumber(-1);
					}
				}
			}
			metadata.setFileName(filename);
			return metadata;
		} catch (Exception e) {
			// keine arme, keine schokolade!
			e.printStackTrace();
			return null;
		}
	}

	public static PlayerFileFilter getFileFilter() {
		return new PlayerFileFilter() {
			public Class<? extends Player> getParentClass() {
				return MP3Player.class;
			}

			public String getDescription() {
				return "MP3 Files";
			}

			public boolean accept(File f) {
				if (f == null) {
					return false;
				}
				if (f.isDirectory()) {
					return true;
				}
				String ext = Player.getExtension(f);
				if (ext == null) {
					return false;
				}
				return ext.equals("mp3");
			}
		};
	}

}
