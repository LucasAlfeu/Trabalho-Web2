package br.ufrrj.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String url = "jdbc:mysql://localhost:3308/sistema_de_matricula";
	private static final String user = "root";
	private static final String password = "root";
	
	private static Connection conn = null;
	
	/**public static Connection getConexao() throws ClassNotFoundException {
		try {
			if (conn == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("Conexão feita com sucesso");
				return conn;
			} else {
				return conn;
			}
		} catch (SQLException e) {
			System.out.println("Erro de conexão: "+e.getErrorCode()+", "+e.getMessage());
			return null;
		}
    }
	 * @throws ClassNotFoundException */


    // Método para estabelecer conexão com o banco de dados
    public static Connection obterConexao() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
    	return conn;
    }
}
