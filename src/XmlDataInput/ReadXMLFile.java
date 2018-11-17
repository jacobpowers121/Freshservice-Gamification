package XmlDataInput;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFile {

    private enum States {HELPDESKTICKETS, HELPDESKTICKET, CCEMAIL, HELPDESKNOTES, HELPDESKNOTE}
    static States state;

    public static void main(String argv[]) {

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {

                    System.out.println("Start Element: " + qName);

                    if (qName.equalsIgnoreCase("HELPDESK-TICKETS")) {
                        state = States.HELPDESKTICKETS;
                        System.out.println("test1");
                    }

                    if (qName.equalsIgnoreCase("HELPDESK-TICKET")) {
                        state = States.HELPDESKTICKET;
                        System.out.println("test2");
                    }

                    if (qName.equalsIgnoreCase("CC-EMAIL")) {
                        state = States.CCEMAIL;
                        System.out.println("test3");
                    }

                    if (qName.equalsIgnoreCase("HELPDESK-NOTES")) {
                        state = States.HELPDESKNOTES;
                        System.out.println("test4");
                    }

                    if (qName.equalsIgnoreCase("HELPDESK-NOTE")) {
                        state = States.HELPDESKNOTE;
                        System.out.println("test5");
                    }
                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {

                    System.out.println("End Element: " + qName);

                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    try {
                        System.out.println(new String(ch, start, length));
                    }catch (Exception e){
                        System.out.println("FAIL");
                    }

                }

            };

            String filename = "C:\\Users\\powersjd\\Desktop\\TicketAnalyzer\\TicketDump\\TicketTest.xml";
            saxParser.parse(filename, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}