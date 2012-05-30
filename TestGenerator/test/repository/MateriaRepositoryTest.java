
package repository;

import java.util.ArrayList;
import models.Materia;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Facensa
 */
public class MateriaRepositoryTest {
    
    public MateriaRepositoryTest() {
    }
  
    @Test
    public void testAlterarMateriaDeveRetornarTrue()
    {
        System.out.println("AlterarMateria");
        MateriaRepository instance = new MateriaRepository();        
        
        Materia materia = instance.BuscarMateria("LPII");
        materia.Descricao("LP2");
        
        boolean ret = instance.AlterarMateria(materia);        
        assertEquals(true, ret);        
        
        materia = instance.BuscarMateria("LP2");
        materia.Descricao("LPII");        
        ret = instance.AlterarMateria(materia);        
    }
    
    @Test
    public void testBuscarMateriasDeveRetornarMaisQueZero() {
        System.out.println("BuscarMaterias");
        MateriaRepository instance = new MateriaRepository();        
        ArrayList result = instance.BuscarMaterias();        
        assertNotSame(0, result.size());        
    }
    
    @Test
    public void testBuscarMateriaPorDesc() {
        System.out.println("BuscarMateriaPorId");        
        MateriaRepository instance = new MateriaRepository();
                
        Materia result =  instance.BuscarMateria("LPI");        
        Materia expect = null;        
        
        assertNotSame(expect, result);                
    }
    
    @Test
    public void testExcluirMateriaPorId() {
        System.out.println("ExcluirMateria");        
        MateriaRepository instance = new MateriaRepository();
        boolean expResult = true;
        boolean result = instance.ExcluirMateria(11);
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testSalvarMateria() {
        System.out.println("SalvarMateria");
        Materia materia = new Materia(11, "Teste");
        MateriaRepository instance = new MateriaRepository();
        instance.SalvarMateria(materia);
        
        Materia result = instance.BuscarMateria(materia.Descricao());        
        assertEquals(materia.Id(), result.Id());                
    }
}
