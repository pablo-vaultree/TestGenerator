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
            case "facil": return Nivel.FACIL;
            case "medio": return Nivel.MEDIO;
            case "dificil": return Nivel.DIFICIL;
            default: return Nivel.FACIL;
        } 
    }
}
