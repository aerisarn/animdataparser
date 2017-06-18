package org.tes.tools.animdataparser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClipAttacksBlock extends QuadBlock {
	
	public Integer blocks;
	List<AttackDataBlock> attackData = new ArrayList<>();

	@Override
	public void parseBlock(Scanner input) throws Exception {
		for (int i=0;i<blocks;i++) {
			AttackDataBlock ad = new AttackDataBlock();
			ad.eventName = input.nextLine();
			ad.unk1 = input.nextInt();input.nextLine();
			ad.clips.fromASCII(input);
			attackData.add(ad);
		}		
	}

	@Override
	public String getBlock() throws Exception {
		if (attackData.isEmpty()) return "";
		String out = "";
		for (AttackDataBlock ad : attackData) {
			out+=ad.eventName+System.lineSeparator();
			out+=ad.unk1+System.lineSeparator();
			out+=ad.clips.toASCII();
		}
		return out;
	}

}
