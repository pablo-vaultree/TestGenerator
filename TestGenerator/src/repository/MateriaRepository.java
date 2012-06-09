package repository;

import contracts.IMateria;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.Materia;
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
public class MateriaRepository implements IMateria {
        
    public MateriaRepository() {
    }
    
    private String filePath = "materia.xml";
    
    @Override
    public boolean AlterarMateria(Materia materia) {
        try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(filePath);
            Document doc = (Document) builder.build(xmlFile);                        
            AlterarMateria(doc, materia);
            
            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(filePath));
            
            return true;
        } catch (IOException | JDOMException io) {
            //TODO: Logar erro
            return false;
        }  
    }

    private void AlterarMateria(Document doc, Materia materia) {
        Element rootNode = doc.getRootElement();
        List list = rootNode.getChildren("materia");
        for (int i = 0; i < list.size(); i++) {
            Element node = (Element) list.get(i);
            int _id = Integer.parseInt(node.getAttributeValue("codigo"));
            if (materia.Id() == _id) {
                int id = Integer.parseInt(node.getAttributeValue("codigo"));
                String desc = node.getAttributeValue("descricao");               
                node.setAttribute("descricao", materia.Descricao());
                //rootNode.addContent(node);
            }            
        }                
    }
    
    @Override
    public ArrayList<Materia> BuscarMaterias() {

        ArrayList<Materia> materias = new ArrayList<>();
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(filePath);

        try {

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("materia");

            for (int i = 0; i < list.size(); i++) {

                Element node = (Element) list.get(i);

                int id = Integer.parseInt(node.getAttributeValue("codigo"));
                String desc = node.getAttributeValue("descricao");
                Materia materia = new Materia(id, desc);
                materias.add(materia);
            }
        } catch (IOException | JDOMException io) {
            System.out.println(io.getMessage());
        }

        return materias;
    }

    @Override
    public Materia BuscarMateria(String descricao) {
        ArrayList<Materia> materias = this.BuscarMaterias();
        for (Materia materia : materias) {
            if (materia.Descricao().equals(descricao)) {
                return materia;                       
            }
        }
        return null;
    }
    
    @Override
    public Materia BuscarMateria(int id) {
        ArrayList<Materia> materias = this.BuscarMaterias();
        for (Materia materia : materias) {
            if (materia.Id() == id) {
                return materia;                       
            }
        }
        return null;
    }
    
    @Override
    public boolean ExcluirMateria(int codigo) {
        
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(filePath);

        try {

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("materia");

            for (int i = 0; i < list.size(); i++) {

                Element node = (Element) list.get(i);
                
                int id = Integer.parseInt(node.getAttributeValue("codigo"));
                if (id == id) {
                    rootNode.removeContent(node);
                    return true;                           
                }
                                
            }
        } catch (IOException | JDOMException io) {
            System.out.println(io.getMessage());
        }

        return false;
    }

    @Override
    public void SalvarMateria(Materia materia) {
        try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(filePath);
            Document doc = (Document) builder.build(xmlFile);

            Element rootNode = doc.getRootElement();
            Element _materia = new Element("materia");
            _materia.setAttribute("codigo", Integer.toString(materia.Id()));
            _materia.setAttribute("descricao", materia.Descricao());

            rootNode.addContent(_materia);

            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(filePath));

        } catch (IOException | JDOMException io) {
            //TODO: Logar erro
        }        
    }
}
