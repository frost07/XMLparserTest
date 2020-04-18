package main;

import java.util.ArrayList;
import java.util.List;

public class entityAnswers {
    private int id;

    public void setAnswerlistText(List<String> answerlistText) {
        this.answerlistText = answerlistText;
    }

    private List<String> answerlistText = new ArrayList<>();

    public List<String> getAnswerlistText() {
        return answerlistText;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
