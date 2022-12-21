/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import DAO.DAOAluno;
import DAO.DAOCurso;
import DAO.DAOEmpresa;
import DAO.DAOTurma;
import Entities.Aluno;
import Entities.Curso;
import Entities.Empresa;
import Entities.Turma;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jp_te
 */
public class Interface {
    
    private int op;
    private StringBuilder builder = new StringBuilder();
    private DAOAluno daoAluno = new DAOAluno();
    private DAOCurso daoCurso = new DAOCurso();
    private DAOEmpresa daoEmpresa = new DAOEmpresa();
    private DAOTurma daoTurma = new DAOTurma();
    
    public Interface(){
    }
    
    public int telaPrincipal(){
        builder.delete(0, builder.length());
        builder.append("| CENTRECAP CURSOS |");
        builder.append("\n---------------------------");
        builder.append("\n1 - Realizar registro");
        builder.append("\n2 - Realizar uma busca");
        builder.append("\n3 - Sair");
        op = Integer.parseInt(JOptionPane.showInputDialog(builder));
        return op;
    }
    
    public int telasCadastro(){
        builder.delete(0, builder.length());
        builder.append("| CENTRECAP CURSOS |");
        builder.append("\n---------------------------");
        builder.append("\n1 - Registrar Empresa");
        builder.append("\n2 - Registrar Aluno");
        builder.append("\n3 - Registrar Turma");
        builder.append("\n4 - Registrar Curso");
        builder.append("\n5 - Sair");
        op = Integer.parseInt(JOptionPane.showInputDialog(builder));
        return op;
    }
    
    public int telasBusca(){
        builder.delete(0, builder.length());
        builder.append("| CENTRECAP CURSOS |");
        builder.append("\n---------------------------");
        builder.append("\n1 - Buscar Empresa");
        builder.append("\n2 - Buscar Aluno");
        builder.append("\n3 - Buscar Turma");
        builder.append("\n4 - Buscar Curso");
        builder.append("\n5 - Sair");
        op = Integer.parseInt(JOptionPane.showInputDialog(builder));
        return op;
    }
    
    // CADASTROS
    public void registrarEmpresa(){
        builder.delete(0, builder.length());
        builder.append("| CENTRECAP CURSOS |");
        builder.append("\n| Cadastro de empresa |");
        builder.append("\n---------------------------");
        builder.append("\nNome da empresa: ");
        String nomeEmpresa = JOptionPane.showInputDialog(builder);
        builder.append(nomeEmpresa);
        builder.append("\nCNPJ: ");
        String cnpj = JOptionPane.showInputDialog(builder);
        builder.append(cnpj);
        builder.append("\nTelefone: ");
        String telefone = JOptionPane.showInputDialog(builder);
        builder.append(telefone);
        builder.append("\nEmail");
        String email = JOptionPane.showInputDialog(builder);
        builder.append(email);
        
        daoEmpresa.criarEmpresa(nomeEmpresa, cnpj, telefone, email);
    }
    public void registrarAluno(){
        builder.delete(0, builder.length());
        builder.append("| CENTRECAP CURSOS |");
        builder.append("\n| Cadastro de aluno |");
        builder.append("\n---------------------------");
        builder.append("\nNome do aluno: ");
        String nomeAluno = JOptionPane.showInputDialog(builder);
        builder.append(nomeAluno);
        builder.append("\nCPF: ");
        String cpf = JOptionPane.showInputDialog(builder);
        builder.append(cpf);
        builder.append("\nRG: ");
        String rg = JOptionPane.showInputDialog(builder);
        builder.append(rg);
        builder.append("\nEndereço: ");
        String endereco = JOptionPane.showInputDialog(builder);
        builder.append(endereco);
        builder.append("\nData de nascimento [AAAA-MM-DD]: ");
        String dataNascimento = JOptionPane.showInputDialog(builder);
        builder.append(dataNascimento);
        builder.append("\nTelefone: ");
        String telefone = JOptionPane.showInputDialog(builder);
        builder.append(telefone);
        builder.append("\nCNPJ da empresa que o aluno pertence: ");
        String cnpj = JOptionPane.showInputDialog(builder);
        builder.append(cnpj);
        builder.append("\nId da turma do aluno: ");
        int idTurma = Integer.parseInt(JOptionPane.showInputDialog(builder));
        builder.append(idTurma);
        
        daoAluno.criarAluno(nomeAluno, cpf, rg, endereco, dataNascimento, telefone, idTurma, cnpj);
    }
    public void registrarTurma(){
        builder.delete(0, builder.length());
        builder.append("| CENTRECAP CURSOS |");
        builder.append("\n| Cadastro de turma |");
        builder.append("\n---------------------------");
        builder.append("\nId do curso a ser ministrado: ");
        int idCurso = Integer.parseInt(JOptionPane.showInputDialog(builder));
        builder.append(idCurso);
        builder.append("\nData de ministração do curso [AAAA-MM-DD]: ");
        String dataCurso = JOptionPane.showInputDialog(builder);
        builder.append(dataCurso);
        
        daoTurma.criarTurma(idCurso, dataCurso);
    }
    public void registrarCurso(){
        builder.delete(0, builder.length());
        builder.append("| CENTRECAP CURSOS |");
        builder.append("\n| Cadastro de curso |");
        builder.append("\n---------------------------");
        builder.append("\nNome do curso: ");
        String cursoNome = JOptionPane.showInputDialog(builder);
        builder.append(cursoNome);
        
        daoCurso.criarCurso(cursoNome);
    }
    
    
    
    // BUSCAS
    public void buscarEmpresa(){
        builder.delete(0, builder.length());
        builder.append("| CENTRECAP CURSOS |");
        builder.append("\n| Buscar Empresa |");
        builder.append("\n---------------------------");
        builder.append("\nCNPJ da empresa: ");
        String cnpj = JOptionPane.showInputDialog(builder);
        
        Empresa empresa = daoEmpresa.buscarEmpresa(cnpj);
        
        builder.append(empresa);
        JOptionPane.showMessageDialog (null, builder);
    }
    public void buscarAluno(){
        builder.delete(0, builder.length());
        builder.append("| CENTRECAP CURSOS |");
        builder.append("\n| Buscar Aluno |");
        builder.append("\n---------------------------");
        builder.append("\nCPF do aluno: ");
        String cpf = JOptionPane.showInputDialog(builder);
        
        Aluno aluno = daoAluno.buscarAluno(cpf);
        
        builder.append(aluno);
        JOptionPane.showMessageDialog(null, builder);
    }
    public void buscarTurma(){
        builder.delete(0, builder.length());
        builder.append("| CENTRECAP CURSOS |");
        builder.append("\n| Buscar Turma |");
        builder.append("\n---------------------------");
        builder.append("\nID da turma: ");
        int idTurma = Integer.parseInt(JOptionPane.showInputDialog(builder));
        
        Turma turma = daoTurma.buscarTurma(idTurma);
        
        builder.append(turma);
        JOptionPane.showMessageDialog(null, builder);
    }
    public void buscarCurso(){
        List<Curso> cursos;
        builder.delete(0, builder.length());
        builder.append("| CENTRECAP CURSOS |");
        builder.append("\n| Buscar Cursos |");
        builder.append("\n---------------------------");
        builder.append("\nLista de cursos ");
        
        cursos = daoCurso.listarCurso();
        
        for(Curso curso : cursos){
            builder.append(curso);
        }
        
        JOptionPane.showMessageDialog(null, builder);
    }
}
