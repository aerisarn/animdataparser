package org.tes.tools.animdataparser;

import java.util.Scanner;

public class ClipGeneratorBlock extends BlockObject {
	
	String name = "";
	Integer cacheIndex = 0;
	String playbackSpeed = "0";
	String unknown = "0";
	String unknown2 = "0";
	StringListBlock events = new StringListBlock();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCacheIndex() {
		return cacheIndex;
	}
	public void setCacheIndex(Integer cacheIndex) {
		this.cacheIndex = cacheIndex;
	}
	public String getPlaybackSpeed() {
		return playbackSpeed;
	}
	public void setPlaybackSpeed(String playbackSpeed) {
		this.playbackSpeed = playbackSpeed;
	}
	public String getUnknown() {
		return unknown;
	}
	public void setUnknown(String unknown) {
		this.unknown = unknown;
	}
	public String getUnknown2() {
		return unknown2;
	}
	public void setUnknown2(String unknown2) {
		this.unknown2 = unknown2;
	}
	public StringListBlock getEvents() {
		return events;
	}
	public void setEvents(StringListBlock events) {
		this.events = events;
	}
	
	public String getBlock() throws Exception {
		String out = name + System.lineSeparator();
		out+= cacheIndex + System.lineSeparator();
		out+= playbackSpeed + System.lineSeparator();
		out+= unknown + System.lineSeparator();
		out+= unknown2 + System.lineSeparator();
		out+= events.toASCII()+ System.lineSeparator();
		return out;
	}
	public void parseBlock(Scanner input) throws Exception {
		name = input.nextLine();
		cacheIndex = input.nextInt();input.nextLine();
		playbackSpeed = input.nextLine();
		unknown = input.nextLine();
		unknown2 = input.nextLine();
		events.fromASCII(input);
	}

}
