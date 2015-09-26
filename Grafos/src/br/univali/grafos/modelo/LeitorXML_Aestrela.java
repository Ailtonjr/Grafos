package br.univali.grafos.modelo;

import static br.univali.grafos.principal.LeitorXml.removeComentariosXML;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeitorXML_Aestrela {

    private List<String> xml = new ArrayList();
    private int linhas = 0;
    private int colunas = 0;
    private Elemento[][] matriz;
    private String[] vet;

    public Elemento[][] montaMatriz() {
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

                matriz = new Elemento[linhas][colunas];
                
                // Inicializando a matriz
                for (int i = 0; i < linhas; i++) {
                    for (int j = 0; j < colunas; j++) {
                        matriz[i][j] = new Elemento(i, j);
                    }
                }

                nodes = doc.getElementsByTagName("INICIAL");
                vet = nodes.item(0).getTextContent().split(",");
                
                matriz[Integer.parseInt(vet[0])][Integer.parseInt(vet[1])].setTipo("Inicial");

                nodes = doc.getElementsByTagName("FINAL");
                vet = nodes.item(0).getTextContent().split(",");
                matriz[Integer.parseInt(vet[0])][Integer.parseInt(vet[1])].setTipo("Final");

                nodes = doc.getElementsByTagName("MURO");
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    vet = node.getTextContent().split(",");
                    matriz[Integer.parseInt(vet[0])][Integer.parseInt(vet[1])].setTipo("Muro");
                }
                System.out.println("Leitura do XML Completa");
                for (int i = 0; i < linhas; i++) {
                    for (int j = 0; j < colunas; j++) {
                        System.out.print(matriz[i][j].getTipo() + "\t");
                    }
                    System.out.println("");
                }
                return matriz; 
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
