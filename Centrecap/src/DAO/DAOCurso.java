/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Entities.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jp_te
 */
public class DAOCurso {
    private Connection connection = null;
    
    public DAOCurso(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void criarCurso(String nome){
        String sql = "insert into curso"
                + "(nome)"
                + " values(?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);){
            stmt.setString(1, nome);
            stmt.execute();
            
            System.out.println("Curso criado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void removerCurso(int idCurso){
        String sql = "delete from curso where idcurso = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);){
            stmt.setInt(1, idCurso);
            stmt.execute();
            
            System.out.println("Curso removido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Curso buscarCurso(int idCurso){
        String sql = "select * from curso where idcurso = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);){
            stmt.setInt(1, idCurso);

            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idCursoEncontrado = rs.getInt("idcurso");
                String nomeCurso = rs.getString("nome");
                
                Curso curso = new Curso();
                curso.setId(idCursoEncontrado);
                curso.setNome(nomeCurso);

                return curso;
            }
            rs.close();
            
            System.out.println("Curso encontrado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public List<Curso> listarCurso(){
        List<Curso> cursos = new ArrayList<>();
        String sql = "select * from curso";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);){
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idCursoEncontrado = rs.getInt("idcurso");
                String nomeCurso = rs.getString("nome");
                
                Curso curso = new Curso();
                curso.setId(idCursoEncontrado);
                curso.setNome(nomeCurso);

                cursos.add(curso);
            }
            rs.close();
            
            System.out.println("Curso encontrado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cursos;
    }
}
