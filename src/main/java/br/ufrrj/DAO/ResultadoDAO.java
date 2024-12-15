package br.ufrrj.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrrj.model.Resultado;

public class ResultadoDAO {
    private static final String URL = "jdbc:mysql://localhost:3308/sistema_de_matricula";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    private Connection obterConexao() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
    
    public void cadastraResultado(int idAluno, int idDisciplina) throws ClassNotFoundException {
    	String sql = "INSERT INTO resultado (nota, aprovado, ID_Disciplina_ID_Disciplina, ID_Discente_ID_Discente)" +
    				"VALUES (?,?,?,?)";
    	
    	 Connection conn = null;
	     PreparedStatement ps = null;
	     
	     try {
	            conn = obterConexao();
	            conn.setAutoCommit(false);
	            ps = conn.prepareStatement(sql);
	            
	            ps.setFloat(1, (float) 0.0);
				ps.setString(2, " - ");
				ps.setInt(3, idDisciplina);
				ps.setInt(4, idAluno);
	            
	            ps.executeUpdate();
	            
	            conn.commit();
	            
	            System.out.println("Discente Inscrito com sucesso!");
	            
	        } catch (SQLException e) { 
	            if (conn != null) {
	                try {
	                    System.err.println("Erro ao matricular. Fazendo rollback... Erro: "+e.getMessage());
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
    
    public void atualizarNota(int idDisciplina, int idAluno, String resultado, float nota) throws ClassNotFoundException {
    	String sql = "UPDATE resultado "+
    				"SET nota = ?, aprovado = ? "+
    				"WHERE ID_Disciplina_ID_Disciplina = ? and ID_Discente_ID_Discente = ?";
    	
    	Connection conn = null;
	     PreparedStatement ps = null;
	     
	     try {
	            conn = obterConexao();
	            conn.setAutoCommit(false);
	            ps = conn.prepareStatement(sql);
	            
	            ps.setFloat(1,nota);
				ps.setString(2, resultado);
				ps.setInt(3, idDisciplina);
				ps.setInt(4, idAluno);
	            
	            ps.executeUpdate();
	            
	            conn.commit();
	            
	            System.out.println("Resultado atualizado com sucesso!");
	            
	        } catch (SQLException e) { 
	            if (conn != null) {
	                try {
	                    System.err.println("Erro ao atualizar Resultado. Fazendo rollback...");
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
    
    public List<Resultado> buscarTodosResultadoPorIdDiscente(int idAluno) throws ClassNotFoundException{
    	String sql = "SELECT * FROM resultado WHERE ID_Discente_ID_Discente = ?";
    	
    	Connection conn = null;
	    PreparedStatement ps = null;
	     
	     try {
	            conn = obterConexao();
	            conn.setAutoCommit(false);
	            ps = conn.prepareStatement(sql);
	            
	            ps.setInt(1, idAluno);
	            
	            List<Resultado> lista = new ArrayList<>();
	            ResultSet rs = ps.executeQuery();
	            
	            while(rs.next()) {
	            	Resultado r = new Resultado();
	            	r.setIdDiscente(rs.getInt("ID_Resultado"));
	            	r.setNota(rs.getFloat("nota"));
	            	r.setStatus(rs.getString("aprovado"));
	            	r.setIdDisciplina(rs.getInt("ID_Disciplina_ID_Disciplina"));
	            	r.setIdDiscente(rs.getInt("ID_Discente_ID_Discente"));
	            	
	            	lista.add(r);
	            }
	            
	            conn.commit();
	            
	            System.out.println("Resultados buscado com sucesso!");
	            return lista;
	            
	        } catch (SQLException e) { 
	            if (conn != null) {
	                try {
	                    System.err.println("Erro ao atualizar Resultado. Fazendo rollback...");
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
    
    public List<Resultado> buscarTodosResultadoPorIdDicplinsa(int idDisciplina) throws ClassNotFoundException{
    	String sql = "SELECT * FROM resultado WHERE ID_Disciplina_ID_Disciplina = ?";
    	
    	Connection conn = null;
	    PreparedStatement ps = null;
	     
	     try {
	            conn = obterConexao();
	            conn.setAutoCommit(false);
	            ps = conn.prepareStatement(sql);
	            
	            ps.setInt(1, idDisciplina);
	            
	            List<Resultado> lista = new ArrayList<>();
	            ResultSet rs = ps.executeQuery();
	            
	            while(rs.next()) {
	            	Resultado r = new Resultado();
	            	r.setIdDiscente(rs.getInt("ID_Resultado"));
	            	r.setNota(rs.getFloat("nota"));
	            	r.setStatus(rs.getString("aprovado"));
	            	r.setIdDisciplina(rs.getInt("ID_Disciplina_ID_Disciplina"));
	            	r.setIdDiscente(rs.getInt("ID_Discente_ID_Discente"));
	            	
	            	lista.add(r);
	            }
	            
	            conn.commit();
	            
	            System.out.println("Todos resultados buscado com sucesso!");
	            return lista;
	            
	        } catch (SQLException e) { 
	            if (conn != null) {
	                try {
	                    System.err.println("Erro ao buscar resultados. Fazendo rollback...");
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
    
    
}

