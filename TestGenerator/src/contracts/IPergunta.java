package contracts;

import java.util.ArrayList;
import models.Pergunta;

/**
 *
 * @author Pablo Feijó
 */
public interface IPergunta {
            
    public ArrayList<Pergunta> BuscarPerguntas();
    
    public void SalvarPergunta(Pergunta pergunta);        
    
    public Pergunta BuscarPergunta(int idx);
    
    public boolean ExcluirPergunta(int idx); 
    
    public boolean AlterarPergunta(int idx, Pergunta pergunta); 
}
