package formatting.inst;

import formatting.Formatter;

public class Left extends Formatter {
	public static final String ID = Left.class.getSimpleName();

	@Override
	protected int padLength(String str, int len) {
		return 0;
	}
	@Override
	protected String format(String str) {
		return str.replaceAll("^\\s+", "");
	}
}
