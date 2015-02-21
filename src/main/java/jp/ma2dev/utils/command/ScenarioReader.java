package jp.ma2dev.utils.command;

import java.io.IOException;
import java.io.Reader;

import jp.ma2dev.utils.command.scenario.CommandScenario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ScenarioReader {
	private static final Logger log = LoggerFactory.getLogger(ScenarioReader.class);

	private Reader reader;

	public ScenarioReader(Reader reader) {
		this.reader = reader;
	}

	public void execJackson() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		CommandScenario handler = mapper.readValue(reader, CommandScenario.class);

		String result = mapper.writeValueAsString(handler);
		log.debug(result);
	}
}
