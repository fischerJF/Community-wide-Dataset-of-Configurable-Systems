package email.defpackage;
import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.jvm.DynamicElementInfo;
import gov.nasa.jpf.jvm.JVM;
import gov.nasa.jpf.jvm.StaticElementInfo;
import gov.nasa.jpf.report.Statistics;
import gov.nasa.jpf.search.Search;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JPF_PrimitiveLogListener_Lifted extends ListenerAdapter {
	private String resultMessagePrefix="jpfResultMessagePrefix: ";
	private String statesMessagePrefix="jpfStatesMessagePrefix: ";
	
	private static boolean logNumberOfAllErrors = true;
	
	private int numSucc = 0;
	private int numErrors = 0;
	
	// this line should be replaced by the Verification Environment
	//static String baseLogDir    = "/local/JPF_log/";
	private StaticElementInfo testRef;
	private String lastResult = null;
	private Search search;
	private int numSucceededBeforeError = 0;
	
	@Override
	public void searchFinished(Search search) {
		gov.nasa.jpf.Error jpfError = search.getLastError();
		//System.out.println(result==null?"result=null":"result="+result);
		if (jpfError != null && (lastResult == null || lastResult.startsWith("succeeded"))) {
			//System.out.println("Lifted prodcued error: " + jpfError.getDescription());
			DynamicElementInfo actions = (DynamicElementInfo) testRef.getFieldValueObject("actions");
			lastResult = "JPFerror: " + jpfError.getDescription() + 
			" Actions: " + actions.asString() + 
			"(" + (numSucc+numErrors) + " thread terminations during Verification)";
		}
		if (logNumberOfAllErrors)
			System.out.println("numErrors:" + numErrors + " numSucc:" + numSucc);
		
		if (logNumberOfAllErrors) {
			// lastResult might be irrelevant (might be success even if there were errors before)
			if (numErrors == 0) {
				if (lastResult!=null)
					System.out.println(resultMessagePrefix + "succeeded (" + numSucc + " terminations)");
				else
					System.out.println(resultMessagePrefix + "No Thread Termination");
			} else {
				System.out.println(resultMessagePrefix + "Errors: " + numErrors + ", " + numSucc +" succeeded terminations");
			}
		} else {
			if (lastResult!=null)
				System.out.println(resultMessagePrefix + lastResult);
			else
				System.out.println(resultMessagePrefix + "No Thread Termination");
		}
		Statistics stat = search.getVM().getNextListenerOfType(Statistics.class, null);
		if (stat == null){
			System.out.println(statesMessagePrefix + "NA");
		} else {
			System.out.println(statesMessagePrefix + stat.newStates);
		}
	}

	@Override
	public void searchStarted(Search search) {
		gov.nasa.jpf.Config conf = search.getConfig();
		if (conf.hasValue("PLlistener.searchAllDefects")) {
			this.logNumberOfAllErrors = conf.getBoolean("PLlistener.searchAllDefects"); // false if property is not stated
		}
		
		System.out.println("searchClass is: " + search.getClass());
		this.search = search;
	}

	@Override
	public void threadTerminated(JVM vm) {
		// This means that one program execution path that was checked by JPF is terminated
		// one program execution path yields one TestConfiguration/LogEntry
		super.threadTerminated(vm);
		DynamicElementInfo errorInfo = (DynamicElementInfo) testRef.getFieldValueObject("error");
		DynamicElementInfo ignoreRun = (DynamicElementInfo) testRef.getFieldValueObject("ignoreThisRun");
		DynamicElementInfo selectedFeatures = (DynamicElementInfo) testRef.getFieldValueObject("selectedFeatures");
		DynamicElementInfo actions = (DynamicElementInfo) testRef.getFieldValueObject("actions");
		if (ignoreRun.asString().equals("true")) 
			return;
		if (errorInfo == null || errorInfo.isNull()) {
			//System.out.println("Termination: Success");
			// succeeded
			numSucceededBeforeError++;
			lastResult = "succeeded (" + numSucceededBeforeError + ". Thread Termination)";
			if (logNumberOfAllErrors)
				numSucc++;
		} else {
			//System.out.println("Termination: Failed: " + errorInfo.asString());
			//failed
			lastResult = errorInfo.asString() + " Features: " + selectedFeatures.asString() + 
			" Actions: " + actions.asString() + 
			"(SuccededTerminationsBeforeThisError:"+numSucceededBeforeError+")";
			//System.out.println(lastResult);
			if (! logNumberOfAllErrors)
				search.terminate();
			else
				numErrors++;
		}
	}
	
	@Override
	public void methodEntered(JVM vm) {
		super.methodEntered(vm);
		// this method is needed to get an initial reference to the test_Runner class
		// method search_started seems to be too early to do this (class is not yet initialized?)
		super.instructionExecuted(vm);
		if (testRef == null)
			testRef = vm.getClassReference("Test_Runner");
	}
}
