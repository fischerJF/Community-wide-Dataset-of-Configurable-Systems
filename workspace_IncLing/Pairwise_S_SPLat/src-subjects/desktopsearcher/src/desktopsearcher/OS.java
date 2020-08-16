package desktopsearcher;

import splat.DesktopSearcherVariables;


public class OS {
	public static String getPathSeparator() {
		String separator = "";
		if (DesktopSearcherVariables.getSINGLETON().isLINUX()) {
			separator = "/";
		} else if (DesktopSearcherVariables.getSINGLETON().isWINDOWS()) {
			separator = "\\\\";
		}
		return separator;
	}

	public static char getPathSeparatorChar() {
		char sep = 0;
		if (DesktopSearcherVariables.getSINGLETON().isLINUX()) {
			sep = '/';
		} else if (DesktopSearcherVariables.getSINGLETON().isWINDOWS()) {
			sep = '\\';
		}
		return sep;
	}
}