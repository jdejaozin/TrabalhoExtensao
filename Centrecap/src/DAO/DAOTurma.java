/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Entities.Turma;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jp_te
 */
public class DAOTurma {
    private Connection connection = null;
    private DAOCurso daoCurso = new DAOCurso();
    
    public DAOTurma(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void criarTurma(int idCurso, String dataMinistracao){
        String sql = "insert into turma"
                + "(id_curso, data)"
                + " values(?,?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);){
            stmt.setInt(1, idCurso);
            stmt.setDate(2, Date.valueOf(dataMinistracao));
            stmt.execute();
            
            System.out.println("Turma criado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void removerTurma(int idTurma){
        String sql = "delete from turma where idturma = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);){
            stmt.setInt(1, idTurma);
            stmt.execute();
            
            System.out.println("Turma removida com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Turma buscarTurma(int idTurma){
        String sql = "select * from turma where idturma = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);){
            stmt.setInt(1, idTurma);

            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idTurmaEncontrado = rs.getInt("idturma");
                int idCurso = rs.getInt("id_curso");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss.S");
                LocalDateTime dataNascimento = LocalDateTime.parse(rs.getTimestamp("data").toString(), formatter);
                
                Turma turma = new Turma();
                turma.setIdTurma(idTurmaEncontrado);
                turma.setCurso(daoCurso.buscarCurso(idCurso));
                turma.setData(dataNascimento);

                return turma;
            }
            rs.close();
            
            System.out.println("Turma encontrado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
