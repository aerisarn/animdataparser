package org.tes.tools.animdataparser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectDataBlock extends Block {
	
	List<ClipMovementData> movementData = new ArrayList<>();

	public List<ClipMovementData> getMovementData() {
		return movementData;
	}

	public void setMovementData(List<ClipMovementData> movementData) {
		this.movementData = movementData;
	}

	@Override
	public void parseBlock(Scanner input) throws Exception {
		while(input.hasNextLine()) {
			ClipMovementData b = new ClipMovementData();
			b.parseBlock(input);
			movementData.add(b);
			input.nextLine();
		}
	}

	@Override
	public String getBlock() throws Exception {
		String out = "";
		for (ClipMovementData data : movementData)
			out+=data.getBlock();
		return out;
	}

}
