package org.tes.tools.animdataparser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MultiLineBlock extends BlockObject {
	
	private int linesPerBlock = 1;
	
	public MultiLineBlock() {
	}
	
	public MultiLineBlock(int linesPerBlock) {
		this.linesPerBlock = linesPerBlock;
	}
	
	public String toASCII() throws Exception {
		String out = "";
		String blockContent = getBlock();
		if (blockContent != null && blockContent!="") {
			Matcher m = Pattern.compile("(\r\n)|(\n)|(\r)").matcher(blockContent);
			int lines = 1;
			while (m.find()) {
				lines++;
			}
			int blockLines = lines/linesPerBlock + lines%linesPerBlock;

			out += blockLines -1 + System.lineSeparator();
			out += blockContent;

		} else

		{
			out += "0" + System.lineSeparator();
		}
		return out;
	}

	public void fromASCII(String ASCIIBlock) {
		Scanner input = new Scanner(ASCIIBlock);
		fromASCII(input);
	}

	public void fromASCII(Scanner input) {
		int numASCIIlines = input.nextInt();
		input.nextLine();
		String blockContent = "";
		for (int i = 0; i < numASCIIlines*linesPerBlock; i++) {
			blockContent += input.nextLine() + System.lineSeparator();
		}
		if (numASCIIlines > 0) {
			try {
				parseBlock(blockContent);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
