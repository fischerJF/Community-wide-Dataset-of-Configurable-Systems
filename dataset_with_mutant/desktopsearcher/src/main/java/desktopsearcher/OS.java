package desktopsearcher;

import specifications.Configuration;

public class OS {
	public static String getPathSeparator() {
		String separator = "";
		if (Configuration.LINUX) {
			separator = "/";
		} else if (Configuration.WINDOWS) {
			separator = "\\\\";
		}
		return separator;
	}

	public static char getPathSeparatorChar() {
		char sep = 0;
		if (Configuration.LINUX) {
			sep = '/';
		} else if (Configuration.WINDOWS) {
			sep = '\\';
		}
		return sep;
	}
}