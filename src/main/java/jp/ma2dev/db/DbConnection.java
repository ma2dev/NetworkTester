package jp.ma2dev.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public void exec() {
		// TODO 自動生成されたメソッド・スタブ

		try {
			// JDBCドライバーの指定
			Class.forName("org.sqlite.JDBC");

			// データベースに接続する なければ作成される
			Connection con = DriverManager.getConnection("jdbc:sqlite:db/database.db");

		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			// Connection の例外が発生した時

			e.printStackTrace();
		}
	}
}
