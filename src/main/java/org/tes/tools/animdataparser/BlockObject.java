package org.tes.tools.animdataparser;

import java.util.Scanner;

public abstract class BlockObject implements IBlockObject {

	public void parseBlock(String blockContent) throws Exception {
		parseBlock(new Scanner(blockContent));
	}
	
}
