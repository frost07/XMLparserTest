package com.company;

import java.util.List;

public class    functions {


    private static String xmlFileName = "Теория и история мировой культуры.xml";

    public static String getXmlFileName() {
        return xmlFileName;
    }


    //вывести общий результат
    public static void printResult(String fileName){
        List<entityAnswers> answersList = Answers.parseXMLfile(fileName);
        for (entityAnswers answer : answersList) {
            System.out.println("id = "+answer.getId());
            for(String answerList : answer.getAnswerlistText()){
                System.out.println("Answer = "+ answerList);
            }
        }
    }
//вывести вопросы с правильными ответами
public static void printTrueAnswers(String fileName){
    List<entityAnswers> answersList = Answers.parseXMLfile(fileName);
    for (entityAnswers answer : answersList) {
        int i =0;
        String trueAnswer=null;
        System.out.println("Вопрос № "+(answer.getId()+1));
        for(String answerList : answer.getAnswerlistText()){
            if(i==0){
                System.out.println("Вопрос = "+ answerList);
            }else if(i!=0&&functions.equals(answerList, "Yes")==false){
                trueAnswer=answerList;
            }else if(functions.equals(answerList, "Yes")){
                System.out.println("Ответ = "+ trueAnswer);
                trueAnswer=answerList;
            }
            i++;
        }
        System.out.println("");
    }
}

    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

}
