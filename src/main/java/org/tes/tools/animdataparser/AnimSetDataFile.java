package org.tes.tools.animdataparser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimSetDataFile {

	private StringListBlock projectsList = new StringListBlock();
	private List<ProjectAttackListBlock> projectAttacks = new ArrayList<>();
	
	public void parse(String content) throws Exception {
		Scanner input = new Scanner(content);
		projectsList.fromASCII(input);
		while (input.hasNextLine()) {
			ProjectAttackListBlock pa = new ProjectAttackListBlock();
			pa.parseBlock(input);
			projectAttacks.add(pa);
		}
		System.out.println("Parsed " + projectsList.getStrings().size() + " projects");
		System.out.println("and " + projectAttacks.size() + " Attacks Data");
	}
	
	@Override
	public String toString() {
		try {
			String out = projectsList.toASCII();
			for (ProjectAttackListBlock b : projectAttacks) 
				out+=b.getBlock();
			return out;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
