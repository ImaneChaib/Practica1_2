/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica1_2;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class Practica1_2 {

    public static void main(String[] args) {
        try {
            // Carga el archivo XML en un objeto Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("Libros.xml")); // Reemplaza con la ubicación de tu archivo XML

            // Obtén el nodo raíz del documento
            Node root = doc.getFirstChild();
            NodeList nodelist = root.getChildNodes();

            for (int i = 0; i < nodelist.getLength(); i++) {
                Node nodo = nodelist.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    NamedNodeMap attributes = nodo.getAttributes();
                    String publicado = attributes.getNamedItem("publicado").getNodeValue();

                    NodeList n12 = nodo.getChildNodes();
                    String titulo = null;
                    String autor = null;
                    for (int j = 0; j < n12.getLength(); j++) {
                        Node ntemp = n12.item(j);
                        if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
                            if (ntemp.getNodeName().equals("Titulo")) {
                                titulo = ntemp.getTextContent();
                            } else if (ntemp.getNodeName().equals("Autor")) {
                                autor = ntemp.getTextContent();
                            }
                        }
                    }

                    System.out.println(  publicado + "-- " + autor + "-- " + titulo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


   
