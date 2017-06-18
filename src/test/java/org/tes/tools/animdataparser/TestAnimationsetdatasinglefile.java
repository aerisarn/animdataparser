package org.tes.tools.animdataparser;

import java.io.File;
import java.nio.file.Files;

import org.junit.Assert;
import org.junit.Test;

public class TestAnimationsetdatasinglefile {

	private ClassLoader classloader = Thread.currentThread().getContextClassLoader();

	@Test
	public void test() throws Exception {
		File test = new File(classloader.getResource("animationsetdatasinglefile.txt").toURI());
		String block = new String(Files
				.readAllBytes(test.toPath()));
		AnimSetDataFile f = new AnimSetDataFile();
		f.parse(block);
		Assert.assertTrue(f.toString().equals(block));
	}

}
