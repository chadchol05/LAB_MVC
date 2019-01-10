package moo.ruts.ac.th.lab;

public class Question {
    private int intQuestion;

    public interface OnuestionCHLis{
        void onQuestionChangeListener(Question question);

    }

    private OnuestionCHLis onuestionCHLis;

    public void  setOnuestionCHLis(OnuestionCHLis onuestionCHLis){
        this.onuestionCHLis = onuestionCHLis;
    }

    public int grtIntQuestion() {return intQuestion;}

    public void setIntQuestion(int intQuestion) {
        this.intQuestion = intQuestion;
        if (this.onuestionCHLis != null){
            this.onuestionCHLis.onQuestionChangeListener(this);
        }
    }
}// end of Main Class
