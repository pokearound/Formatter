package formatting;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import formatting.inst.Center;
import formatting.inst.Left;
import formatting.inst.Right;

public class FormatterFactoryTest {
	@Test
	public void testNotNull() {
		FormatterFactory ff = new FormatterFactory();
		assertNotNull("Ensure not null", ff);
	}
	
	@Test
	public void testLeft() {
		Formatter f = FormatterFactory.build("Left");
		assertTrue("Correct instance", f.getClass().isAssignableFrom(Left.class));
	}

	@Test
	public void testRight() {
		Formatter f = FormatterFactory.build("Right");
		assertTrue("Correct instance", f.getClass().isAssignableFrom(Right.class));
	}

	@Test
	public void testCenter() {
		Formatter f = FormatterFactory.build("Center");
		assertTrue("Correct instance", f.getClass().isAssignableFrom(Center.class));
	}

	@Test
	public void testDefault1() {
		Formatter f = FormatterFactory.build("");
		assertTrue("Correct instance", f.getClass().isAssignableFrom(Left.class));
	}

	@Test
	public void testDefault2() {
		Formatter f = FormatterFactory.build("Invalid");
		assertTrue("Correct instance", f.getClass().isAssignableFrom(Left.class));
	}

}
