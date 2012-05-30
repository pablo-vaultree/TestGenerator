package models;

import java.util.ArrayList;

/**
 *
 * @author Pablo Feijó
 */
public class Prova {

    public Prova(models.Materia materia, int id, String nomeProfessor) {
        this.materia = materia;
        this.id = id;
        this.nomeProfessor = nomeProfessor;
        this.perguntas = new ArrayList<>();
    }
           
    private Materia materia;
    private int id;
    private String nomeProfessor;
    private ArrayList<Pergunta> perguntas;
    
    // <editor-fold defaultstate="collapsed" desc=" Gets e Sets ">
    public int Id() {
        return id;
    }

    public void Id(int id) {
        this.id = id;
    }

    public Materia Materia() {
        return materia;
    }

    public void Materia(Materia materia) {
        this.materia = materia;
    }

    public String NomeProfessor() {
        return nomeProfessor;
    }

    public void NomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public ArrayList<Pergunta> BuscarPerguntas() {
        return perguntas;
    }

    public void AdicionarPergunta(Pergunta pergunta) {
        this.perguntas.add(pergunta);
    }
    
    // </editor-fold >
}
