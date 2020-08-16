package indexes.rtrees.InsertHeuristics;

import indexes.rtrees.MBR;


public final class InsertHeuristic {
	public final long punishmentValue;
	public final MBR mbr;
	
	public InsertHeuristic(long _punishmentValue, MBR _mbr){
		this.mbr 				= _mbr;
		this.punishmentValue 	= _punishmentValue;
	}
}
