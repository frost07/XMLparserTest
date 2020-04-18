package com.company;

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

public class Answers {
    public static List<entityAnswers> parseXMLfile(String fileName) {
        List<entityAnswers> answersList = new ArrayList<>();
        entityAnswers answer = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        String isCorrect=null;
        String thisAnswer=null;
        String answerid=null;
        try {
            // инициализируем reader и скармливаем ему xml файл
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            // проходим по всем элементам xml файла

            while (reader.hasNext()) {
                // получаем событие (элемент) и разбираем его по атрибутам

                XMLEvent xmlEvent = reader.nextEvent();

                    if (xmlEvent.isStartElement()) {
                        StartElement startElement = xmlEvent.asStartElement();

                        if (startElement.getName().getLocalPart().equals("QuestionBlock")) {
                            answer = new entityAnswers();
                            // Получаем атрибут id для каждого элемента Student
                            Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                            if (idAttr != null) {
                                answerid=idAttr.getValue();
                                answer.setId(Integer.parseInt(idAttr.getValue()));
                            }
                        } else if (startElement.getName().getLocalPart().equals("Answer")) {
                            // Получаем атрибут isCorrect для каждого элемента Student
                            isCorrect = String.valueOf(startElement.getAttributeByName(new QName("IsCorrect")).getValue());


                        }else if (startElement.getName().getLocalPart().equals("PlainText")) {
                            xmlEvent = reader.nextEvent();
                            thisAnswer=xmlEvent.asCharacters().getData();
                        }

                    }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("PlainText")) {
                        List<String> testlist= answer.getAnswerlistText();
                        testlist.add(thisAnswer);
                        answer.setAnswerlistText(testlist);
                    }
                }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("Answer")) {
                        List<String> testlist= answer.getAnswerlistText();
                        testlist.add(isCorrect);
                        answer.setAnswerlistText(testlist);
                    }
                }

                // если цикл дошел до закрывающего элемента Answer,
                // то добавляем считанного из файла ответ в список
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("QuestionBlock")) {
                        answersList.add(answer);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException exc) {
            exc.printStackTrace();
        }
        return answersList;
    }
}
