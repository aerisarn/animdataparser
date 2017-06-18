package org.tes.tools.animdataparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AnimDataFile {
	
	private StringListBlock projectsList = new StringListBlock(); 
	private List<ProjectBlock> projectBlockList = new ArrayList<ProjectBlock>();
	private Map<Integer, ProjectDataBlock> projectMovementBlockList = new HashMap<>();
	
	public StringListBlock getProjectList() {
		return projectsList;
	}
	
	public List<ProjectBlock> getProjectBlockList() {
		return projectBlockList;
	}
	
	public Map<Integer, ProjectDataBlock> getProjectMovementBlockList() {
		return projectMovementBlockList;
	}
	
	public void parse(String content) throws Exception {
		Scanner input = new Scanner(content);
		projectsList.fromASCII(input);
		int i = 0;
		for (String project : projectsList.getStrings()) {
			StringListBlock n = new StringListBlock();
			n.fromASCII(input);
			ProjectBlock b = new ProjectBlock();
			b.parseBlock(n.getBlock());
			projectBlockList.add(b);
			if (b.hasAnimationCache) {
				ProjectDataBlock n1 = new ProjectDataBlock();
				n1.fromASCII(input);
				projectMovementBlockList.put(i,n1);
			}
			i++;
		}
		System.out.println("Parsed " + projectsList.getStrings().size() + " projects");
		System.out.println("and " + projectBlockList.size() + " projectBlockList Data");
		System.out.println("and " + projectMovementBlockList.size() + " projectMovementBlockList Data");
		
	}

	@Override
	public String toString() {
		try {
			String out = projectsList.toASCII();
			int i = 0;
			for (ProjectBlock b : projectBlockList) {
				out+=b.toASCII();
				if (b.hasAnimationCache()) {
					out+=projectMovementBlockList.get(i).toASCII();
				}
				i++;
			}
			return out;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
