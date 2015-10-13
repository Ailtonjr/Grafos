package br.univali.grafos.controle;

import br.univali.grafos.modelo.Painel;
import static br.univali.grafos.controle.LeitorXml.removeComentariosXML;
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
    private Painel[][] paineis;
    private String[] vet;

    public Painel[][] montaMatriz() {
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

                paineis = new Painel[linhas][colunas];

                // Inicializando a matriz
                for (int lin = 0; lin < linhas; lin++) {
                    for (int col = 0; col < colunas; col++) {
                        paineis[lin][col] = new Painel(lin, col);
                    }
                }

                nodes = doc.getElementsByTagName("INICIAL");
                vet = nodes.item(0).getTextContent().split(",");

                paineis[Integer.parseInt(vet[0])][Integer.parseInt(vet[1])].setTipo("Inicial");

                nodes = doc.getElementsByTagName("FINAL");
                vet = nodes.item(0).getTextContent().split(",");
                paineis[Integer.parseInt(vet[0])][Integer.parseInt(vet[1])].setTipo("Final");

                nodes = doc.getElementsByTagName("MURO");
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    vet = node.getTextContent().split(",");
                    paineis[Integer.parseInt(vet[0])][Integer.parseInt(vet[1])].setTipo("Muro");
                }
                System.out.println("Leitura do XML Completa");
                for (int i = 0; i < linhas; i++) {
                    for (int j = 0; j < colunas; j++) {
                        System.out.print(paineis[i][j].getTipo() + "\t");
                    }
                    System.out.println("");
                }
                return paineis;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }
}
