package formatting.inst;

import formatting.Formatter;

public class Center extends Formatter {
	public static final String ID = Center.class.getSimpleName();
	@Override
	protected int padLength(String str, int len) {
		return (len - str.length())/2;
	}
	@Override
	protected String format(String str) {
		return str.replaceAll("\\s+$", "");
	}
}
