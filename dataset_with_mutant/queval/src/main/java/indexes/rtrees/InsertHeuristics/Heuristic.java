package indexes.rtrees.InsertHeuristics;


import indexes.rtrees.MBR;
import indexes.rtrees.Point;


public interface Heuristic {
	/**
	 * Get the best node to insert this point. 
	 * @param shallBeInserted
	 * @return Some punishment value, if large inserting here is not good, if zero = no expansion
	 */
	public InsertHeuristic getInsertNode(MBR current, Point toInsert);
}
