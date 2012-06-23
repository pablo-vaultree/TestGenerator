
package repository;

import contracts.IMateria;
import contracts.IPergunta;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.Materia;
import models.Nivel;
import models.Pergunta;
import models.Resposta;
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
public class PerguntaRepository implements IPergunta{

    public PerguntaRepository(IMateria _srvMateria) {
        srvMateria = _srvMateria;
    }
    
    private String filePath = "perguntas.xml";
    private IMateria srvMateria;
    
    @Override
    public boolean AlterarPergunta(int idx, Pergunta pergunta) {

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(filePath);

        try {

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("pergunta");
            Element _pergunta = (Element) list.get(idx);                           
            //rootNode.removeContent(_perguntaAnt);
            
            //Element _pergunta = new Element("pergunta");
            _pergunta.setAttribute("descricao", pergunta.Descricao());
            _pergunta.setAttribute("nivel", pergunta.Nivel().toString());
            _pergunta.setAttribute("materia", pergunta.Materia().Descricao());                        
            this.AdicionarRespostas(pergunta, _pergunta);
            
            //idx++;
            //rootNode.addContent(idx, _pergunta);
            
            XMLOutputter xmlOutput = new XMLOutputter();
            Format format = Format.getPrettyFormat();
            format.setEncoding("UTF-8");
            xmlOutput.setFormat(format);
            xmlOutput.output(document, new FileWriter(filePath));
                                                          
            return  true;                    
            
        } catch (IOException | JDOMException io) {
            System.out.println(io.getMessage());
            return false;
        }   
    }

    @Override
    public Pergunta BuscarPergunta(int idx) {
        ArrayList<Pergunta> perguntas = this.BuscarPerguntas();
        
        if (perguntas.size() > 0) {
            return perguntas.get(idx);
        }
        
        return  null;
    }

    @Override
    public boolean ExcluirPergunta(int idx) {

        ArrayList<Pergunta> perguntas = new ArrayList<>();
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(filePath);

        try {

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("pergunta");
            Element node = (Element) list.get(idx);               
              
            rootNode.removeContent(node);
            
            XMLOutputter xmlOutput = new XMLOutputter();
            Format format = Format.getPrettyFormat();
            format.setEncoding("UTF-8");
            xmlOutput.setFormat(format);
            xmlOutput.output(document, new FileWriter(filePath));
            
            return  true;                    
            
        } catch (IOException | JDOMException io) {
            System.out.println(io.getMessage());
            return false;
        }                       
    }
            
    @Override
    public ArrayList<Pergunta> BuscarPerguntas() {
        ArrayList<Pergunta> perguntas = new ArrayList<>();
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(filePath);

        try {

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("pergunta");

            for (int i = 0; i < list.size(); i++) {

                Element node = (Element) list.get(i);               
                String desc = node.getAttributeValue("descricao");                
                Materia materia = this.BuscarMateria(node.getAttributeValue("materia"));                                
                Nivel nivel = Nivel.RetornaNivel(node.getAttributeValue("nivel"));                                                
                Pergunta pergunta = new Pergunta(materia, desc, nivel);
                
                this.BuscarRespostas(pergunta, node.getChildren("resposta"));
                perguntas.add(pergunta);
            }
        } catch (IOException | JDOMException io) {
            System.out.println(io.getMessage());
        }

        return perguntas;
    }
    
    @Override
    public void SalvarPergunta(Pergunta pergunta) {
        try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(filePath);
            Document doc = (Document) builder.build(xmlFile);

            Element rootNode = doc.getRootElement();
            Element _pergunta = new Element("pergunta");            
            _pergunta.setAttribute("descricao", pergunta.Descricao());
            _pergunta.setAttribute("nivel", pergunta.Nivel().toString());
            _pergunta.setAttribute("materia", pergunta.Materia().Descricao());
            
            this.AdicionarRespostas(pergunta, _pergunta);
            
            rootNode.addContent(_pergunta);
            XMLOutputter xmlOutput = new XMLOutputter();

            Format format = Format.getPrettyFormat();
            format.setEncoding("UTF-8");
            xmlOutput.setFormat(format);
            xmlOutput.output(doc, new FileWriter(filePath));

        } catch (IOException | JDOMException io) {
            //TODO: Logar erro
        }    
        
        
    }
    
    private void AdicionarRespostas(Pergunta pergunta, Element element)
    {
        for (Resposta resposta : pergunta.BuscarRespostas()) {
            Element _resposta = new Element("resposta");            
            _resposta.setAttribute("descricao", resposta.Descricao());
            _resposta.setAttribute("correta", resposta.RespostaCorreta());                        
            element.addContent(_resposta);
        }
    }
    
    private void BuscarRespostas(Pergunta pergunta, List list)
    {
        for (int i = 0; i < list.size(); i++) {
            Element node = (Element) list.get(i);               
            String desc = node.getAttributeValue("descricao");                
            boolean correta = node.getAttributeValue("correta").equals("sim") ? true : false;                                                            
            Resposta resposta = new Resposta(desc, correta);
            pergunta.AdicionarResposta(resposta);
        }
    }
    
    private Materia BuscarMateria(String desc){
        return srvMateria.BuscarMateria(desc);
    }            
}
