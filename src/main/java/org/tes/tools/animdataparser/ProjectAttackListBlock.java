package org.tes.tools.animdataparser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectAttackListBlock extends BlockObject {

	private StringListBlock projectFiles = new StringListBlock();
	private List<ProjectAttackBlock> projectAttackBlocks = new ArrayList<>();	
	
	public StringListBlock getProjectFiles() {
		return projectFiles;
	}
	public void setProjectFiles(StringListBlock projectFiles) {
		this.projectFiles = projectFiles;
	}
	public List<ProjectAttackBlock> getProjectAttackBlocks() {
		return projectAttackBlocks;
	}
	public void setProjectAttackBlocks(List<ProjectAttackBlock> projectAttackBlocks) {
		this.projectAttackBlocks = projectAttackBlocks;
	}
	

	
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
