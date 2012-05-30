package repository;

import contracts.IMateria;
import contracts.IPergunta;
import contracts.IProva;
import java.util.ArrayList;
import models.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Facensa
 */
public class ProvaRepositoryTest {
    
    IPergunta srvPergunta;
    IMateria srvMateria;
    IProva srvProva;
    
    public ProvaRepositoryTest() {
        srvMateria = new MateriaRepository();
        srvPergunta = new PerguntaRepository(srvMateria);
        srvProva = new ProvaRepository(srvPergunta);
    }
    
    @Test
    public void testSalvarProva() {
        System.out.println("SalvarProva");
        
        
        int id = srvProva.BuscarProvas().size() + 1;        
        MateriaRepository srvMat = new MateriaRepository();
        Materia materia = srvMat.BuscarMateria("LPIII");        
        Prova prova = new Prova(materia, id, "Cuzao Master");
        
        for (int i = 0; i < 5; i++) {
            Pergunta pergunta = new Pergunta(materia, "Facil " + i + "?", Nivel.FACIL);            
            for (int j = 0; j < 5; j++) {
                if (j == 0) 
                    pergunta.AdicionarResposta(new Resposta("Facil " + j, true));
                else
                    pergunta.AdicionarResposta(new Resposta("Facil " + j, false));
            }
            prova.AdicionarPergunta(pergunta);
        }
                
        srvProva.SalvarProva(prova);
        
        prova = srvProva.BuscarProva(id);
        assertNotNull(prova);
        
    }
    
    @Test
    public void testBuscarProvas() {
        System.out.println("BuscarProvas");
        
        ArrayList expResult = new ArrayList<>();
        ArrayList result = srvProva.BuscarProvas();
        assertNotSame(expResult.size(), result.size());        
    }
    
    @Test
    public void testBuscarProva() {
        System.out.println("BuscarProva");
        int id = 1;
        
        Prova expResult = null;
        Prova result = srvProva.BuscarProva(id);
        assertNotSame(expResult, result);        
    }
            
    @Test
    public void testAlterarProva() {
        System.out.println("AlterarProva");        
        
        MateriaRepository srvMat = new MateriaRepository();
        
        Materia mat = srvMat.BuscarMateria("LPI");
        
        Prova prova = srvProva.BuscarProva(1);                
        prova.NomeProfessor("cuzao666");
        prova.Materia(mat);
        
        boolean expResult = true;
        boolean result = srvProva.AlterarProva(prova);
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testExcluirProva() {
        System.out.println("ExcluirProva");
        
        int id = srvProva.BuscarProvas().size();        
        Prova prova = srvProva.BuscarProva(id);
        
        boolean expResult = true;
        boolean result = srvProva.ExcluirProva(prova);
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testGerarProva() {
        System.out.println("GerarProva");                
        int quantidade = 2;
        Materia materia = srvMateria.BuscarMateria("LPII");        
        Prova prova = srvProva.GerarProva("Cuzao", materia, Nivel.FACIL, quantidade);                
        assertNotNull(prova); 
    }   
    
    @Test
    public void testGerarProvaDeveRetornarProvaComPerguntas() {
        System.out.println("testGerarProvaDeveRetornarProvaComPerguntas");                
        int quantidade = 1;
        Materia materia = srvMateria.BuscarMateria("LPII");        
        Prova prova = srvProva.GerarProva("Cuazao", materia, Nivel.FACIL, quantidade);                
        assertEquals(quantidade, prova.BuscarPerguntas().size()); 
    }   
    
    @Test
    public void testGerarGabarito() {
        System.out.println("GerarGabarito");
        Prova prova = null;
        
        srvProva.GerarGabarito(prova);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGerarProva_Arquivo() {
        System.out.println("GerarProva");
        Prova prova = null;
        
        srvProva.GerarProva(prova);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }    
}
