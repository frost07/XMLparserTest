package main;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Mainbackup {
//
//    public static void main(String[] args) {
////        String filepath = "languages.xml";
//        String filepath ="liza.xml";
//        File xmlFile = new File(filepath);
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder;
//        try {
//            builder = factory.newDocumentBuilder();
//            Document document = builder.parse(xmlFile);
//            document.getDocumentElement().normalize();
//            System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());
//            // получаем узлы с именем Language
//            // теперь XML полностью загружен в память
//            // в виде объекта Document
////            NodeList nodeList = document.getElementsByTagName("Language");
//            NodeList nodeList = document.getElementsByTagName("QuestionBlock");
//
//            // создадим из него список объектов Language
//            List<Questions> langList = new ArrayList<Questions>();
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                langList.add(getLanguage(nodeList.item(i)));
//                System.out.println(i);
//                System.out.println(getLanguage(nodeList.item(i)));
//            }
//
//            // печатаем в консоль информацию по каждому объекту Language
////            for (Questions lang : langList) {
////                System.out.println(lang.toString());
////            }
//        } catch (Exception exc) {
//            exc.printStackTrace();
//        }
//
//    }
//
//
//
//    // создаем из узла документа объект Language
//    private static Questions getLanguage(Node node) {
//        Questions lang = new Questions();
//        if (node.getNodeType() == Node.ELEMENT_NODE) {
//            Element element = (Element) node;
//            lang.setQuestion(getTagValue("PlainText", element));
////            lang.setAnswer(getTagValue("age", element));
//        }
//
//        return lang;
//    }
//
//    // получаем значение элемента по указанному тегу
//    private static String getTagValue(String tag, Element element) {
//        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
//        Node node = (Node) nodeList.item(0);
//        return node.getNodeValue();
//    }
}
