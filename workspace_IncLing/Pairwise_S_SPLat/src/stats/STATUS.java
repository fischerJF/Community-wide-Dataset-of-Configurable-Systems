package stats;

public enum STATUS {
	Pass, Fail, Skipped, FatalError, Timeout;
	@Override
	public String toString() {
		String s;
		switch (this) {
		case Pass:
			s = "1";
			break;
		case Fail:
			s = "0";
			break;
		case Skipped:
			s = "-";
			break;
		case FatalError:
			s = "!";
			break;
		case Timeout:
			s = "T";
			break;
		default:
			throw new RuntimeException();
		}
		return s;
	}
};
