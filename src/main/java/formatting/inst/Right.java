package formatting.inst;

import formatting.Formatter;

public class Right extends Formatter {
	public static final String ID = Right.class.getSimpleName();
	@Override
	protected int padLength(String str, int len) {
		return len - str.length();
	}
	@Override
	protected String format(String str) {
		return str.replaceAll("\\s+$", "");
	}
}
