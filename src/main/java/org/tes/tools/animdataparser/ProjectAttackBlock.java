package org.tes.tools.animdataparser;

import java.util.Scanner;

public class ProjectAttackBlock extends BlockObject {

	String animVersion = "V3";
	StringListBlock unkEventList = new StringListBlock();
	UnkEventData unkEventData = new UnkEventData();
	ClipAttacksBlock attackData = new ClipAttacksBlock();
	ClipFilesCRC32Block crc32Data = new ClipFilesCRC32Block();
	
	public StringListBlock getUnkEventList() {
		return unkEventList;
	}
	public void setUnkEventList(StringListBlock unkEventList) {
		this.unkEventList = unkEventList;
	}
	public UnkEventData getUnkEventData() {
		return unkEventData;
	}
	public void setUnkEventData(UnkEventData unkEventData) {
		this.unkEventData = unkEventData;
	}
	public ClipAttacksBlock getAttackData() {
		return attackData;
	}
	public void setAttackData(ClipAttacksBlock attackData) {
		this.attackData = attackData;
	}
	public ClipFilesCRC32Block getCrc32Data() {
		return crc32Data;
	}
	public void setCrc32Data(ClipFilesCRC32Block crc32Data) {
		this.crc32Data = crc32Data;
	}

	
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
