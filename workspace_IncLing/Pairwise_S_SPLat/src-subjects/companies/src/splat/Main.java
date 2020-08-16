package splat;

import java.io.File;
import java.io.PrintStream;
import java.util.List;

import experiment.ExperimentRunner;
import experiment.ProcessResults;
import experiment.TestResults;
import sampling.Sampling;
import sampling.Sampling.Mode;

public class Main {

  public static void main(String[] args) throws Exception {
    PrintStream log = new PrintStream(new File("results_companies.txt"));
    String dataPath = (new java.io.File("./../..")).getCanonicalPath().toString() + "/data/";
    
    /***** SPLat *****/
    Sampling.mode = Mode.SPLAT;
    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
        dataPath+"companies_splat.txt",
        "--shouldsample", "false", "--samplerate", "1", "--seed", "95729",
        "--validate", "true" };
    List<TestResults> resultsSplat = ExperimentRunner.runExp(args,
        CompaniesVariables.getSINGLETON());

    
     /********************************SAMPLING*******************************/
    
    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
        dataPath+"companies_one_enabled.txt",
      "--shouldsample", "true", "--samplerate", "1", "--seed", "95729",
      "--validate", "true" };
    System.out.println("--------------------------------------------------");
    /***** SPLat-Sampling *****/
    /***** one-enabled *****/
    Sampling.mode = Mode.ONE_ENABLED;
    List<TestResults> resultsSplatOneEnabled = ExperimentRunner.runExp(args,
        CompaniesVariables.getSINGLETON());
    
    
    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
        dataPath+"companies_one_disabled.txt",
        "--shouldsample", "true", "--samplerate", "1", "--seed", "95729",
        "--validate", "true" };
    System.out.println("--------------------------------------------------");
    /***** SPLat-Sampling *****/
    /***** one-disabled *****/
    Sampling.mode = Mode.ONE_DISABLED;
    List<TestResults> resultsSplatOneDisabled = ExperimentRunner.runExp(args,
        CompaniesVariables.getSINGLETON());

    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
        dataPath+"companies_most_enabled_disabled.txt",
        "--shouldsample", "true", "--samplerate", "1", "--seed", "95729",
        "--validate", "true" };
    System.out.println("--------------------------------------------------");
    /***** SPLat-Sampling *****/
    /***** most-enabled-disabled *****/
    Sampling.mode = Mode.MOST_ENABLED_DISABLED;
    List<TestResults> resultsMostEnabledDisabled = ExperimentRunner.runExp(args,
        CompaniesVariables.getSINGLETON());
    
//    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
//        dataPath+"companies_combination.txt",
//        "--shouldsample", "true", "--samplerate", "1", "--seed", "95729",
//        "--validate", "true" };
//    System.out.println("--------------------------------------------------");
//    /***** SPLat-Sampling *****/
//    /***** combination *****/
//    Sampling.mode = Mode.COMBINATION;
//    List<TestResults> resultsCombination = ExperimentRunner.runExp(args,
//        CompaniesVariables.getSINGLETON());
//    
    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
        dataPath+"companies_pairwise.txt",
        "--shouldsample", "true", "--samplerate", "1", "--seed", "95729",
        "--validate", "true" };
    System.out.println("--------------------------------------------------");
    /***** SPLat-Sampling *****/
    /***** pairwise *****/
    Sampling.mode = Mode.PAIRWISE;
    List<TestResults> resultsPairwise = ExperimentRunner.runExp(args,
        CompaniesVariables.getSINGLETON());
    
    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
        dataPath+"companies_random1.txt",
        "--shouldsample", "true", "--samplerate", "1", "--seed", "95729",
        "--validate", "true" };
    System.out.println("--------------------------------------------------");
    /***** SPLat-Sampling *****/
    /***** random *****/
    Sampling.mode = Mode.RANDOM;
    List<TestResults> resultsRandom1 = ExperimentRunner.runExp(args,
        CompaniesVariables.getSINGLETON());
    
//    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
//        dataPath+"companies_random2.txt",
//        "--shouldsample", "true", "--samplerate", "1", "--seed", "12345",
//        "--validate", "true" };
//    System.out.println("--------------------------------------------------");
//    /***** SPLat-Sampling *****/
//    /***** random *****/
//    Sampling.mode = Mode.RANDOM;
//    List<TestResults> resultsRandom2 = ExperimentRunner.runExp(args,
//        CompaniesVariables.getSINGLETON());
//    
//    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
//        dataPath+"companies_random3.txt",
//        "--shouldsample", "true", "--samplerate", "1", "--seed", "23456",
//        "--validate", "true" };
//    System.out.println("--------------------------------------------------");
//    /***** SPLat-Sampling *****/
//    /***** random *****/
//    Sampling.mode = Mode.RANDOM;
//    List<TestResults> resultsRandom3 = ExperimentRunner.runExp(args,
//        CompaniesVariables.getSINGLETON());
//    
//    
//    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
//        dataPath+"companies_random4.txt",
//        "--shouldsample", "true", "--samplerate", "1", "--seed", "34567",
//        "--validate", "true" };
//    System.out.println("--------------------------------------------------");
//    /***** SPLat-Sampling *****/
//    /***** random *****/
//    Sampling.mode = Mode.RANDOM;
//    List<TestResults> resultsRandom4 = ExperimentRunner.runExp(args,
//        CompaniesVariables.getSINGLETON());
//    
//    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
//        dataPath+"companies_random5.txt",
//        "--shouldsample", "true", "--samplerate", "1", "--seed", "45678",
//        "--validate", "true" };
//    System.out.println("--------------------------------------------------");
//    /***** SPLat-Sampling *****/
//    /***** random *****/
//    Sampling.mode = Mode.RANDOM;
//    List<TestResults> resultsRandom5 = ExperimentRunner.runExp(args,
//        CompaniesVariables.getSINGLETON());
//    
//    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
//        dataPath+"companies_random6.txt",
//        "--shouldsample", "true", "--samplerate", "1", "--seed", "56789",
//        "--validate", "true" };
//    System.out.println("--------------------------------------------------");
//    /***** SPLat-Sampling *****/
//    /***** random *****/
//    Sampling.mode = Mode.RANDOM;
//    List<TestResults> resultsRandom6 = ExperimentRunner.runExp(args,
//        CompaniesVariables.getSINGLETON());
//    
//    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
//        dataPath+"companies_random7.txt",
//        "--shouldsample", "true", "--samplerate", "1", "--seed", "67890",
//        "--validate", "true" };
//    System.out.println("--------------------------------------------------");
//    /***** SPLat-Sampling *****/
//    /***** random *****/
//    Sampling.mode = Mode.RANDOM;
//    List<TestResults> resultsRandom7 = ExperimentRunner.runExp(args,
//        CompaniesVariables.getSINGLETON());
//    
//    
//    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
//        dataPath+"companies_random8.txt",
//        "--shouldsample", "true", "--samplerate", "1", "--seed", "78901",
//        "--validate", "true" };
//    System.out.println("--------------------------------------------------");
//    /***** SPLat-Sampling *****/
//    /***** random *****/
//    Sampling.mode = Mode.RANDOM;
//    List<TestResults> resultsRandom8 = ExperimentRunner.runExp(args,
//        CompaniesVariables.getSINGLETON());
//    
//    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
//        dataPath+"companies_random9.txt",
//        "--shouldsample", "true", "--samplerate", "1", "--seed", "89012",
//        "--validate", "true" };
//    System.out.println("--------------------------------------------------");
//    /***** SPLat-Sampling *****/
//    /***** random *****/
//    Sampling.mode = Mode.RANDOM;
//    List<TestResults> resultsRandom9 = ExperimentRunner.runExp(args,
//        CompaniesVariables.getSINGLETON());
//    
//    args = new String[] { "--testclass", "tests.TestAll", "--logfile",
//        dataPath+"companies_random10.txt",
//        "--shouldsample", "true", "--samplerate", "1", "--seed", "11111",
//        "--validate", "true" };
//    System.out.println("--------------------------------------------------");
//    /***** SPLat-Sampling *****/
//    /***** random *****/
//    Sampling.mode = Mode.RANDOM;
//    List<TestResults> resultsRandom10 = ExperimentRunner.runExp(args,
//        CompaniesVariables.getSINGLETON());
    

    /********************************RESULTS*******************************/
    ProcessResults pr = new ProcessResults(log, resultsSplat,
        resultsSplatOneEnabled, resultsSplatOneDisabled, resultsRandom1,
        null, null, null, null, 
        null, null, null, null, 
        null, resultsMostEnabledDisabled, null, resultsPairwise); //resultsCombination
//    ProcessResults pr = new ProcessResults(log, null,
//        null, null, null, null, null, resultsSplat);
    pr.calculateResults();
    pr.calculateTotal();
    pr.calculateAverage();
    // pr.calculateStats();
//    pr.calculateReachableConfs();
//    pr.calculateDataPlot("companies");
  }

}
