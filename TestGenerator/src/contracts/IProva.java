
package contracts;

import java.util.ArrayList;
import models.Materia;
import models.Nivel;
import models.Prova;

/**
 *
 * @author Pablo Feijó
 */
public interface IProva {
    
    public ArrayList<Prova> BuscarProvas();        
    
    public Prova BuscarProva(int id);        
    
    public void SalvarProva(Prova prova);
    
    public boolean AlterarProva(Prova prova);
    
    public boolean ExcluirProva(Prova prova);
            
    public void GerarProva(Prova prova);
    
    public Prova GerarProva(String nomeProfessor, Materia materia, Nivel nivel, String data, int Quantidade);
    
    public void GerarGabarito(Prova prova);
}
