package jdbc;

import java.sql.Connection;

import br.com.ronaldo.conexao.JDBCConection;

public class TesteConection {

	public static void main(String[] args) {
		
		JDBCConection jdbcCon = new JDBCConection();
		try {
			Connection con = jdbcCon.createConection();
			System.out.println("conectado" + con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
