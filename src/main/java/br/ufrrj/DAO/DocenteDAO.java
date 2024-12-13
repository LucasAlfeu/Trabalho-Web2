package br.ufrrj.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrrj.model.Docente;

public class DocenteDAO {
	
    // Configurações de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3308/sistema_de_matricula";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    // Método para estabelecer conexão com o banco de dados
    private Connection obterConexao() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
        
	public void cadastrarDocente(Docente d) throws ClassNotFoundException {
		String sql = "INSERT INTO docente (usuario, senha, nome, identificacao) VALUES (?,?,?,?)";
		 Connection conn = null;
	     PreparedStatement ps = null;
		
		try {
            conn = obterConexao();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
			
			ps.setString(1, d.getUsuario());
			ps.setString(2, d.getSenha());
			ps.setString(3, d.getNome());
			ps.setString(4, d.getIdentificacao());
			
            ps.executeUpdate();
            conn.commit();
            System.out.println("Docente cadastrado com sucesso!");
		} catch (SQLException e) {
            if (conn != null) {
                try {
                    System.err.println("Erro ao salvar usuário. Fazendo rollback...");
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	public Docente buscarUsuario(String usuario, String senha) throws ClassNotFoundException {
		String sql = "SELECT * FROM docente WHERE usuario = ? AND senha = ?";
		
		 Connection conn = null;
	     PreparedStatement ps = null;
		try{
            conn = obterConexao();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            
			ps.setString(1, usuario);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			Docente d = new Docente();
			
			rs.next();
			d.setIdDocente(rs.getInt("ID_Docente"));
			d.setNome(rs.getString("nome"));
			d.setUsuario(rs.getString("usuario"));
			d.setSenha(rs.getString("senha"));
			d.setEhChefeDeDepartamento(Boolean.parseBoolean(rs.getString("eh_chefe_de_departamento")));
			d.setEhCoordenador(Boolean.parseBoolean(rs.getString("eh_coordenador")));
			
			conn.commit();
			
			
			return d;
		} catch (SQLException e) {
            if (conn != null) {
                try {
                    System.err.println("Erro ao salvar usuário. Fazendo rollback...");
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return null;
	}
	
    public void atualizarCoordenador(String identificacao) throws ClassNotFoundException {
    	String sql = "UPDATE docente "+
    				"SET eh_coordenador = ? "+
    				"WHERE identificacao = ?";
    	
    	Connection conn = null;
	     PreparedStatement ps = null;
	     
	     try {
	            conn = obterConexao();
	            conn.setAutoCommit(false);
	            ps = conn.prepareStatement(sql);
	            
	            ps.setBoolean(1, true);
				ps.setString(2, identificacao);
	            
	            ps.executeUpdate();
	            
	            conn.commit();
	            
	            System.out.println("Docente atualizado com sucesso!");
	            
	        } catch (SQLException e) { 
	            if (conn != null) {
	                try {
	                    System.err.println("Erro ao atualizar Docente. Fazendo rollback...");
	                    conn.rollback();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	            e.printStackTrace();
	        } finally {
	            try {
	                if (ps != null) ps.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
    }
    
    public void atualizarChefeDepartamento(int idDocente) throws ClassNotFoundException {
    	String sql = "UPDATE docente "+
    				"SET eh_chefe_de_departamento = ? "+
    				"WHERE ID_Docente = ? and eh_coordenador = ?";
    	
    	Connection conn = null;
	     PreparedStatement ps = null;
	     
	     try {
	            conn = obterConexao();
	            conn.setAutoCommit(false);
	            ps = conn.prepareStatement(sql);
	            
	            ps.setBoolean(1, true);
				ps.setInt(2, idDocente);
				ps.setBoolean(3, false);
	            
	            ps.executeUpdate();
	            
	            conn.commit();
	            
	            System.out.println("Docente atualizado como Chefe de Departamento com sucesso!");
	            
	        } catch (SQLException e) { 
	            if (conn != null) {
	                try {
	                    System.err.println("Erro ao atualizar Docente como Chefe de Departamento. Fazendo rollback...");
	                    conn.rollback();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	            e.printStackTrace();
	        } finally {
	            try {
	                if (ps != null) ps.close();
	                if (conn != null) conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

    }
    
    public List<Docente> listarDocentes() throws ClassNotFoundException {

    	String sql = "SELECT * FROM docente";
    	Connection conn = null;
	    PreparedStatement ps = null;
	    
	    try {
            conn = obterConexao();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            List<Docente> minhaLista = new ArrayList<>();
            while(rs.next()) {
            	Docente d = new Docente();
            	d.setIdDocente(rs.getInt("ID_Docente"));
            	d.setUsuario(rs.getString("usuario"));
            	d.setSenha(rs.getString("senha"));
            	d.setIdentificacao(rs.getString("identificacao"));
            	d.setEhCoordenador(rs.getBoolean("eh_coordenador"));
            	d.setEhChefeDeDepartamento(rs.getBoolean("eh_chefe_de_departamento"));
            	minhaLista.add(d);
            }
            
            conn.commit();
            System.out.println("Busca efetuada com sucesso");
            return minhaLista;
        } catch (SQLException e) { 
            if (conn != null) {
                try {
                    System.err.println("Erro ao buscar Docentes. Fazendo rollback...");
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
