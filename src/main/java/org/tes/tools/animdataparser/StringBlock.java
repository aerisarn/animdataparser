package org.tes.tools.animdataparser;

import java.util.Scanner;

public class StringBlock extends Block {

	private String string;

	public String getString() {
		return string;
	}

	public void setString(String string) {

		this.string = string;
	}

	public String getBlock() throws Exception {
		return string + System.lineSeparator();
	}

	public void parseBlock(Scanner input) throws Exception {
		string = input.nextLine();
		
	}

}
