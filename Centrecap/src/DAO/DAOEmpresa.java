/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Entities.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jp_te
 */
public class DAOEmpresa {
    private Connection connection = null;
    
    public DAOEmpresa(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void criarEmpresa(String nome, String cnpj, 
            String telefone, String email){
        String sql = "insert into empresa"
                + "(nome, cnpj, telefone, email)"
                + " values(?,?,?,?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);){
            stmt.setString(1, nome);
            stmt.setString(2, cnpj);
            stmt.setString(3, telefone);
            stmt.setString(4, email);
            stmt.execute();
            
            System.out.println("Empresa criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void removerEmpresa(String cnpj){
        String sql = "delete from empresa where cnpj = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);){
            stmt.setString(1, cnpj);
            stmt.execute();
            
            System.out.println("Empresa removida com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Empresa buscarEmpresa(String cnpj){
        String sql = "select * from empresa where cnpj = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);){
            stmt.setString(1, cnpj);

            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idEmrepsa = rs.getInt("idempresa");
                String nomeEmpresa = rs.getString("nome");
                String cnpjEmpresa = rs.getString("cnpj");
                String telefone =  rs.getString("telefone");
                String email = rs.getString("email");
                
                
                Empresa empresa = new Empresa();
                empresa.setId(idEmrepsa);
                empresa.setNome(nomeEmpresa);
                empresa.setCnpj(cnpjEmpresa);
                empresa.setTelefone(telefone);
                empresa.setEmail(email);

                return empresa;
            }
            rs.close();
            
            System.out.println("Empresa encontrada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
