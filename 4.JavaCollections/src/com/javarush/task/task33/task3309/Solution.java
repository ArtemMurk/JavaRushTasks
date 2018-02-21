package com.javarush.task.task33.task3309;

import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws TransformerException, JAXBException, ParserConfigurationException {

        StringWriter writer = new StringWriter();
        StringWriter writerToCheck = new StringWriter();
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();


        JAXBContext context= JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj,doc);
        marshaller.marshal(obj,writerToCheck);
//        if (true) return writerToCheck.toString();
        findCDATAelementsAndReplace(doc, doc);




        NodeList listOfTagNode = doc.getElementsByTagName(tagName);

        for (int i = 0; i <listOfTagNode.getLength() ; i++) {
            if (listOfTagNode.item(i).getNodeType() != Node.CDATA_SECTION_NODE) {
                Comment text = doc.createComment(comment);

                listOfTagNode.item(i).getParentNode().insertBefore(text, listOfTagNode.item(i));
            }
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource docSource = new DOMSource(doc);
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE,"no");

        StreamResult streamResult = new StreamResult(writer);
        transformer.transform(docSource,streamResult);


//        System.out.println(writerToCheck.toString());
        return writer.toString();
    }


    public static void findCDATAelementsAndReplace(Node node,Document document) {
        // do something with the current node instead of System.out
//        System.out.println(node.getNodeName());

        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                //calls this method for all the children which is Element
                findCDATAelementsAndReplace(currentNode, document);
            }
            if  (currentNode.getNodeType()== Node.TEXT_NODE){
                if (    currentNode.getTextContent().contains("\"")||
                        currentNode.getTextContent().contains("<;")||
                        currentNode.getTextContent().contains(">")||
                        currentNode.getTextContent().contains("&")||
                        currentNode.getTextContent().contains("'")) {
                    String textCDATA = node.getTextContent();
                    CDATASection cdata = document.createCDATASection(textCDATA);

                    currentNode.getParentNode().replaceChild(cdata,currentNode);
//                    System.out.println(node.getTextContent());

                }
            }
        }
    }


    public static void main(String[] args) {
        try {
            System.out.println(toXmlWithComment(new First(), "second","good Comment" ));
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
