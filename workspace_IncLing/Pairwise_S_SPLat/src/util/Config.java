package util;

import java.io.PrintStream;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import splat.Variables;
import entry.FeatureVar;

public class Config {

	public enum ExecutionMode {
		SPLAT, FILE_SPLAT
	};

	public static ExecutionMode mode = ExecutionMode.SPLAT;

	/***
	 * Load SPLat parameters from the command line
	 */
	public static CommandLine loadOptions(String[] args) {
		Options options = new Options();

		// required or not
		if (mode == ExecutionMode.SPLAT) {
			@SuppressWarnings("static-access")
			Option testName = OptionBuilder.withLongOpt("testclass").withDescription("name of the test class to run")
					.hasArg().withArgName("NAME").create();

			testName.setRequired(true);
			options.addOption(testName);

		} else if (mode == ExecutionMode.FILE_SPLAT) {
			@SuppressWarnings("static-access")
			Option gccPath = OptionBuilder.withLongOpt("gcc-path").withDescription("gcc path").hasArg()
					.withArgName("GCC_PATH").create();
			gccPath.setRequired(true);
			options.addOption(gccPath);

			@SuppressWarnings("static-access")
			Option testPool = OptionBuilder.withLongOpt("test-pool")
					.withDescription("file containing all the tests that should be executed").hasArg()
					.withArgName("TEST_POOL").create();
			testPool.setRequired(true);
			options.addOption(testPool);
		}
		
		@SuppressWarnings("static-access")
		Option shouldSample = OptionBuilder.withLongOpt("shouldsample")
				.withDescription("boolean indicating whether or not to sample").hasArg().withArgName("SAMPLE").create();

		@SuppressWarnings("static-access")
		Option sampleRate = OptionBuilder.withLongOpt("samplerate")
				.withDescription("integer in the ]0,1] range denoting the sampling rate").hasArg().withArgName("SAMPLE")
				.create();

		@SuppressWarnings("static-access")
		Option seed = OptionBuilder.withLongOpt("seed")
				.withDescription("seed used for random sampling if sampling is enabled").hasArg().withArgName("SEED")
				.create();
		
		@SuppressWarnings("static-access")
		Option logFile = OptionBuilder.withLongOpt("logfile").withDescription("name of the log file").hasArg()
				.withArgName("NAME")
				.create();

		
		Option validate = OptionBuilder.withLongOpt("validate") // NEW
				.withDescription("check the validate of configurations").hasArg().withArgName("validade").create();

		validate.setRequired(true);
		shouldSample.setRequired(true);
		logFile.setRequired(true);
		
		// adding options to list
		options.addOption(validate);
		options.addOption(shouldSample);
		options.addOption(sampleRate);
		options.addOption(seed);
		options.addOption(logFile);

		// parsing options from the command line
		CommandLine cmd = null;
		try {
			CommandLineParser parser = new BasicParser();
			cmd = parser.parse(options, args);
		} catch (ParseException exp) {
			new HelpFormatter().printHelp("SPLat", options);
			System.exit(0);
		}
		return cmd;
	}

	public static void printHeader(PrintStream out, CommandLine cmd, Variables vars) {
		// printing parameters
		out.println("# parameters:");
		for (Option opt : cmd.getOptions()) {
			out.printf("#  %s = %s\n", opt.getLongOpt(), opt.getValue());
		}
		// printing map of features
		out.println("# features:");
		int i = 1;
		for (FeatureVar e : vars.getState()
				.keySet() /* should respect ordering */) {
			out.printf("#  %s = %d\n", e.getName(), i++);
		}
	}

}
