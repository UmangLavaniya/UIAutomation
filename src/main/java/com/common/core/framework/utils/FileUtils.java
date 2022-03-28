package com.common.core.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.common.core.framework.constants.Constant;

/**
 * @author umangkumar
 *
 */
public class FileUtils {
	static Properties p;
	static final Logger logger=Logger.getLogger(FileUtils.class);

	public static String readFileAsString(final File file) {
		InputStream stream = getInputStream(file);
		try {
			return stream != null ? org.apache.commons.io.IOUtils.toString(stream, "utf-8") : null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static InputStream getInputStream(final File file) {

		InputStream stream = null;

		if (file == null) {
			return null;
		}
		if (file.exists()) {
			try {
				stream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			stream = FileUtils.class.getResourceAsStream(file.getPath());
			try {
				if (stream == null) {
					stream = FileUtils.class.getResourceAsStream("/" + file.getPath());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return stream;
	}

	public static String getKeyFromPropertyFile(String key) throws IOException {
		FileReader reader = new FileReader(Constant.TEST_DATA_DIR + "qa.config.properties");
		if (p == null) {
			logger.info("Loading properties");
			p = new Properties();
			p.load(reader);
		}
		return p.getProperty(key);
	}

}
