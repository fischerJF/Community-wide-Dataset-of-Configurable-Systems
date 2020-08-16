package testset;



import java.io.File;

public class VarexJConstants {

	public static String[] JPF_CONFIGURATION = { "+search.class=.search.RandomSearch", 
    "+classpath=" + new File("").getAbsolutePath() + "/bin"
    		+","+ "C:\\Users\\Fischer_PC\\.p2\\pool\\plugins\\org.junit_4.12.0.v201504281640\\junit.jar"
    		+","+ "C:\\Users\\Fischer_PC\\Dropbox\\workspace_Testing_CSS_paper_2019\\workspace_vareJ_2019\\checkstyle\\lib\\org-apache-commons-logging.jar"
    		+","+ "C:\\Users\\Fischer_PC\\.m2\\repository\\log4j\\log4j\\1.2.16\\log4j-1.2.16.jar"
    		//+","+ "C:\\Users\\Fischer_PC\\Dropbox\\workspace_Testing_CSS_paper_2019\\workspace_vareJ_2019\\checkstyle\\lib\\commons-logging-1.2.jar"
    		};

//	    "+classpath=" + new File("").getAbsolutePath() + "/bin,C:\\Users\\Fischer_PC\\.p2\\pool\\plugins\\org.junit_4.12.0.v201504281640\\junit.jar",
//      "+featuremodel="+ new File("").getAbsolutePath() + "/jTopasFeatureModel.dimacs"};
  
}
