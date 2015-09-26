
package br.univali.grafos.modelo;

import static br.univali.grafos.principal.LeitorXml.removeComentariosXML;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeitorXML_Aestrela {
    
    private List<String> xml = new ArrayList();
    private int linhas = 0;
    private int colunas = 0;
    private int[] inicial = new int[2];
    
    public LeitorXML_Aestrela() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Arquivo XML", "xml");
        fileChooser.setFileFilter(extensionFilter);
        File file = null;
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            removeComentariosXML(fileChooser.getSelectedFile().getPath());
            
            file = fileChooser.getSelectedFile();
            try {
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();
                NodeList nodes = doc.getElementsByTagName("LINHAS");
                linhas = Integer.parseInt(nodes.item(0).getTextContent());
                
                nodes = doc.getElementsByTagName("COLUNAS");
                colunas = Integer.parseInt(nodes.item(0).getTextContent());
                
                nodes = doc.getElementsByTagName("INICIAL");
                inicial[0] = Integer.parseInt(nodes.item(0).getTextContent());  // Arrumar
                
                
                nodes = doc.getElementsByTagName("Aresta");
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        int idVertice1 = Integer.parseInt(element.getAttribute("idVertice1"));
                        int idVertice2 = Integer.parseInt(element.getAttribute("idVertice2"));
                        double peso = Double.parseDouble(element.getAttribute("peso"));
                        //grafo.adicionarArco(idVertice1, idVertice2, peso);
                    }
                }
                System.out.println("Leitura do XML Completa");
                //return grafo; 
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
        //return null;
    }
    
    
}
