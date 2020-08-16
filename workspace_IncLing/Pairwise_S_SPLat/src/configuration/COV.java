package configuration;

public enum COV {
	Enabled1, Enabled2, Enabled3, Disabled0, Disabled1, Untouched;
	@Override
	public String toString() {
		String s;
		switch (this) {
		case Enabled1:
			s = "1";
			break;
		case Enabled2:
			s = "2";
			break;
		case Enabled3:
			s = "3";
			break;
		case Disabled0:
			s = "0";
			break;
		case Disabled1:
			s = "-1";
			break;
		case Untouched:
			s = "?";
			break;
		default:
			throw new RuntimeException();
		}
		return s;
	}

}
