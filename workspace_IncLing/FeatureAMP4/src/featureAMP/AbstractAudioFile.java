package featureAMP;
public abstract  class  AbstractAudioFile  implements AudioFile {
	
	
	protected String filename;

	
	
	public AbstractAudioFile(String filename) {
		if (specifications.Configuration.base_featureamp) {
			this.filename = filename;
				}
	}

	

	@Override
	public int compareTo(AudioFile o) {
		return this.getTrack().compareTo(o.getTrack());
	}

	

	@Override
	public String getFilename() {
		return this.filename;
	}

	

	@Override
	public String getTotalTime() {
		int totalSec = this.getTotalSec();
		return "" + (totalSec / 60) 
				+ ":" 
				+ String.format("%02d", (totalSec % 60));
	}


}
