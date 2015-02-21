package jp.ma2dev.db;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DbConnectionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void test() {
		DbConnection connection = new DbConnection();
		connection.exec();
	}

}
