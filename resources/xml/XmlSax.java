import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class XmlSax extends DefaultHandler
{
	StringBuilder text = new StringBuilder();
	private String message;
	private String date;
	private String level;


	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException
	{
		text = new StringBuilder();
		
		if ("record".equals(name))
		{
			message = null;
			date = null;
			level = null;
		}
		
	}

	
	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException
	{
		if ("message".equals(name))
			message = text.toString();
		else if ("date".equals(name))
			date = text.toString();
		else if ("level".equals(name))
			level = text.toString();
		else if ("record".equals(name))
		{
			if ("INFO".equals(level))
				System.out.println(date + " - " + message);
		}
	}


	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException
	{
		text.append(ch, start, length);
	}


	public static void main(String[] args)
	{
		try
		{
			SAXParserFactory factory = SAXParserFactory.newInstance(); 
			factory.setValidating(false);

			SAXParser saxParser = factory.newSAXParser(); 
			DefaultHandler handler = new XmlSax(); 
			saxParser.parse( new File("logging.xml"), handler );
			System.out.println("done");
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
