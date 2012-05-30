package models;

import java.util.ArrayList;

/**
 *
 * @author Pablo Feijó
 */
public class Pergunta {
    
    private Materia materia;    
    private ArrayList<Resposta> respostas;  
    private String descricao;    
    private Nivel nivel;
    
    public Pergunta(Materia materia, String descricao, Nivel nivel) {
        this.materia = materia;
        this.respostas = new ArrayList<>();
        this.descricao = descricao;
        this.nivel = nivel;
    }
    
     public ArrayList<Resposta> BuscarRespostas() {
        return respostas;
    }

    public void AdicionarResposta(Resposta resposta) {
        this.respostas.add(resposta);
    }
    
    public void AlterarResposta(int idx, Resposta _resposta) {
        respostas.remove(idx);
        respostas.add(idx, _resposta);
    }
    
    public void RemoverResposta(Resposta _resposta) {
        for (Resposta resposta : respostas) {
            if (resposta.Descricao().equals(_resposta.Descricao()) ) {
                respostas.remove(resposta);
            }
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc=" Gets e Sets ">
    public String Descricao() {
        return descricao;
    }

    public void Descricao(String descricao) {
        this.descricao = descricao;
    }

    public Materia Materia() {
        return materia;
    }

    public void Materia(Materia materia) {
        this.materia = materia;
    }

    public Nivel Nivel() {
        return nivel;
    }

    public void Nivel(Nivel nivel) {
        this.nivel = nivel;
    }  
    //</editor-fold>
}

