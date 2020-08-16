package report;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.notification.RunListener;

public class RunListernerReport extends RunListener {

	String conf;
	Record record;
	
	public RunListernerReport(String c, Record record) {
		conf=c;
		this.record=record;
	}
	
	@Override
	public void testFailure(org.junit.runner.notification.Failure failure) throws Exception {
		System.out.println("\n " +conf);
		System.out.println("1 " + failure.getMessage());
		System.out.println("2 " + failure.getTrace());
		System.out.println("3 " + failure.getException());
		System.out.println("4 " + failure.getException().getCause());
		System.out.println("5 " + failure.getDescription());
		System.out.println("6 " + failure.getException().getClass());
		System.out.println("7 " + failure.getTestHeader());
	 
		Report report= new Report();
		report.message=failure.getMessage();
		List<String> aux=splitLine(failure.getTrace());
		report.trace=aux.get(1);
		report.exception=failure.getException().toString();
		report.class_=failure.getException().getClass().toString();
		report.configuration=conf; 
		report.description=failure.getDescription().toString();
		record.report.add(report);
}
	public List<String> splitLine(String line) {
		List<String> novo = new ArrayList<String>();
		
		String[] split = line.split("\n");

		if (split.length <= 0)
			return null;

		for (String string : split) {
			if (!string.isEmpty())
				novo.add(string);
		}
		return novo;
	}
	
}
