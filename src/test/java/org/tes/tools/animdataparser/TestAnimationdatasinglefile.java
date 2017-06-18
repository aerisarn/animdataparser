package org.tes.tools.animdataparser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class TestAnimationdatasinglefile {

	private ClassLoader classloader = Thread.currentThread().getContextClassLoader();

	@Test
	public void test() throws Exception {
		File test = new File(classloader.getResource("animationdatasinglefile.txt").toURI());
		String block = new String(Files.readAllBytes(test.toPath()));
		AnimDataFile f = new AnimDataFile();
		f.parse(block);
		Assert.assertTrue(f.toString().equals(block));
	}

}
