/*
 * Created on 24.08.2006
 *
 */
package bank.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import bank.fachlogik.Konto;

public class XmlSupport extends DefaultHandler
{
    private final static String NL = System.getProperty("line.separator");
    private List<Konto> liste = new ArrayList<Konto>();
    
    public void exportieren(File datei, List<Konto> konten)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Node liste = document.createElement("KONTOLISTE");
            document.appendChild(liste);
            
            for (Konto k : konten)
            {
                liste.appendChild(document.createTextNode(NL));
                Element element = document.createElement("KONTO");
                element.setAttribute("nummer", String.valueOf(k.getNummer()));
                element.setAttribute("besitzer", k.getBesitzer());
                element.setAttribute("limit", String.valueOf(k.getLimit()));
                element.setAttribute("saldo", String.valueOf(k.getSaldo()));
                liste.appendChild(element);
            }
            
            
            Source source = new DOMSource(document);
            Result result = new StreamResult(datei);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
            
            
            
            
        } catch (ParserConfigurationException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(TransformerException e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    public List<Konto> importieren(File datei)
    {

        liste.clear();
        try
        {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(datei, this);
        } catch (ParserConfigurationException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        
        
        return liste;
    }



     /* (non-Javadoc)
     * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        if (qName.equals("KONTO"))
        {
            int nummer = Integer.parseInt(attributes.getValue("nummer"));
            double limit = Double.parseDouble(attributes.getValue("limit"));
            double saldo = Double.parseDouble(attributes.getValue("saldo"));
            String besitzer = attributes.getValue("besitzer");
            Konto k = new Konto(nummer, saldo);
            k.setBesitzer(besitzer);
            k.setLimit(limit);
            liste.add(k);
            
        }
    }

}
