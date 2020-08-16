package engine; 

import java.awt.Image; 
import java.awt.Toolkit; 
import java.text.DecimalFormat; 

import javax.swing.ImageIcon; 

import com.mpatric.mp3agic.ID3v1; 
import com.mpatric.mp3agic.ID3v2; 
import com.mpatric.mp3agic.Mp3File; 

public  class  ID3Tag {
	
	private long lengthInSec,ss;

	
	private String lengthString, artist, title, album, genre, comment,titelleiste, track,year;

	
	private boolean hasId3V1Tag, hasId3V2Tag;

	
	private ImageIcon albumImage;

	
	private final double scale3600 = 1.0/3600;

	
	private final double scale60 = 1.0/60;

	
	private int hh,mm;

	
	private DecimalFormat format = new DecimalFormat("00");

	
	private ID3v1 id3V1Tag;

	
	private ID3v2 id3v2Tag;

	
	
	public ID3Tag(Mp3File mp3file,int imageWidth, int imageHeight, boolean showcover){
		if (specifications.Configuration.featureamp) {
			lengthInSec=mp3file.getLengthInSeconds();
			hh = (int) (lengthInSec * scale3600);
			mm = (int) (lengthInSec * scale60);
			ss = lengthInSec - mm*60 - hh*3600;
			lengthString=format.format(hh)+ ":"+ format.format(mm) + ":" + format.format(ss);
			hasId3V1Tag=mp3file.hasId3v1Tag();
			hasId3V2Tag=mp3file.hasId3v2Tag();
			
			albumImage=new ImageIcon(ID3Tag.class.getResource("/engine/resources/img.jpg")); 
			
			if (hasId3V1Tag) 
				{
				id3V1Tag = mp3file.getId3v1Tag();
				setArtist(id3V1Tag.getArtist());
				setTitle(id3V1Tag.getTitle());
				if (id3V1Tag.getTrack()!=null) setTrack(id3V1Tag.getTrack());
					else setTrack("");
				setAlbum(id3V1Tag.getAlbum());
				setGenre(id3V1Tag.getGenreDescription());
				setComment(id3V1Tag.getComment());
				setYear(id3V1Tag.getYear());
				
				titelleiste=artist+" - " + title +" "+ lengthString + " - ";
				} 
		
		if (mp3file.hasId3v2Tag()) 
			    {
				id3v2Tag = mp3file.getId3v2Tag();
				setArtist(id3v2Tag.getArtist());
				setTitle(id3v2Tag.getTitle());
			    titelleiste=artist+" - " + title +" "+ lengthString + " - ";
				byte[] albumImageData = id3v2Tag.getAlbumImage();
				if (albumImageData != null) 
					{
					Image dimg = Toolkit.getDefaultToolkit().createImage(albumImageData);	
					Image scaledCover=dimg.getScaledInstance(imageWidth, imageHeight, Image.SCALE_FAST);
					if (showcover) albumImage=new ImageIcon(scaledCover);
					}
			    }
				}
	}

	
	
	public ImageIcon getAlbumImage() {
		return albumImage;
	}

	
	
	public String getlengthString() {
		return lengthString;
	}

	
	
	public String getTitleleiste() {
		return titelleiste;
	}

	

	public boolean hasId3V1Tag() {
		return hasId3V1Tag;
	}

	
	
	public boolean hasId3V2Tag() {
		return hasId3V2Tag;
	}

	

	public String getAlbum() {
		return album;
	}

	

	public String getGenre() {
		return genre;
	}

	

	public String getComment() {
		return comment;
	}

	

	public String getTrack() {
		return track;
	}

	
	
	public String getYear() {
		return year;
	}

	
	
	public String getTitle() {
		return title;
	}

	
	
	public String getArtist() {
		return artist;
	}

	
	
	public long getLengthInSec() {
		return lengthInSec;
	}

	
	
	
	
	private void setAlbum(String album) {
		this.album = album;
	}

	
	
	private void setGenre(String genre) {
		this.genre = genre;
	}

	

	private void setComment(String comment) {
		this.comment = comment;
	}

	
	
	private void setTrack(String track) {
		this.track = track;
	}

	

	private void setYear(String year) {
		this.year = year;
	}

	
	
	private void setArtist(String artist) {
		this.artist = artist;
	}

	
	
	private void setTitle(String title) {
		this.title = title;
	}


}
