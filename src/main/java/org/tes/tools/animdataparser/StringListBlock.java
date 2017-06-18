package org.tes.tools.animdataparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringListBlock extends Block {

	List<String> strings = new ArrayList<String>();

	public void setStrings(List<String> strings) {
		this.strings = strings;
	}

	public List<String> getStrings() {
		return strings;
	}
	
	public void clear() {
		strings.clear();
	}


	public String getBlock() throws Exception {
		String out = "";
		if (strings.size()==0) return null;
		for (String s : strings) {
			out += s + System.lineSeparator();
		}
		return out;
	}

	public void parseBlock(Scanner input) throws Exception {
		while (input.hasNextLine()) {
			strings.add(input.nextLine());
		}
	}
}
