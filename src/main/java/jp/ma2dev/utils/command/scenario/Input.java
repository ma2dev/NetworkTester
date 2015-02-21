package jp.ma2dev.utils.command.scenario;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Input {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(Input.class);

	private String command;
	private int timeout;
	private List<Message> success;
	private List<Message> error;
	private String subprompt;

	public Input() {
	}

	/**
	 * @return command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @param command
	 *            セットする command
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * @return timeout
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout
	 *            セットする timeout
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/**
	 * @return success
	 */
	public List<Message> getSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            セットする success
	 */
	public void setSuccess(List<Message> success) {
		this.success = success;
	}

	/**
	 * @return error
	 */
	public List<Message> getError() {
		return error;
	}

	/**
	 * @param error
	 *            セットする error
	 */
	public void setError(List<Message> error) {
		this.error = error;
	}

	/**
	 * @return subprompt
	 */
	public String getSubprompt() {
		return subprompt;
	}

	/**
	 * @param subprompt
	 *            セットする subprompt
	 */
	public void setSubprompt(String subprompt) {
		this.subprompt = subprompt;
	}
}
