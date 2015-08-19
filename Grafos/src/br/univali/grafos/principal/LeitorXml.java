package br.univali.grafos.principal;



import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * Use este código para criar seu grafo a partir do xml gerado na aba anterior
 * Passos: 
 *  1 - Salve o xml em um arquivo 
 *  2 - Exporte este código para seu projeto 
 *  3 - Altere o método grafoFromXML incluindo uma referência à 
 *      classe do seu grafo, conforme exemplificado no código.
 *      Apenas as linhas comentadas precisam ser alteradas.
 *  4 - Execute este código conforme demonstrado no método main, logo abaixo
 *  5 - Uma janela de seleção de arquivo abrirá, selecione o arquivo xml salvo no passo 1
 */

public class LeitorXml {
    
    
    static MeuGrafo grafo = null;
    public LeitorXml() {
        grafo = new MeuGrafo();
    }
    
    public static Object grafoFromXML() {
        //Referencie a classe do seu grafo aqui, exemplo:
        //OutroTipoDeGrafo grafo2
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Arquivo XML", "xml");
        fileChooser.setFileFilter(extensionFilter);
        File file = null;
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            try {
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();
                NodeList nodes = doc.getElementsByTagName("Vertice");
                //System.out.println("-Vertices");
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        int relId = Integer.parseInt(element.getAttribute("relId"));
                        String rotulo = element.getAttribute("rotulo");
                        int posX = Integer.parseInt(element.getAttribute("posX"));
                        int posY = Integer.parseInt(element.getAttribute("posY"));
                        //Adicione os vértices ao seu grafo aqui, exemplo:
                        grafo.adicionarVertice( rotulo, relId);
                        //grafo2.addVertice(rotulo, relId);
                        //System.out.println("relId: " + relId);
                        //System.out.println("rotulo: " + rotulo);
                        //System.out.println("posicao: " + posX + ", " + posY);
                    }
                    //System.out.println();
                }
                nodes = doc.getElementsByTagName("Aresta");
                //System.out.println("-Arestas");
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        int idVertice1 = Integer.parseInt(element.getAttribute("idVertice1"));
                        int idVertice2 = Integer.parseInt(element.getAttribute("idVertice2"));
                        double peso = Double.parseDouble(element.getAttribute("peso"));
                        //Adicione as arestas ao seu grafo aqui, exemplo:
                        grafo.adicionarArco(idVertice1, idVertice2, peso);
                        //grafo2.addAresta(idVertice1, idVertice2);
                        //System.out.println("idVertice1: " + idVertice1);
                        //System.out.println("idVertice2: " + idVertice2);
                        //System.out.println("peso: " + peso);
                    }
                    //System.out.println();
                }
                //retorne o seu grafo criado
                System.out.println("Leitura Completa");
                return grafo; 
                //return grafo2
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Leitura, Remova os comentários do XML ou escolha outro arquivo");
                System.err.println(ex);
            }
        }
        return null;
    }
}
