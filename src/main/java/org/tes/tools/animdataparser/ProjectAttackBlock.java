package org.tes.tools.animdataparser;

import java.util.Scanner;

public class ProjectAttackBlock extends BlockObject {

	String animVersion = "V3";
	StringListBlock unkEventList = new StringListBlock();
	UnkEventData unkEventData = new UnkEventData();
	ClipAttacksBlock attackData = new ClipAttacksBlock();
	ClipFilesCRC32Block crc32Data = new ClipFilesCRC32Block();
	
	@Override
	public void parseBlock(Scanner input) throws Exception {
		animVersion = input.nextLine();
		unkEventList.fromASCII(input);
		unkEventData.fromASCII(input);
		int numAttackBlocks = input.nextInt();input.nextLine();
		attackData.blocks = numAttackBlocks;
		attackData.parseBlock(input);
		crc32Data.fromASCII(input);
	}
	@Override
	public String getBlock() throws Exception {
		String out=animVersion+System.lineSeparator();
		out+=unkEventList.toASCII();
		out+=unkEventData.toASCII();
		out+=attackData.blocks+System.lineSeparator();
		out+=attackData.getBlock();
		out+=crc32Data.toASCII();
		return out;
	}
	

	
	
}
