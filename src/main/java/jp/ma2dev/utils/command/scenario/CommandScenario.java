package jp.ma2dev.utils.command.scenario;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandScenario {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(CommandScenario.class);

	private List<Input> input;
	private String prompt;
	private String encode;

	public CommandScenario() {
	}

	/**
	 * @return input
	 */
	public List<Input> getInput() {
		return input;
	}

	/**
	 * @param input
	 *            セットする input
	 */
	public void setInput(List<Input> input) {
		this.input = input;
	}

	/**
	 * @return prompt
	 */
	public String getPrompt() {
		return prompt;
	}

	/**
	 * @param prompt
	 *            セットする prompt
	 */
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	/**
	 * @return encode
	 */
	public String getEncode() {
		return encode;
	}

	/**
	 * @param encode
	 *            セットする encode
	 */
	public void setEncode(String encode) {
		this.encode = encode;
	}

	@Override
	public String toString() {
		return "prompt; " + prompt + ", encode: " + encode;
	}

}
