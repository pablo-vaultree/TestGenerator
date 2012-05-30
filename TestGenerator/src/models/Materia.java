package models;

/**
 *
 * @author Pablo Feijó
 */
public class Materia {

    public Materia(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    private int id;
    private String descricao;
    
    // <editor-fold defaultstate="collapsed" desc=" Gets e Sets ">
    public String Descricao() {
        return descricao;
    }

    public void Descricao(String descricao) {
        this.descricao = descricao;
    }

    public int Id() {
        return id;
    }

    public void Id(int id) {
        this.id = id;
    }
    // </editor-fold>
}
