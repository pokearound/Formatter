package formatting.inst;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import formatting.Formatter;
import formatting.FormatterFactory;

public class CenterFormatterTest {
	Formatter formater = FormatterFactory.build(Center.ID);
	@Test
	public void testProcess() {
		List<String> lines = formater.process("This text should be center aligned", 10);
		assertTrue("Expected lines.",lines.size()==4);
		String[] o = {"This text","should be","  center"," aligned"};
		assertArrayEquals("Validate each line.",o, lines.toArray());
	}

	@Test
	public void testProcess2() {
		List<String> lines = formater.process("This text should be center aligned", 20);
		assertTrue("Expected lines.",lines.size()==2);
		String[] o = {"This text should be","   center aligned"};
		assertArrayEquals("Validate each line.",o, lines.toArray());
	}

	@Test
	public void testProcess3() {
		List<String> lines = formater.process("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32", 40);
		assertTrue("Expected lines .",lines.size()==20);
	}
}
