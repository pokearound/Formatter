package main;

import java.util.HashSet;
import java.util.Set;

import formatting.Formatter;
import formatting.FormatterFactory;
import formatting.inst.Center;
import formatting.inst.Left;
import formatting.inst.Right;

public class Main {
	private static Set<String> formatters = new HashSet<>();
	static{	// TODO: Externalize it
		formatters.add(Left.ID);
		formatters.add(Right.ID);
		formatters.add(Center.ID);
	}
	
	public static void main(String[] args) {
		if (args == null || args.length < 2 || args.length > 3) {
			throw new IllegalArgumentException("Invalid Args");
		}
		String str = args[0];
		int len = Integer.parseInt(args[1]);
		String mode = Left.ID;
		if(args.length==3) {
			String tmp = args[2];
			if(formatters.contains(tmp)) {				
				mode = tmp;
			}else {
				System.out.println("WARN: Unexpected mode, only allowed Left, Right, Center(case sensitive). Defaulting to Left.");
				mode = Left.ID;
			}
		}
		if(len<0) {
			len = Math.abs(len);
			System.out.println("WARN: Only positive numbers expected for max length. Assuming "+ len);
		}
		Formatter formater = FormatterFactory.build(mode);
		formater.process(str, len);
	}
}
