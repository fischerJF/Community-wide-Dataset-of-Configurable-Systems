package featureamp.controler; 

import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.File; 
import java.io.FileOutputStream; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.OutputStreamWriter; 
import java.io.Writer; 
import java.util.LinkedList; 
import java.util.List; 

import featureamp.playback.Track; 

public  class  M3U {
	

	private static final String lb = "\n", sep1 = ",", sep2 = " - ";

	

	public static void toFile(List<Track> tracks, File f) throws IOException {
		// SaveAndLoad
		String content = "#EXTM3U" + lb;
		for (Track t : tracks) {
			content += "#EXTINF" + -1 + sep1 + t.getArtist() + sep2
					+ t.getTitle() + lb + t.getFile().getAbsolutePath() + lb;
			System.out.println(t.getFile().getAbsolutePath());
		}
		Writer fw = new BufferedWriter(new OutputStreamWriter(
			    new FileOutputStream(f), "UTF-8"));
		
		
//		FileWriter fw = new FileWriter(f);
		fw.write(content);
//		fw.flush();
		fw.close();
	}

	
	
	public static List<File> toList(File f) throws IOException {
		// SaveAndLoad
		
		List<File> t = new LinkedList<File>();
		BufferedReader r = new BufferedReader(new FileReader(f));
		String s;
		while ((s = r.readLine()) != null) {
			if (!s.startsWith("#")) {
//				Track tr = TrackFactory.createTrack(new File(s));
				t.add(new File(s));
			}
		}
		r.close();
		return t;
	}


}
