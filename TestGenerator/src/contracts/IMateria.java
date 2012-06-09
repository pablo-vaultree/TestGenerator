/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contracts;

import java.util.ArrayList;
import models.Materia;

/**
 *
 * @author Pablo Feijó
 */
public interface IMateria {
    
    public ArrayList<Materia> BuscarMaterias();
    
    public Materia BuscarMateria(String descricao);
    
    public Materia BuscarMateria(int id);
    
    public void SalvarMateria(Materia materia);
    
    public boolean AlterarMateria(Materia materia);
    
    public boolean ExcluirMateria(int codigo);
}
