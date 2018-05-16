package interest;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class TestBookXml {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(".\\src\\xml\\book.xml"));
        read(document);
    }

    public static void read(Document document) {
        NodeList list = document.getElementsByTagName("name");

        Node name = list.item(2);

        System.out.println(name.getTextContent());

    }
}