package br.ufrrj.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufrrj.connection.Conexao;
import br.ufrrj.model.Discente;

public class DiscenteDAO {	
    // Configurações de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3308/sistema_de_matricula";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    // Método para estabelecer conexão com o banco de dados
    private Connection obterConexao() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
    
	public void cadastrarDiscente(Discente d) throws ClassNotFoundException {
		String sql = "INSERT INTO discente (nome, usuario, senha, matricula, email) VALUES (?,?,?,?,?)";
		 Connection conn = null;
	     PreparedStatement ps = null;
	        
	        try {
	            // Estabelece a conexão
	            conn = obterConexao();
	            
	            // Desativa o autocommit para controle manual da transação
	            conn.setAutoCommit(false);
	            
	            // Prepara o statement
	            ps = conn.prepareStatement(sql);
	            
	            // Define os parâmetros
	            ps.setString(1, d.getNome());
				ps.setString(2, d.getUsuario());
				ps.setString(3, d.getSenha());
				ps.setString(4, d.getMatricula());
				ps.setString(5, d.getEmail());
	            
	            // Executa a inserção
	            ps.executeUpdate();
	            
	            // Confirma a transação
	            conn.commit();
	            
	            System.out.println("Discente salvo com sucesso!");
	            
	        } catch (SQLException e) {
	            // Em caso de erro, faz rollback
	            if (conn != null) {
	                try {
	                    System.err.println("Erro ao salvar usuário. Fazendo rollback...");
	                    conn.rollback();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	            
	            // Imprime o erro original
	            e.printStackTrace();
	        } finally {
	            // Fecha os recursos
	            try {
	                if (ps != null) ps.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}
	
	/**public void cadastrarDiscente(Discente d) throws ClassNotFoundException {
		String sql = "INSERT INTO discente (nome, usuario, senha, matricula, email) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
			
			ps.setString(1, d.getNome());
			ps.setString(2, d.getUsuario());
			ps.setString(3, d.getSenha());
			ps.setString(4, d.getMatricula());
			ps.setString(5, d.getEmail());
			
            ps.executeUpdate();
            System.out.println("Discente cadastrado com sucesso!");
		} catch (SQLException e) {
            System.out.println("Erro ao cadastrar carona: " + e.getMessage());
            e.printStackTrace();
        }
	}
	 * @throws ClassNotFoundException */
	public Discente buscarUsuario(String usuario, String senha) throws ClassNotFoundException {
		String sql = "SELECT * FROM discente WHERE usuario = ? AND senha = ?";
		Connection conn = null;
	     PreparedStatement ps = null;
	        
	        try {
	            conn = obterConexao();
	            conn.setAutoCommit(false);
	            ps = conn.prepareStatement(sql);
	            
				ps.setString(1, usuario);
				ps.setString(2, senha);
				ResultSet rs = ps.executeQuery();
				Discente d = new Discente();
				rs.next();
				d.setIdDiscente(rs.getInt("ID_Discente"));
				d.setNome(rs.getString("nome"));
				d.setUsuario(rs.getString("usuario"));
				d.setSenha(rs.getString("senha"));
				d.setEmail(rs.getString("email"));

				conn.commit();
				System.out.println("Discente encontrado com sucesso!");
				return d;            
	             
	        } catch (SQLException e) {
	            if (conn != null) {
	                try {
	                    System.err.println("Erro ao salvar usuário. Fazendo rollback...");
	                    conn.rollback();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                    System.out.println("erro: "+ex.getMessage());
	                }
	                System.out.println("erro: "+e.getMessage());
	            }
	            
	            
	            e.printStackTrace();
	        } finally {
	            try {
	                if (ps != null) ps.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	                System.out.println("erro: "+e.getMessage());
	            }
	        }
	        return null;
	 }
}
