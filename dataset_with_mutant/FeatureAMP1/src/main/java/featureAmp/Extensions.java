package featureAmp; 

public   class  Extensions {
	
	
	public static String[] extensions = new String[2];

	
	
	static{
		init();
	}

	
	
	 private static void  init__wrappee__Base  (){
		
	}

	

	 private static void  init__wrappee__MP3  (){
		if (!specifications.Configuration.mp3) {
			init__wrappee__Base();
			return;
		}
		extensions[0] = "mp3";
	}

	

	private static void init(){
		if (!specifications.Configuration.wav) {
			init__wrappee__MP3();
			return;
		}
		init__wrappee__MP3();
		extensions[1]="wav";
	}


}
