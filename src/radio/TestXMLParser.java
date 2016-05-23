/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radio;

import org.w3c.dom.NodeList;

/**
 *
 * @author mgkersloot
 */
public class TestXMLParser {
    
    public static void main(String[] args)
    {
        XMLParser parser = new XMLParser("H:\\NetBeansProjects\\radio\\src\\radio\\2630a.xml");
        parser.printAll("DATA1");
        
        
        //NodeList data = parser.getElement("DATA1");
        //parser.printAll("REM");
         /*parser.printElements("DATA1");
        parser.printAttributes("DATA1");
        parser.printElements("IDENT");
        parser.printAttributes("IDENT");
        parser.printElements("TUMOR1");
        parser.printAttributes("TUMOR1");
        parser.printElements("TEXT1");
        parser.printAttributes("TEXT1");
        parser.printElements("HSETUP1");
        parser.printAttributes("HSETUP1");
        parser.printElements("FORMAT1");
        parser.printAttributes("FORMAT1");
        parser.printElements("DATA1");
        parser.printAttributes("DATA1");
        parser.printElements("TEXT2");
        parser.printAttributes("TEXT2");
        parser.printElements("ANALYSIS1");
        parser.printAttributes("HISTORY"); 
        //System.out.println(parser.printHistory());
        //parser.printHistoryAttributes();
        
        parser.printElements("HISTORY"); */
        
    }
    
}
