package formatting;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class to implement when creating a new formatting option.
 * TODO: Justify alignment
 * Do the following before you introduce new Formatter
 * 1. Add new formatter to main.Main.formatters (so it will be available for user to interact with from cli)
 * 2. Implement the abstract methods
 * 
 * @author anand
 *
 */
public abstract class Formatter {

	/**
	 * Formatter will depend on this method to format each line
	 * 
	 * @param str
	 * @return
	 */
	protected abstract String format(String str);
	
	/**
	 * Method to calculate how much padding required in each line
	 * Usually it changes based on alignment type
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	protected abstract int padLength(String str, int len);
	
	protected final String padding(String str, int len) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < padLength(str, len); i++) {
			sb.append(' ');
		}
		sb.append(str);
		return sb.toString();
	}

	/**
	 * 
	 * Prints formatted string
	 * 
	 * @param str  - string to format
	 * @param len  - max length, after which, wrap to next line
	 * 
	 */

	public List<String> process(String str, int len) {
		BreakIterator bi = BreakIterator.getWordInstance();
		bi.setText(str);
		int start = bi.first();
		int end = bi.next();
		List<String> lines = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		while (end != BreakIterator.DONE) {
			String currentWord = str.substring(start, end);
			if ((sb.length() + currentWord.length()) > len) {
				processLine(lines, sb.toString(), len);
				sb = new StringBuffer();
			}
			sb.append(currentWord);
			start = end;
			end = bi.next();
		}
		if (sb.toString().trim().length() > 0) {
			processLine(lines, sb.toString(), len);
		}
		return lines;
	}
	
	/**
	 * Utility method to help reuse code. 
	 * 
	 * @param lines
	 * @param str
	 * @param len
	 */
	private void processLine(List<String> lines, String str, int len) {
		String line = padding(format(str), len);
		lines.add(line);
		System.out.println(line);
	}

}
