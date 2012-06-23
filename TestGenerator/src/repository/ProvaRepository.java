package repository;

import contracts.IPergunta;
import contracts.IProva;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import models.*;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Pablo Feijó
 */
public class ProvaRepository implements IProva {
                                 
    public ProvaRepository(IPergunta _srvPergunta) {        
        srvPergunta = _srvPergunta;
    }
    
    private String filePath = "provas.xml";
    IPergunta srvPergunta;
    
    @Override
    public void SalvarProva(Prova prova) 
    {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(filePath);
        
        try {

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("prova");
            Element _prova = new Element("prova");       
            
            _prova.setAttribute("id", Integer.toString(prova.Id()));
            _prova.setAttribute("materia", prova.Materia().Descricao());
            _prova.setAttribute("professor", prova.NomeProfessor()); 
            _prova.setAttribute("data", prova.Data()); 
            
            this.AdicionarPerguntas(prova, _prova);
            rootNode.addContent(_prova);

            XMLOutputter xmlOutput = new XMLOutputter();
            Format format = Format.getPrettyFormat();
            format.setEncoding("UTF-8");
            xmlOutput.setFormat(format);
            xmlOutput.output(document, new FileWriter(filePath));         
            
        } catch (IOException | JDOMException io) {
            System.out.println(io.getMessage());            
        }       
    }
    
    @Override
    public boolean AlterarProva(Prova prova) {        
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(filePath);
        boolean ret = false;
        try {

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("prova");
            for (int i = 0; i < list.size(); i++) {
                Element _prova = (Element) list.get(i);                           
                int id = Integer.parseInt(_prova.getAttributeValue("id"));
                if (prova.Id() == id) {                    
                    //rootNode.removeContent(_prova);
                                
                    //_prova = new Element("prova");
                    _prova.setAttribute("id", Integer.toString(prova.Id()));
                    _prova.setAttribute("materia", prova.Materia().Descricao());
                    _prova.setAttribute("professor", prova.NomeProfessor()); 
                    _prova.setAttribute("data", prova.Data()); 
                    
                    this.AdicionarPerguntas(prova, _prova);

                    //rootNode.addContent(i, _prova);

                    XMLOutputter xmlOutput = new XMLOutputter();
                    Format format = Format.getPrettyFormat();
                    format.setEncoding("UTF-8");
                    xmlOutput.setFormat(format);
                    xmlOutput.output(document, new FileWriter(filePath));   
                    
                    ret = true;
                }                
            }
            return ret;
            
        } catch (IOException | JDOMException io) {
            System.out.println(io.getMessage());
            return false;
        }   
    }
    
    private void AdicionarPerguntas(Prova prova, Element _prova)
    {
        for (Pergunta pergunta : prova.BuscarPerguntas()) {
            Element _pergunta = new Element("pergunta");            
            
            _pergunta.setAttribute("descricao", pergunta.Descricao());
            _pergunta.setAttribute("nivel", pergunta.Nivel().toString());                        
            _pergunta.setAttribute("materia", pergunta.Materia().Descricao());                        
            
            this.AdicionarRespostas(pergunta, _pergunta);
            
            _prova.addContent(_pergunta);
        }
    }
    
    private void AdicionarRespostas(Pergunta pergunta, Element _pergunta)
    {
        for (Resposta resposta : pergunta.BuscarRespostas()) {
            Element _resposta = new Element("resposta");            
            _resposta.setAttribute("descricao", resposta.Descricao());
            _resposta.setAttribute("correta", resposta.RespostaCorreta());                        
            _pergunta.addContent(_resposta);
        }
    }
    
    @Override
    public Prova BuscarProva(int id) {
        for (Prova prova : this.BuscarProvas()) {
            if (prova.Id() == id) {
                return prova;
            }
        }
        
        return null;
    }
    
    @Override
    public boolean ExcluirProva(Prova prova) {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(filePath);
        try {

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("prova");
            
            for (int i = 0; i < list.size(); i++) {
                Element _prova = (Element) list.get(i);                           
                int id = Integer.parseInt(_prova.getAttributeValue("id"));
                if (prova.Id() == id) {                    
                    rootNode.removeContent(_prova);
                                
                    XMLOutputter xmlOutput = new XMLOutputter();
                    Format format = Format.getPrettyFormat();
                    format.setEncoding("UTF-8");
                    xmlOutput.setFormat(format);
                    xmlOutput.output(document, new FileWriter(filePath));   
                    
                    return true;
                }                
            }
            return false;
            
        } catch (IOException | JDOMException io) {
            System.out.println(io.getMessage());
            return false;
        }   
    }
    
    @Override
    public ArrayList<Prova> BuscarProvas()
    {
        ArrayList<Prova> provas = new ArrayList<>();
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(filePath);

        try {
            
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List _provas = rootNode.getChildren("prova");            
            BuscarProvasXml(_provas, provas);
            
        } catch (IOException | JDOMException io) {
            System.out.println(io.getMessage());
        }

        return provas;
    }

    private void BuscarProvasXml(List _provas, ArrayList<Prova> provas) {
        MateriaRepository srvMat = new MateriaRepository();            
        
        for (int i = 0; i < _provas.size(); i++) {                
            Element nodeProva = (Element) _provas.get(i);               
            List _perguntas = nodeProva.getChildren("pergunta");                
            
            int id = Integer.parseInt(nodeProva.getAttributeValue("id"));
            String professor = nodeProva.getAttributeValue("professor");
            String data = nodeProva.getAttributeValue("data");
            Materia materia = srvMat.BuscarMateria(nodeProva.getAttributeValue("materia"));  
            Prova prova = new Prova(materia, id, professor, data);
            BuscarPerguntasXml(_perguntas, materia, prova);
            
            provas.add(prova);
        }
    }

    private void BuscarPerguntasXml(List _perguntas, Materia materia, Prova prova) {
        for (int j = 0; j < _perguntas.size(); j++) {
            Element nodePergunta = (Element) _perguntas.get(j);  
            List _respostas = nodePergunta.getChildren("resposta");  
            
            String desc = nodePergunta.getAttributeValue("descricao");                                                                                      
            Nivel nivel = Nivel.RetornaNivel(nodePergunta.getAttributeValue("nivel"));                                                                    
            Pergunta pergunta = new Pergunta(materia, desc, nivel);
            BuscarRespostasXml(_respostas, pergunta);
            prova.AdicionarPergunta(pergunta);                    
        }
    }

    private void BuscarRespostasXml(List _respostas, Pergunta pergunta) {
        String desc;
        for (int k = 0; k < _respostas.size(); k++) {
            Element nodeResposta = (Element) _respostas.get(k);                          
            desc = nodeResposta.getAttributeValue("descricao");                                                                                      
            boolean correta = nodeResposta.getAttributeValue("correta").equals("sim") ? true : false;    
            Resposta resposta = new Resposta(desc, correta);
            pergunta.AdicionarResposta(resposta);                                                
        }
    }
    
    @Override
    public void GerarGabarito(Prova prova) {
        try {
            Date dataAtual = new Date();            
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String nomeArquivo = "Gabarito_Prova_" + prova.Id() + "_" + dateFormat.format(dataAtual) + ".txt";                        
            File f = new File (nomeArquivo);
            FileWriter fr = new FileWriter (f);
            PrintWriter out = new PrintWriter (fr);            
            
            StringBuffer texto = new StringBuffer();  
            texto.append("Curso: Sistemas de Informação\r\n");
            texto.append(String.format("Disciplina: %s\r\n", prova.Materia().Descricao()));
            texto.append(String.format("Data: %s\r\n", dateFormat.format(dataAtual)));
            texto.append(String.format("Professor: %s\r\n", prova.NomeProfessor()));
            texto.append("Aluno: \r\n");
            texto.append("Nota: \r\n \r\n");
            texto.append(" - Prova - \r\n \r\n");
            texto.append("Assinale a alternativa correta:\r\n \r\n");
                                                                      
            int nro = 1;
            for (Pergunta pergunta : prova.BuscarPerguntas()) {
                texto.append(String.format("%s. %s \r\n", nro, pergunta.Descricao()));
                             
                for (Resposta resposta : pergunta.BuscarRespostas()) {                    
                    if(resposta.Correta()) {
                        texto.append(String.format("(X) %s \r\n", resposta.Descricao()));                    
                    }else       
                    {
                        texto.append(String.format("( ) %s \r\n", resposta.Descricao()));                    
                    }
                }                
                nro +=1;                
                texto.append("\r\n \r\n");
            }
            
            out.println (texto.toString());
            out.close();
            
        } catch (IOException e) {
            System.out.println ("Erro ao escrever arquivo.");
        }      
    }

    @Override
    public void GerarProva(Prova prova) {
        try {
            Date dataAtual = new Date();            
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String nomeArquivo = "Prova_" + prova.Id() + "_" + dateFormat.format(dataAtual) + ".txt";                        
            File f = new File (nomeArquivo);
            FileWriter fr = new FileWriter (f);
            PrintWriter out = new PrintWriter (fr);            
            
            StringBuffer texto = new StringBuffer();  
            texto.append("Curso: Sistemas de Informação\r\n");
            texto.append(String.format("Disciplina: %s\r\n", prova.Materia().Descricao()));
            texto.append(String.format("Data: %s\r\n", prova.Data()));
            texto.append(String.format("Professor: %s\r\n", prova.NomeProfessor()));
            texto.append("Aluno: \r\n");
            texto.append("Nota: \r\n \r\n");
            texto.append(" - Prova - \r\n \r\n");
            texto.append("Assinale a alternativa correta:\r\n \r\n");
                                                                      
            int nro = 1;
            for (Pergunta pergunta : prova.BuscarPerguntas()) {
                texto.append(String.format("%s. %s \r\n", nro, pergunta.Descricao()));
                             
                for (Resposta resposta : pergunta.BuscarRespostas()) {
                    texto.append(String.format("( ) %s \r\n", resposta.Descricao()));                    
                }                
                nro +=1;                
                texto.append("\r\n \r\n");
            }
            
            out.println (texto.toString());
            out.close();
            
        } catch (IOException e) {
            System.out.println ("Erro ao escrever arquivo.");
        }            
    }        
    
     @Override
    public Prova GerarProva(String nomeProfessor, Materia materia, Nivel nivel, String data, int Quantidade) {
        ArrayList<Pergunta> perguntas = this.BuscarPeguntasFiltradas(materia, nivel);
            
         if (perguntas.isEmpty()) {
             return null;
         }
        
        int id = this.RetornaProximoIndice();       
        Prova prova = new Prova(materia, id, nomeProfessor, data);
        
        Random randomGenerator = new Random();
        ArrayList<Integer> idxPerguntas = new ArrayList<>();
        
         if (Quantidade > perguntas.size()) {
             Quantidade = perguntas.size();
         }
        for (int i = 0; i < Quantidade; i++) {
            int index = buscarNumeroRandom(randomGenerator, perguntas.size(), idxPerguntas);            
            Pergunta pergunta = perguntas.get(index);
            prova.AdicionarPergunta(pergunta);
        }
        
         if (prova.BuscarPerguntas().isEmpty()) 
             return null;
         
        return prova;
    }
    
    
    public int RetornaProximoIndice()
    {
        int idx = 1;
        
        ArrayList<Prova> provas = this.BuscarProvas();                
        
        for(Prova prova : provas)
        {            
            if (idx <= prova.Id() ) 
                idx = prova.Id() + 1;
        }            
        
        return idx;
    }
     
    private ArrayList<Pergunta> BuscarPeguntasFiltradas(Materia materia, Nivel nivel)
    {
         ArrayList<Pergunta> perguntas = srvPergunta.BuscarPerguntas();
         ArrayList<Pergunta> perguntasFiltradas = new ArrayList<>();
                  
         for (Pergunta pergunta : perguntas) {
             boolean mesmoNivel = pergunta.Nivel().equals(nivel);
             boolean mesmaMateria = pergunta.Materia().Descricao().equals(materia.Descricao());
             if (mesmoNivel && mesmaMateria) {
                 perguntasFiltradas.add(pergunta);
             }
        }         
         return perguntasFiltradas; 
    }
    
    private int buscarNumeroRandom(Random randomGenerator, int qtd, ArrayList<Integer> idxPerguntas)
    {                        
        int index = randomGenerator.nextInt(qtd);
        if (idxPerguntas.contains(index)) {
            index = buscarNumeroRandom(randomGenerator, qtd, idxPerguntas);
        }        
        return index;
    }
}
