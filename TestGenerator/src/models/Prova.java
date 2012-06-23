package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Feijó
 */
public class Prova {

    public Prova(Materia materia, int id, String nomeProfessor, String data){
        this.materia = materia;
        this.id = id;
        this.nomeProfessor = nomeProfessor;
        this.perguntas = new ArrayList<>();
        this.Data(data);
    }
           
    private Materia materia;
    private int id;
    private String nomeProfessor;
    private ArrayList<Pergunta> perguntas;
    private Date data;
    
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
    
    public void Data(String data)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.data = dateFormat.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Prova.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Data(Date data)
    {
        this.data = data;
    }
    
    public String Data()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(this.data);
    }
    
    // </editor-fold >
}
