package org.tes.tools.animdataparser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectAttackListBlock extends BlockObject {

	StringListBlock projectFiles = new StringListBlock();
	List<ProjectAttackBlock> projectAttackBlocks = new ArrayList<>();
	
	@Override
	public void parseBlock(Scanner input) throws Exception {
		projectFiles.fromASCII(input);
		for (String p : projectFiles.strings) {
			ProjectAttackBlock pb = new ProjectAttackBlock();
			pb.parseBlock(input);
			projectAttackBlocks.add(pb);
		}
	}
	@Override
	public String getBlock() throws Exception {
		String out = projectFiles.toASCII();
		for (ProjectAttackBlock p : projectAttackBlocks) {
			out+=p.getBlock();
		}
		return out;
	}
	

	
	
}
