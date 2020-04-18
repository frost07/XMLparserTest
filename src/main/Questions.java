package main;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Questions {


    public static List<entityQuestions> parseXMLfile(String fileName) {
        List<entityQuestions> questionsList = new ArrayList<>();
        entityQuestions question = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            // инициализируем reader и скармливаем ему xml файл
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            // проходим по всем элементам xml файла
            int i=0;
            while (reader.hasNext()) {
                // получаем событие (элемент) и разбираем его по атрибутам

                XMLEvent xmlEvent = reader.nextEvent();
                if(i==0){
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("QuestionBlock")) {
                        question = new entityQuestions();
                        // Получаем атрибут id для каждого элемента Student
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            question.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    }  else if (startElement.getName().getLocalPart().equals("PlainText")) {
                        xmlEvent = reader.nextEvent();
                        question.setQuestion(xmlEvent.asCharacters().getData());
                        i+=1;
                    }
                }}
                // если цикл дошел до закрывающего элемента Student,
                // то добавляем считанного из файла студента в список
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("QuestionBlock")) {
                        questionsList.add(question);
                        i=0;
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException exc) {
            exc.printStackTrace();
        }
        return questionsList;
    }
}
