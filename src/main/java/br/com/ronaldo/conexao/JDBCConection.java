package br.com.ronaldo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConection {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/dbpessoa";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	public static Connection createConection() throws ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	public static void close(Connection con, PreparedStatement stm, ResultSet rs) {

		try {
			if (con != null) {
				con.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
