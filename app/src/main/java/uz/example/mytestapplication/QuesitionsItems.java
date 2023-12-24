package uz.example.mytestapplication;

public class QuesitionsItems {
    String questions,answer1,answer2,answer3,answer4,correct;

    public QuesitionsItems(String questionString, String answer1String, String answer2String, String answer3String, String answer4String,String correct) {
        this.questions = questionString;
        this.answer1 = answer1String;
        this.answer2 = answer2String;
        this.answer3 = answer3String;
        this.answer4 = answer4String;
        this.correct = correct;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

}
