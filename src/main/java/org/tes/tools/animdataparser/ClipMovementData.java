package org.tes.tools.animdataparser;

import java.util.Scanner;

public class ClipMovementData extends BlockObject {

	Integer cacheIndex = 0;
	String duration = "0";
	StringListBlock traslations = new StringListBlock();
	StringListBlock rotations = new StringListBlock();
	
	@Override
	public void parseBlock(Scanner input) throws Exception {
		cacheIndex = input.nextInt();input.nextLine();
		duration = input.nextLine();
		traslations.fromASCII(input);
		rotations.fromASCII(input);
	}
	
	@Override
	public String getBlock() throws Exception {
		String out = cacheIndex + System.lineSeparator();
		out+= duration + System.lineSeparator();
		out+= traslations.toASCII();
		out+= rotations.toASCII() + System.lineSeparator();
		return out;
	}

	public Integer getCacheIndex() {
		return cacheIndex;
	}

	public void setCacheIndex(Integer cacheIndex) {
		this.cacheIndex = cacheIndex;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public StringListBlock getTraslations() {
		return traslations;
	}

	public void setTraslations(StringListBlock traslations) {
		this.traslations = traslations;
	}

	public StringListBlock getRotations() {
		return rotations;
	}

	public void setRotations(StringListBlock rotations) {
		this.rotations = rotations;
	}
	
	
	
}
