package jp.ma2dev.utils.command;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import net.arnx.jsonic.JSONException;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ScenarioReaderTest {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ScenarioReaderTest.class);

	private static final String file = "src/main/config/command.json";
	private BufferedReader reader;

	@Before
	public void setUp() throws Exception {
		reader = new BufferedReader(new FileReader(file));
	}

	@Test
	public final void testJackson() {
		ScenarioReader handler = new ScenarioReader(reader);
		try {
			handler.execJackson();
		} catch (JsonParseException e) {
			// 自動生成された catch ブロック
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
