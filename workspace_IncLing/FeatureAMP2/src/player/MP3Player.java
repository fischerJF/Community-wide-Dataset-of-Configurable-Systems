package player; 

import java.awt.Image; 
import java.io.ByteArrayInputStream; 
import java.io.File; 
import java.io.IOException; 

import javax.imageio.ImageIO; 
import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.FloatControl; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 


import player.PlayerFileFilter; 

import com.mpatric.mp3agic.ID3v1; 
import com.mpatric.mp3agic.ID3v2; 
import com.mpatric.mp3agic.Mp3File; 

public  class  MP3Player  extends Player {
	

	private AudioInputStream stream;

	
	private String filename;

	
	private Clip clip;

	
	private int playerStatus;

	
	private TrackMetadata metadata;

	
	private FloatControl volume;

	

	public MP3Player(String filename) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (specifications.Configuration.mp3) {
			File file = new File(filename);
			this.filename = filename;
			stream = AudioSystem.getAudioInputStream(file);
			AudioFormat baseFormat = stream.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream stream = AudioSystem.getAudioInputStream(decodedFormat, this.stream);
			clip = AudioSystem.getClip();
			clip.open(stream);
			volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				}
	}

	

	public MP3Player(TrackMetadata track)  throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if (specifications.Configuration.mp3) {
			this.filename = track.getFileName();
			File file = new File(track.getFileName());
			this.metadata = track;
			stream = AudioSystem.getAudioInputStream(file);
			AudioFormat baseFormat = stream.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
					baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream stream = AudioSystem.getAudioInputStream(decodedFormat, this.stream);
			clip = AudioSystem.getClip();
			clip.open(stream);
			metadata.setLength(clip.getMicrosecondLength() / 1000000);
			volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				}
	}

	


	@Override
	public void play() {
		synchronized (clip) {
			if (clip != null && clip.isOpen()) {
				if (playerStatus == STATUS_PLAYING && clip.getMicrosecondPosition() == clip.getMicrosecondLength()) {
					clip.stop();
					clip.setFramePosition(0);
					playerStatus = STATUS_READY;
				}
				clip.start();
				playerStatus = STATUS_PLAYING;
			}
		}
	}

	

	@Override
	public void pause() {
		synchronized (clip) {
			if (playerStatus == STATUS_PLAYING) {
				clip.stop();
				playerStatus = STATUS_PAUSED;
			}
		}
	}

	

	@Override
	public void resume() {
		synchronized (clip) {
			if (playerStatus == STATUS_PAUSED) {
				clip.start();
				playerStatus = STATUS_PLAYING;
			}
		}
	}

	

	@Override
	public void stop() {
		synchronized (clip) {
			clip.stop();
			clip.setFramePosition(0);
			playerStatus = STATUS_FINISHED;
		}
	}

	
	
	/**
	 * Closes the player, regardless of current state.
	 */
	public void close() {
		synchronized (clip) {
			if(clip != null && clip.isOpen()) {
				clip.stop();
				clip.close();
			}
		}
		try {
			stream.close();
			stream = null;
		} catch (IOException e) {
			// we are terminating, thus ignore exception
		}
	}

	
	
	// aktuelle Position abfragen
	public long getPosition() {
		synchronized (clip) {
			long micros = clip.getMicrosecondPosition();
			return micros / 1000000;
		}
	}

	
	
	// Filefilter um mp3 Dateien nur zu wählen
	public static PlayerFileFilter getFileFilter()
	{
		return new PlayerFileFilter() {
			public Class<? extends Player> getParentClass()
			{
				return MP3Player.class;
			}
			
			public String getDescription()
			{
				return "MP3 Files";
			}
			
			public boolean accept(File f)
			{
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

	
	
	// brauch ich momentan nicht, weiß nicht mehr genau warum eigentlich geschrieben 
//	public String getTimer() {
//		long currentPosition = clip.getMicrosecondPosition() / 1000 / 1000;
//		return (currentPosition / 60) + ":"
//				+ ((currentPosition % 60) < 10 ? "0" : "")
//				+ (currentPosition % 60);
//	}
	
	// setzt die Lautstärke
	public void setVolume(int vol) {
		double gain = vol / 100.0f;
		volume.setValue((float)(Math.log(gain) / Math.log(10.0) * 20.0));	
	}

	
	
	// ruft die Metadaten für den Track ab
	public TrackMetadata getTrackMetadata()
	{
		if (this.metadata == null) {
			this.metadata = getTrackMetadata(this.filename);
			metadata.setLength(clip.getMicrosecondLength() / 1000000);
		}
		return this.metadata;
	}

	
	
	// baut die Metadata für einen File zusammen
	public static TrackMetadata getTrackMetadata(String filename)
	{
		try {
			TrackMetadata metadata = new TrackMetadata();
			Mp3File mp3file = new Mp3File(filename);
			if (mp3file.hasId3v2Tag()) {
				ID3v2 tag = mp3file.getId3v2Tag();
				metadata.setTitle(tag.getTitle());
				metadata.setArtist(tag.getArtist());
				metadata.setLength(mp3file.getLengthInSeconds());
				metadata.setAlbum(tag.getAlbum());
				if (tag.getTrack() != null) {
					try {
						metadata.setTrackNumber(Integer.parseInt(tag.getTrack()));
					} catch (NumberFormatException e)
					{
						metadata.setTrackNumber(-1);
						System.err.println("Wer kam auf die dämliche Idee Tracknummern als Sting abzulegen?");
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
				metadata.setLength(mp3file.getLengthInSeconds());
				if (tag.getTrack() != null) {
					try {
						metadata.setTrackNumber(Integer.parseInt(tag.getTrack()));
					} catch (NumberFormatException e)
					{
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

	

	@Override
	public int playerStatus() {
		return this.playerStatus;
	}


}
