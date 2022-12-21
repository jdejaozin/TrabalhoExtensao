/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author jp_te
 */
public class Turma {
    
    private int idTurma;
    private Curso curso;
    private LocalDateTime data;
    
    public Turma(){
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public Curso getCurso() {
        return curso;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idTurma;
        hash = 83 * hash + Objects.hashCode(this.curso);
        hash = 83 * hash + Objects.hashCode(this.data);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (this.idTurma != other.idTurma) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nId da turma = " + idTurma + 
                "\nCurso = " + curso.getNome() + 
                "\nData de ministração = " + data;
    }
}
