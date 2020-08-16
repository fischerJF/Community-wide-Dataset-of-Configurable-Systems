package engine; 

import java.io.File; 

public  class  Zuordnung {
	
	private String anzeige;

	
	private File file;

	
	
	public Zuordnung(String anzeige, File file)
		{
		if (specifications.Configuration.featureamp) {
			this.anzeige=anzeige;
			this.file=file;
					}
	}

	
	
	public File getFile()
		{
		return file;
		}

	
	
	public String getAnzeige()
		{
		return anzeige;
		}


}
