/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radio;


import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.HashMap;
import radio.HDSObjects.HDSData;

/**
 *
 * @author mgkersloot | nahirzalla
 */
public class XMLParser {
    private Element docEle;
    public static final int TEXT_NODE = 3;
    public HDSData testiets;
    
    public XMLParser(String fileName)
    {
        try {
            File file = new File(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            docEle = doc.getDocumentElement();
            
            //System.out.println(docEle.getTagName());
            //HashMap map = createMap();
            
        }
        catch (Exception e) {
            e.printStackTrace();           
        }
    }
    
    // Haalt een element op uit een XML file
    public NodeList getElements()
    {
        return docEle.getChildNodes();
    }
    
    public NodeList getElement(String name)
    {
        return docEle.getElementsByTagName(name);
    }
    
    public void getElementsByNode(Node node) {
        // Get data of this node
        String name = node.getNodeName().trim();
        String value = "";
        if (node instanceof Text) {
            value = node.getNodeValue().trim();
            name = "";
        }
        
        if(name.contains("DH"))
        {
            System.out.println("a");
        }
        
        if(node.hasAttributes())
        {
            NamedNodeMap attributes = node.getAttributes();
            for(int i = 0; i< attributes.getLength(); i++){
                Node attribute = attributes.item(i);
                String attributeName = attribute.getNodeName().trim();
                String attributeValue = attribute.getNodeValue().trim();
                testiets.addValue(attributeName, attributeValue);
                if(!attributeValue.equals("")) System.out.println(" - " + attributeName + "\t" + attributeValue);
            }        
        }
        if(node.hasChildNodes())
        {
            // Get children of this node
            NodeList children = node.getChildNodes();
            if(children.getLength() == 1)
            {
                Node firstNode = children.item(0);
                if(firstNode.getNodeType() == TEXT_NODE)
                {
                    value = firstNode.getNodeValue().trim();
                }
            }
            else
            {
                // Loop through the children of this node
                for(int i = 0; i < children.getLength(); i++)
                {
                    Node child = children.item(i);
                    getElementsByNode(child);
                }
            }
        }
        
        if(!value.isEmpty() || !name.isEmpty()) System.out.println(name + " \t\t " + value);
    }
    
    public void printAll()
    {
        NodeList elements  = docEle.getChildNodes();
        for(int i = 0; i< elements.getLength(); i++)
        {
            Node node = elements.item(i);
            getElementsByNode(node);
        }
    }
    
    public void printAll(String name)
    {
        NodeList elements  = docEle.getElementsByTagName(name);
        for(int i = 0; i< elements.getLength(); i++)
        {
            Node node = elements.item(i);
            getElementsByNode(node);
        }
    }
}

