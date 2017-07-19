package org.tes.tools.animdataparser;

public class AttackDataBlock {

	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Integer getUnk1() {
		return unk1;
	}
	public void setUnk1(Integer unk1) {
		this.unk1 = unk1;
	}
	public StringListBlock getClips() {
		return clips;
	}
	public void setClips(StringListBlock clips) {
		this.clips = clips;
	}
	public String eventName = "";
	public Integer unk1 = 0;
	public StringListBlock clips = new StringListBlock();
	
}
