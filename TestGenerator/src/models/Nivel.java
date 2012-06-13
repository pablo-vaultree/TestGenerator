package models;

/**
 *
 * @author Pablo Feijó
 */
public enum Nivel {
    FACIL, MEDIO, DIFICIL;
    
    @Override 
    public String toString() {  
        return super.toString().toLowerCase();        
    }
    
    public static Nivel RetornaNivel(String nivel)
    {
        switch(nivel)
        {
            case "facil": 
            case "Fácil":
                return Nivel.FACIL;
            case "medio": 
            case "Médio": 
                return Nivel.MEDIO;
            case "dificil": 
            case "Difícil": 
                return Nivel.DIFICIL;
            default: return Nivel.FACIL;
        } 
    }
}
