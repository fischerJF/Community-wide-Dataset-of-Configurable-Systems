package experiment;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import IncLing.*;
import IncLingSpecification.SpecificationZipme;
import specifications.Configuration;
import splat.ZipMeVariables;
import tests.Addler32CheckSumTest;
import tests.CompressAdlerCSTests;
import tests.Example_Paulo;
import tests.Example_Paulo2;
import tests.ExtractTest;
import tests.FirstSuit;
import tests.GZIPtest;
import tests.LitleFeatures;

public class MainTestIncLingZipme {
	
	public  void executeJunitTestCase(IncLing incling) {

		for (Combination combination : incling.getCombsForTest()) {
			for (FeatureIncling f : combination.getListFeatures()) {
				if (f.getName().equals("COMPRESS")) {
					Configuration.COMPRESS = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("GZIP")) {
					Configuration.GZIP = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("EXTRACT")) {
					Configuration.EXTRACT = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("ARCHIVECHECK")) {
					Configuration.ARCHIVECHECK = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("CRC")) {
					Configuration.CRC = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("ADLER32CHECKSUM")) {
					Configuration.ADLER32CHECKSUM = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("DERIVATIVE_COMPRESS_ADLER32CHECKSUM")) {
					Configuration.DERIVATIVE_COMPRESS_ADLER32CHECKSUM = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("DERIVATIVE_COMPRESS_CRC")) {
					Configuration.DERIVATIVE_COMPRESS_CRC = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("DERIVATIVE_COMPRESS_GZIP")) {
					Configuration.DERIVATIVE_COMPRESS_GZIP = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("DERIVATIVE_COMPRESS_GZIPCRC")) {
					Configuration.DERIVATIVE_COMPRESS_GZIPCRC = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("DERIVATIVE_EXTRACT_CRC")) {
					Configuration.DERIVATIVE_EXTRACT_CRC = (f.getState().equals("0") ? false : true);
				}

				if (f.getName().equals("DERIVATIVE_GZIPCRC")) {
					Configuration.DERIVATIVE_GZIPCRC = (f.getState().equals("0") ? false : true);
				}
			}
				/* Chama a bibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				junit.addListener(new TextListener(System.out));
				org.junit.runner.Result result = junit.run(
				    Example_Paulo.class,
            Example_Paulo2.class,
            Addler32CheckSumTest.class,
            CompressAdlerCSTests.class,
            FirstSuit.class,
            GZIPtest.class,
            LitleFeatures.class,
            ExtractTest.class
				    );
				/* fim core junit */
			
		}
	}
	public void expRun() {
		ArrayList<String>  featureName =new ArrayList<String> ();
		featureName.add("COMPRESS"); //0
		featureName.add("GZIP"); //1
		featureName.add("EXTRACT");//2
		featureName.add("ARCHIVECHECK");//3
		featureName.add("CRC");//4
		featureName.add("ADLER32CHECKSUM");
		featureName.add("DERIVATIVE_COMPRESS_ADLER32CHECKSUM");
		featureName.add("DERIVATIVE_COMPRESS_CRC");
		featureName.add("DERIVATIVE_COMPRESS_GZIP");
		featureName.add("DERIVATIVE_COMPRESS_GZIPCRC");
		featureName.add("DERIVATIVE_EXTRACT_CRC");
		featureName.add("DERIVATIVE_GZIPCRC");
		
		IncLing incling = new IncLing(1000, 10000, featureName, SpecificationZipme.getSINGLETON(Configuration.tool), ZipMeVariables.getSINGLETON());
 //       executeJunitTestCase(incling);
	}


	public static void main(String[] args) {
		MainTestIncLingZipme run = new MainTestIncLingZipme();
		run.expRun();
		
		
 }
}