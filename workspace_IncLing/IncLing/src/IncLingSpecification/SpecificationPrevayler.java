package IncLingSpecification;

import IncLingSpecification.Specification;
import guidsl.Tool;

public class SpecificationPrevayler  extends Specification{
	public static boolean USE_XSTREAM = true;
	public static boolean USE_TRANSIENT_MODE = true;
	public static boolean USE_PAUSABLE_CLOCK = false;
	public static boolean USE_NULL_MONITOR = false;
	public static boolean USE_LOG4J_MONITOR = false;
	public static boolean USE_JOURNAL_DISK_SYNC = false;
	public static boolean USE_BROKEN_CLOCK = false;
	public static boolean FILE_SIZE_THREASHOLD = false;
	public static boolean FILE_AGE_THREASHOLD = false;
	
	private static SpecificationPrevayler SINGLETON;
    
	public static SpecificationPrevayler getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationPrevayler();
		}
		tool=t;
		return SINGLETON;
	}
	
	public static String setBase() {
		return (USE_XSTREAM) ? "USE_XSTREAM___" : "-USE_XSTREAM___";
	}
	public static String setUSE_TRANSIENT_MODE() {
		return (USE_TRANSIENT_MODE) ? "USE_TRANSIENT_MODE___" : "-USE_TRANSIENT_MODE___";
	}	
	public static String setUSE_PAUSABLE_CLOCK() {
		return (USE_PAUSABLE_CLOCK) ? "USE_PAUSABLE_CLOCK___" : "-USE_PAUSABLE_CLOCK___";
	}	
	public static String setUSE_NULL_MONITOR() {
		return (USE_NULL_MONITOR) ? "USE_NULL_MONITOR___" : "-USE_NULL_MONITOR___";
	}
	public static String setUSE_LOG4J_MONITOR() {
		return (USE_LOG4J_MONITOR) ? "USE_LOG4J_MONITOR___" : "-USE_LOG4J_MONITOR___";
	}
	public static String setUSE_JOURNAL_DISK_SYNC() {
		return (USE_JOURNAL_DISK_SYNC) ? "USE_JOURNAL_DISK_SYNC___" : "-USE_JOURNAL_DISK_SYNC___";
	}
	public static String setUSE_BROKEN_CLOCK() {
		return (USE_BROKEN_CLOCK) ? "USE_BROKEN_CLOCK___" : "-USE_BROKEN_CLOCK___";
	}
	public static String setFILE_SIZE_THREASHOLD() {
		return (FILE_SIZE_THREASHOLD) ? "FILE_SIZE_THREASHOLD___" : "-FILE_SIZE_THREASHOLD___";
	}
	public static String setFILE_AGE_THREASHOLD() {
		return (FILE_AGE_THREASHOLD) ? "FILE_AGE_THREASHOLD___" : "-FILE_AGE_THREASHOLD___";
	}
	
	public static void init(String... args) {
		int index = 0;
		USE_XSTREAM = Boolean.valueOf(args[index++]);		
		USE_TRANSIENT_MODE  = Boolean.valueOf(args[index++]);
		USE_PAUSABLE_CLOCK = Boolean.valueOf(args[index++]);
		USE_NULL_MONITOR = Boolean.valueOf(args[index++]);
		USE_LOG4J_MONITOR = Boolean.valueOf(args[index++]);
		USE_JOURNAL_DISK_SYNC = Boolean.valueOf(args[index++]);
		USE_BROKEN_CLOCK = Boolean.valueOf(args[index++]);
		FILE_SIZE_THREASHOLD  = Boolean.valueOf(args[index++]);
		FILE_AGE_THREASHOLD  = Boolean.valueOf(args[index++]);
		
	}
	
	public boolean thereIsBase() {
    	return false;
    }
	


}
