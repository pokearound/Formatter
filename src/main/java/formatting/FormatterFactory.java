package formatting;

import formatting.inst.Left;

public class FormatterFactory {
	/**
	 * 
	 * Builds the respective instance for formatting based on the mode
	 * 
	 * @param mode
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */

	@SuppressWarnings("deprecation")
	public static Formatter build(String mode) {
		try {
			return (Formatter) Class.forName("formatting.inst."+mode).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("WARN: Unable to instatiate formatted for "+ mode + "Defaulting to Left");
			return new Left();
		}
	}
}
