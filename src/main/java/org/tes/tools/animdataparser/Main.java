package org.tes.tools.animdataparser;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	
	private static ClassLoader classloader = Thread.currentThread().getContextClassLoader();

	public static void main(String[] args) throws Exception {
		String block = new String(Files
				.readAllBytes(Paths.get(classloader.getResource("animationdatasinglefile.txt").toURI().getPath())));
		AnimDataFile f = new AnimDataFile();
		f.parse(block);
		int projects = f.getProjectList().getStrings().size();
		int sabrecat = -1;
		int dragon = -1;
		int draugr = -1;
		int i = 0;
		for (String s : f.getProjectList().getStrings()) {
			if (s.startsWith("SabreCat"))
				sabrecat = i;
			if (s.startsWith("DragonProject"))
				dragon = i;
			if (s.startsWith("DraugrProject"))
				draugr = i;
			i++;
		}
		
		System.out.println(f.getProjectList().getStrings().get(sabrecat));
		System.out.println(f.getProjectList().getStrings().get(dragon));
		System.out.println(f.getProjectList().getStrings().get(draugr));
		
		f.getProjectList().getStrings().set(projects -1, "GuarProject.txt");
		f.getProjectBlockList().set(projects-1, f.getProjectBlockList().get(sabrecat));
		f.getProjectMovementBlockList().put(projects -1, f.getProjectMovementBlockList().get(sabrecat));
		
		f.getProjectList().getStrings().add("CliffracerProject.txt");
		f.getProjectBlockList().add(f.getProjectBlockList().get(dragon));
		f.getProjectMovementBlockList().put(projects, f.getProjectMovementBlockList().get(dragon));
		
		f.getProjectList().getStrings().add("CorprusStalker.txt");
		f.getProjectBlockList().add(f.getProjectBlockList().get(draugr));
		f.getProjectMovementBlockList().put(projects+1, f.getProjectMovementBlockList().get(draugr));
		
		try (Writer writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("filename.txt"), "utf-8"))) {
			writer.write(f.toString().replaceAll("\n", "\r\n"));
		}
	}

}
