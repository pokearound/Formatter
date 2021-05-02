package main;

import org.junit.Test;

public class MainTest {

	@Test(expected = IllegalArgumentException.class)
	public void testMainIAE1() {
		Main.main(null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testMainIAE2() {
		String[] args = {};
		Main.main(args);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testMainNFE3() {
		String[] args = {""};
		Main.main(args);
	}
	@Test(expected = NumberFormatException.class)
	public void testMainNFE() {
		String[] args = {"",""};
		Main.main(args);
	}
	@Test
	public void testMain1() {
		String[] args = {"Some text to format","0"};
		Main.main(args);
	}
	@Test
	public void testMain2() {
		String[] args = {"Some text to format","0", "IllegalMode"};
		Main.main(args);
	}
	@Test
	public void testMain3() {
		String[] args = {"Some text to format","20", "IllegalMode"};
		Main.main(args);
	}
	@Test
	public void testMain4() {
		String[] args = {"Some text to format","-10", "Left"};
		Main.main(args);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testMainNFE4() {
		String[] args = {"Some text to format","-10", "Right", "Left"};
		Main.main(args);
	}
}
