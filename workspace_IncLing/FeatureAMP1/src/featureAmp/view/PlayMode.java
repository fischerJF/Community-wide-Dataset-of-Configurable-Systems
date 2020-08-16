package featureAmp.view; 

public enum  PlayMode {
	NORMAL("normal") ,  
	REPEAT_TRACK("repeat one track") ,  
	REPEAT_PLAYLIST("repeat playlist") , 
	SHUFFLE("shuffle"); 

	PlayMode(String name){
		if (specifications.Configuration.shufflerepeat) {
			this.name = name;
				}
	} 
	
	private String name; 
	
	
	@Override
	public String toString() {
		return name;
	}}
