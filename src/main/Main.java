package main;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.out.println(functions.getXmlFileName());

//        List<entityQuestions> questionsList = Questions.parseXMLfile(functions.getXmlFileName());
//        for (entityQuestions question : questionsList) {
//            System.out.println("id = "+question.getId() + " Question = "+ question.getQuestion());
//        }


//        functions.printResult(functions.getXmlFileName()); //вывести результат первичного парсинга

//functions.printTrueAnswers(functions.getXmlFileName());

        try {
            // создаем модель docx документа,
            // к которой будем прикручивать наполнение (текст)
            XWPFDocument docxModel = new XWPFDocument();

            // создаем обычный параграф, который будет расположен слева,
            // будет синим курсивом со шрифтом 25 размера
            XWPFParagraph bodyParagraph = docxModel.createParagraph();
            bodyParagraph.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun paragraphConfig = bodyParagraph.createRun();
//            paragraphConfig.setItalic(true);
            paragraphConfig.setFontSize(14);
            // HEX цвет без решетки #
//            paragraphConfig.setColor("06357a");
            paragraphConfig.setText(
                    "Prologistic.com.ua - новые статьи по Java и Android каждую неделю. Подписывайтесь!"
            );

            // сохраняем модель docx документа в файл
            FileOutputStream outputStream = new FileOutputStream("Apache POI Word Test.docx");
            docxModel.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Успешно записан в файл");
    }
    

}
