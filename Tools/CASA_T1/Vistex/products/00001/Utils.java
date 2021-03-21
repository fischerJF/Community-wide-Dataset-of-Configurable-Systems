
public   class  Utils {
	

    public static String exportHTML  (String text, String title) {

        return null;
    }

	

    /**
     * hashes the text inserted and returns the hash
     * 
     * @param text original text to make a hash out of
     * @return hash of text input
     */
    public static StringBuffer getHash(String text) {

        /*
         * TODO: Aufgabe 6.2
         *
         * Berechne den Hash von String text und gebe ihn aus.
         */
    	
    	Integer hash = text.hashCode();
    	StringBuffer sb = new StringBuffer(hash.toString());
    	
        return  sb;
    }

	


    /**
     * delivers an file hash seperated by spaces and in hashBlocksizes
     *
     * @param s hash without spaces
     * @return seperated hash
     */
    protected static String deliverAdequate(String s) {
        
        StringBuffer sb = new StringBuffer();

        int l = s.length();
        int i = l % Main.hashBlocksize;

        sb.append(s.substring(0, i));
        sb.append(" ");
        

        for(; i < l; i += Main.hashBlocksize) {
            sb.append(s.substring(i, (i + Main.hashBlocksize)));
            sb.append(" ");
        }

        if(sb.length() > 1) {
            return sb.substring(0, (sb.length() - 1));
        } else {
            return "";
        }
    }


}
