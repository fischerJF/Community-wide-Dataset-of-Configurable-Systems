package email.defpackage;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.search.SearchListener;

public class MaxStateIDListener implements SearchListener {
	public static long maxStateID = 0;
	public void searchFinished(Search search) {
		System.out.println("Maximum State ID is: " + maxStateID);
	}
	public void stateAdvanced(Search search) {
		if (search.getStateId() > maxStateID)
			maxStateID = search.getStateId();		
	}
	public void stateProcessed(Search search) {}
	public void stateBacktracked(Search search) {}
	public void statePurged(Search search) {}
	public void stateStored(Search search) {}
	public void stateRestored(Search search) {}
	public void propertyViolated(Search search) {}
	public void searchStarted(Search search) {}
	public void searchConstraintHit(Search search) {}
}