

import java.io.BufferedReader; 
import java.io.*; 

/**
 *
 * @author Daniel Schulz
 * @version 2.1
 */
/**
 * Handles the main IO exchange to the file system
 */
public  class  iointerface {
	

    protected static final String os_line_seperator = System.getProperty("line.separator");

	
    protected static final String os_file_seperator = System.getProperty("file.separator");

	

    /**
     * thrown when few than double the space needed for the next operation is left.<BR><BR>
     * 
     * Exception thrown when space heaps upon the double space left for
     * saving this file
     */
    public static  class  tooFewSpaceException  extends Exception {

	}

	

    /**
     * reads a file f from disk or data carrier
     *
     * @param f defines the file being read
     * @return String off the content off this file
     * @throws IOException when there's some error or denied access to the file
     */
    protected static String readFile(File f) throws IOException {
        StringBuffer res = new StringBuffer();

        if (!f.canRead() || !f.isFile()) {
            throw new IOException();
        }

        BufferedReader in = new BufferedReader(new FileReader(f.getAbsolutePath()));
        String line;

        while ((line = in.readLine()) != null) {
            res.append(line);
            res.append(os_line_seperator);
        }
        in.close();    // always close a stream when you are done with it

        int hlp_len = res.length();
        if(hlp_len > 0) {
            return res.substring(0, (hlp_len - 1));
        } else {
            return "";
        }
    }

	

    /**
     * writes any content in STring s as file f to a disk or data carriers
     *
     * @param f file path to be written
     * @param s content to be written
     * @throws IOException when there's any access denied or problems regarding permissions
     * @throws aufgabe6.iointerface.tooFewSpaceException when there's too few space left
     * the space available at the time of writing must be at least double the space left than needed
     */
    protected static void writeFile(File f, String s) throws IOException,tooFewSpaceException   {
        /*
         * TODO: Aufgabe 6.1
         *
         * Inhalt (s)  ineine Datei (f) schreiben
         * eventuelle Fehler nach "oben" weiter geben
         */
    	
    	//Datei wird zum Schreiben vorbereitet
    	FileWriter fw = new FileWriter(f);
    
    	fw.write(s);
    	fw.close();
    	
    }


}
