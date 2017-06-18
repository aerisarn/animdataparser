package org.tes.tools.animdataparser;

import java.util.Scanner;

public interface IBlockObject {

	public void parseBlock(String blockContent) throws Exception;
	
	public void parseBlock(Scanner input) throws Exception;
	
	public String getBlock() throws Exception;
}
