/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import contracts.IMateria;
import contracts.IPergunta;
import java.util.ArrayList;
import models.Materia;
import models.Nivel;
import models.Pergunta;
import models.Resposta;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author datacom
 */
public class PerguntaRepositoryTest {
    
    IPergunta srvPergunta;
    IMateria srvMateria;
    
    public PerguntaRepositoryTest() {
        srvMateria = new MateriaRepository();
        srvPergunta = new PerguntaRepository(srvMateria);
    }
    
    @Test
    public void testSalvarPergunta() {
        System.out.println("SalvarPergunta");
       
        MateriaRepository srvMat = new MateriaRepository();        
        ArrayList perguntasAnt =  srvPergunta.BuscarPerguntas();
        Pergunta pergunta = GerarPergunta(srvMat);
                
        srvPergunta.SalvarPergunta(pergunta);
        
        ArrayList perguntasdps =  srvPergunta.BuscarPerguntas();
        
        assertNotSame(perguntasAnt.size(), perguntasdps.size());
    }
    
    private Pergunta GerarPergunta(MateriaRepository srvMat) {
        Materia materia = srvMat.BuscarMateria("LPII");
        String desc = "Quão dificil é progaramar JAVA?";
        Pergunta pergunta = new Pergunta(materia, desc, Nivel.DIFICIL);
        for (int i = 0; i < 4; i++) {            
            Resposta resposta = new Resposta("Facil " + i, i == 0);
            pergunta.AdicionarResposta(resposta);
        }
        return pergunta;
    }
            
    @Test
    public void testBuscarPergunta() {
        System.out.println("BuscarPergunta");
        int idx = 1;      
        Pergunta result = srvPergunta.BuscarPergunta(idx);        
        assertNotNull(result);        
    }           
    
    public void testAlterarPergunta() {
        System.out.println("AlterarPergunta");        
        
        Pergunta pergunta = srvPergunta.BuscarPergunta(3);        
        pergunta.Descricao("C# é mais facil?");        
        Resposta resposta = new Resposta("SIM!", true);
        pergunta.AlterarResposta(1, resposta);
                
        boolean expResult = true;
        boolean result = srvPergunta.AlterarPergunta(2, pergunta);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testExcluirPergunta() {
        System.out.println("ExcluirPergunta");
        int idx = 4;
        boolean expResult = true;
        boolean result = srvPergunta.ExcluirPergunta(idx);
        assertEquals(expResult, result);      
    }
 
    @Test
    public void testBuscarPerguntasDeveRetornarMaisQueZero() {
        System.out.println("BuscarPerguntas");
        ArrayList expResult = new ArrayList<>();
        ArrayList result = srvPergunta.BuscarPerguntas();
        assertNotSame(expResult.size(), result.size());       
    }
    
    
    @Test
    public void testPerguntaDevePossuirQuatroRespostas() {
        System.out.println("BuscarPerguntas");
        ArrayList expResult = new ArrayList<>();
        
        Pergunta pergunta = srvPergunta.BuscarPergunta(1);
        
        assertNotSame(expResult.size(), pergunta.BuscarRespostas().size());
        System.out.println(pergunta.BuscarRespostas().size());
    }
    
    @Test
    public void testBuscarPerguntas() {
        System.out.println("BuscarPerguntas");       
        ArrayList expResult = new ArrayList<>();
        ArrayList result = srvPergunta.BuscarPerguntas();
        assertNotSame(expResult.size(), result.size());        
    }
}
