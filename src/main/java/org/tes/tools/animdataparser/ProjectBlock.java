package org.tes.tools.animdataparser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectBlock extends Block {

	boolean hasProjectFiles = false;
	StringListBlock projectFiles = new StringListBlock();
	boolean hasAnimationCache = false;
	List<ClipGeneratorBlock> clips = new ArrayList<ClipGeneratorBlock>();
	
	public boolean hasAnimationCache() {
		return hasAnimationCache;
	}
	
	public StringListBlock getProjectFiles() {
		return projectFiles;
	}
	
	public List<ClipGeneratorBlock> getClips() {
		return clips;
	}

	public void setClips(List<ClipGeneratorBlock> clips) {
		this.clips = clips;
	}

	public boolean isHasProjectFiles() {
		return hasProjectFiles;
	}

	public void setHasProjectFiles(boolean hasProjectFiles) {
		this.hasProjectFiles = hasProjectFiles;
	}

	public boolean isHasAnimationCache() {
		return hasAnimationCache;
	}

	public void setHasAnimationCache(boolean hasAnimationCache) {
		this.hasAnimationCache = hasAnimationCache;
	}

	public void setProjectFiles(StringListBlock projectFiles) {
		this.projectFiles = projectFiles;
	}

	public String getBlock() throws Exception {
		String out = "";
		out+=(hasProjectFiles?"1":"0")+System.lineSeparator();
		out+=projectFiles.toASCII();
		out+=(hasAnimationCache?"1":"0")+System.lineSeparator();
		if(hasAnimationCache) {
			for (ClipGeneratorBlock clip : clips)
				out+=clip.getBlock();
		}
		return out;
	}

	public void parseBlock(Scanner input) throws Exception {
		hasProjectFiles = input.nextInt()==1;input.nextLine();
		if (hasProjectFiles)
			projectFiles.fromASCII(input);
		hasAnimationCache = input.nextInt()==1;input.nextLine();
		if (hasAnimationCache) {
			while(input.hasNextLine()) {
				ClipGeneratorBlock b = new ClipGeneratorBlock();
				b.parseBlock(input);
				clips.add(b);
				input.nextLine();
			}
		}
	}

}
