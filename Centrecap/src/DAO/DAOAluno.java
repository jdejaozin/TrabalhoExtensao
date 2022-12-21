/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Entities.Aluno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jp_te
 */
public class DAOAluno {
    private Connection connection = null;
    private DAOEmpresa daoEmpresa = new DAOEmpresa();
    private DAOTurma daoTurma = new DAOTurma();
    
    public DAOAluno(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void criarAluno(String nome, String cpf, String rg, String endereco,
            String dataNascimento, String telefone, int idTurma, String cnpj){
        String sql = "insert into aluno"
                + "(nome, cpf, rg, endereco, data_nascimento, telefone, id_turma, cnpj_empresa)"
                + " values(?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);){
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, rg);
            stmt.setString(4, endereco);
            stmt.setDate(5, Date.valueOf(dataNascimento));
            stmt.setString(6, telefone);
            stmt.setInt(7, idTurma);
            stmt.setString(8, cnpj);
            stmt.execute();
            
            System.out.println("Aluno criado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void removerAluno(String cpf){
        String sql = "delete from aluno where cpf = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);){
            stmt.setString(1, cpf);
            stmt.execute();
            
            System.out.println("Aluno removido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Aluno buscarAluno(String cpf){
        String sql = "select * from aluno where cpf = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);){
            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idAluno = rs.getInt("id_aluno");
                String nomeAluno = rs.getString("nome");
                String cpfAluno = rs.getString("cpf");
                String rg = rs.getString("rg");
                String endereco = rs.getString("endereco");
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss.S");
                LocalDateTime dataNascimento = LocalDateTime.parse(rs.getTimestamp("data_nascimento").toString(), formatter);
                
                String telefone =  rs.getString("telefone");
                int idTurma = rs.getInt("id_turma");
                String cnpjEmpresa = rs.getString("cnpj_empresa");
                
                Aluno aluno = new Aluno();
                aluno.setId(idAluno);
                aluno.setNome(nomeAluno);
                aluno.setCpf(cpfAluno);
                aluno.setRg(rg);
                aluno.setEndereco(endereco);
                aluno.setDataNascimento(dataNascimento);
                aluno.setTelefone(telefone);
                aluno.setTurma(daoTurma.buscarTurma(idTurma));
                aluno.setEmpresa(daoEmpresa.buscarEmpresa(cnpjEmpresa));

                return aluno;
            }
            rs.close();
            
            System.out.println("Aluno encontrado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
