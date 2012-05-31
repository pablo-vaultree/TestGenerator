package models;

/**
 *
 * @author Pablo Feijó
 */
public class Resposta {

    private String descricao;
    private boolean Correta;

    public Resposta(String Descricao, boolean Correta) {
        this.descricao = Descricao;
        this.Correta = Correta;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Gets e Sets ">
    public String RespostaCorreta() {        
        return Correta ? "sim" : "nao";        
    }

    public boolean Correta() {        
        return Correta;        
    }
    
    public void RespostaCorreta(boolean Correta) {
        this.Correta = Correta;
    }

    public String Descricao() {
        return descricao;
    }

    public void Descricao(String Descricao) {
        this.descricao = Descricao;
    }
    //</editor-fold>
    
}
