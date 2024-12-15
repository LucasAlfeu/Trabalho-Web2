package br.ufrrj.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrrj.model.Disciplina;

public class DisciplinaDAO {
    private static final String URL = "jdbc:mysql://localhost:3308/sistema_de_matricula";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    private Connection obterConexao() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
    
    public void cadastrarDiscilpina(Disciplina d, int idDocente) throws ClassNotFoundException {
    	String sql = "INSERT INTO disciplina "+
    				"(nome, maxAlunos, numDiscMatriculados, periodo, cargaHoraria, ID_Docente_ID_Docente)"+
    				" VALUES (?,?,?,?,?,?)";
		 Connection conn = null;
	     PreparedStatement ps = null;
	     
	     try {
	            conn = obterConexao();
	            conn.setAutoCommit(false);
	            ps = conn.prepareStatement(sql);
	            
	            ps.setString(1, d.getNomeDisciplina());
				ps.setInt(2, d.getMaxAlunos());
				ps.setInt(3, 0);
				ps.setString(4, d.getPeriodo());
				ps.setInt(5, d.getCargaHoraria());
				ps.setInt(6, idDocente);
	            
	            ps.executeUpdate();
	            
	            conn.commit();
	            
	            System.out.println("Discente salvo com sucesso!");
	            
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
    
    public List<Disciplina> buscarTodasDisciplinas() throws ClassNotFoundException {
    	String sql = "SELECT * FROM disciplina";
		 Connection conn = null;
	     PreparedStatement ps = null;
	     
	     try {
	            conn = obterConexao();
	            conn.setAutoCommit(false);
	            ps = conn.prepareStatement(sql);
	            
	            
	            ResultSet rs = ps.executeQuery();
	            List<Disciplina> lista = new ArrayList<>();
	            while(rs.next()) {
	            	Disciplina d = new Disciplina();
	            	d.setIdDisciplina(rs.getInt("ID_Disciplina"));
	            	d.setNomeDisciplina(rs.getString("nome"));
	            	d.setMaxAlunos(rs.getInt("maxAlunos"));
	            	d.setNumDiscentesMatriculados(rs.getInt("numDiscMatriculados"));
	            	d.setCargaHoraria(rs.getInt("cargaHoraria"));
	            	d.setPeriodo(rs.getString("periodo"));
	            	d.setIdDocente(rs.getInt("ID_Docente_ID_Docente"));
	            	lista.add(d);
	            }
	            
	            conn.commit();
	            
	            System.out.println("Busca de todas as disciplinas feita com sucesso!");
	            return lista;
	            
	        } catch (SQLException e) { 
	            if (conn != null) {
	                try {
	                    System.err.println("Erro ao buscar todas as listas. Fazendo rollback...");
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
    
    public List<Disciplina> buscaListaDeDisciplinaPorIdDocente(int idDocente) throws ClassNotFoundException{
    	String sql = "SELECT * FROM disciplina WHERE ID_Docente_ID_Docente = ?";
		 Connection conn = null;
	     PreparedStatement ps = null;
	     
	     try {
	            conn = obterConexao();
	            conn.setAutoCommit(false);
	            ps = conn.prepareStatement(sql);
	            
	            ps.setInt(1, idDocente);
	            
	            ResultSet rs = ps.executeQuery();
	            List<Disciplina> lista = new ArrayList<>();
	            while(rs.next()) {
	            	Disciplina d = new Disciplina();
	            	d.setIdDisciplina(rs.getInt("ID_Disciplina"));
	            	d.setNomeDisciplina(rs.getString("nome"));
	            	d.setMaxAlunos(rs.getInt("maxAlunos"));
	            	d.setNumDiscentesMatriculados(rs.getInt("numDiscMatriculados"));
	            	d.setCargaHoraria(rs.getInt("cargaHoraria"));
	            	d.setPeriodo(rs.getString("periodo"));
	            	d.setIdDocente(idDocente);
	            	lista.add(d);
	            }
	            
	            conn.commit();
	            
	            System.out.println("Discente salvo com sucesso!");
	            return lista;
	            
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
    
    public Disciplina buscaDisciplinaPorId(int id) throws ClassNotFoundException {
    	String sql = "SELECT * FROM disciplina WHERE ID_Disciplina = ?";
    	
		 Connection conn = null;
	     PreparedStatement ps = null;
	     try {
	            conn = obterConexao();
	            conn.setAutoCommit(false);
	            ps = conn.prepareStatement(sql);
	            
	            ps.setInt(1, id);
	            
	            ResultSet rs = ps.executeQuery();
	            Disciplina d = new Disciplina();
	            while(rs.next()) {
	            	d.setIdDisciplina(rs.getInt("ID_Disciplina"));
	            	d.setNomeDisciplina(rs.getString("nome"));
	            	d.setMaxAlunos(rs.getInt("maxAlunos"));
	            	d.setNumDiscentesMatriculados(rs.getInt("numDiscMatriculados"));
	            	d.setCargaHoraria(rs.getInt("cargaHoraria"));
	            	d.setPeriodo(rs.getString("periodo"));
	            	d.setIdDocente(rs.getInt("ID_Docente_ID_Docente"));
	            }
	            
	            conn.commit();
	            
	            System.out.println("Discente salvo com sucesso!");
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
    
    
}

