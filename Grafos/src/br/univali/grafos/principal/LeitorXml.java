package br.univali.grafos.principal;



import java.io.*;
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
    
    
    static Grafo grafo = null;
    public LeitorXml() {
        grafo = new Grafo();
    }
    
    public static void removeComentariosXML(String path) {
        File file = new File(path);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            List<String> linhas = new ArrayList();

            String linha = br.readLine();

            while (linha != null) {             // Leitura
                if (!linha.contains("<!--")) {
                    linhas.add(linha);
                }
                //System.out.println(linha);      // LOG
                linha = br.readLine();
            }
            
            FileWriter fw = new FileWriter(path);
            for (String l : linhas) {           // Escrita
                fw.write(l + "\n");
            }
            
            fr.close();
            br.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Object grafoFromXML() {
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
                NodeList nodes = doc.getElementsByTagName("Vertice");
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        int relId = Integer.parseInt(element.getAttribute("relId"));
                        String rotulo = element.getAttribute("rotulo");
                        int posX = Integer.parseInt(element.getAttribute("posX"));
                        int posY = Integer.parseInt(element.getAttribute("posY"));
                        grafo.adicionarVertice( rotulo, relId);
                    }
                }
                nodes = doc.getElementsByTagName("Aresta");
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        int idVertice1 = Integer.parseInt(element.getAttribute("idVertice1"));
                        int idVertice2 = Integer.parseInt(element.getAttribute("idVertice2"));
                        double peso = Double.parseDouble(element.getAttribute("peso"));
                        grafo.adicionarArco(idVertice1, idVertice2, peso);
                    }
                }
                System.out.println("Leitura do XML Completa");
                return grafo; 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Leitura, Remova os comentários do XML ou escolha outro arquivo");
                System.err.println(ex);
            }
        }
        return null;
    }
}
