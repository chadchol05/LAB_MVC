package moo.ruts.ac.th.lab;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class mvc extends AppCompatActivity {
    private ImageView imvAnimal;
    private RadioGroup radAnswer;
    private String strAnswer;
    private mvc_dg objMyAlert;
    private Question objQuestion;
    private mvc_dg objMyAlertDialog;
    private int intTime = 1, intUserChoose, intUserScore;
    private MediaPlayer objmedPlayerbut,objmediaPlayerRDbutt;
    private int intUserChooseArray[],intTrueAnswerArray[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        initialWidget();

        intUserChooseArray = new int[5];
        intTrueAnswerArray = new int[5];
        setVauleTrueAnswer();

        objQuestion = new Question();
        objQuestion.setOnuestionCHLis(new Question.OnuestionCHLis() {
            @Override
            public void onQuestionChangeListener(Question question) {
                switch (question.grtIntQuestion()) {
                    case 1:
                        imvAnimal.setImageResource(R.drawable.cow);
                        break;
                    case 2:
                        imvAnimal.setImageResource(R.drawable.horse);
                        break;
                    case 3:
                        imvAnimal.setImageResource(R.drawable.pig);
                        break;
                    case 4:
                        imvAnimal.setImageResource(R.drawable.sheep);
                        break;
                    default:
                        break;
                }
            }
        });
        radAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radCow:
                        strAnswer = "Com";
                        intUserChoose = 1;
                        break;
                    case R.id.radHorse:
                        strAnswer = "Horse";
                        intUserChoose = 2;
                        break;
                    case R.id.radPig:
                        strAnswer = "Pig";
                        intUserChoose = 3;
                        break;
                    case R.id.radSheep:
                        strAnswer = "Sheep";
                        intUserChoose = 4;
                        break;
                    default:
                        strAnswer = null;
                        break;
                }
                sondRDbutt();
                ToaseMessage();
            }
        });

    }
    private void setVauleToQuestion(){
        if (intTime == 4){
            //intTime = 0;

            if (intUserScore == 3){
                intUserScore++;
            }
            Intent intent = new Intent(mvc.this,mvc_score.class);
            intent.putExtra("Score",intUserScore);
            startActivity(intent);
        }
        objQuestion.setIntQuestion(intTime + 1);
    }

    private void setVauleTrueAnswer(){
        intTrueAnswerArray[1] = 1;
        intTrueAnswerArray[2] = 2;
        intTrueAnswerArray[3] = 3;
        intTrueAnswerArray[4] = 4;
    }

    private void  initialWidget(){
        imvAnimal = (ImageView) findViewById(R.id.imageView2);
        radAnswer = (RadioGroup) findViewById(R.id.radAnswer);
    }

    public void ClickAnswer(View view){
        chckChooseAnswer();
    }

    private void checkScore(){
        intUserChooseArray[intTime] = intUserChoose;
        if (intUserChooseArray [intTime]==intTrueAnswerArray[intTime]){
            intUserScore++;
        }
    }

    public void chckChooseAnswer(){
        if (strAnswer != null){
            Log.d("masterUNG","strAnswer= " + strAnswer);
            setVauleToQuestion();
            checkScore();
            intTime++;
        }else {
            Log.d("masterUNG", "Please CH Something");
            objMyAlertDialog =new mvc_dg();
            objMyAlertDialog.NoChooseEveryThing(mvc.this);
        }
        sounButt();
    }

    private void sounButt(){
        objmedPlayerbut = MediaPlayer.create(getBaseContext(),R.raw.effect_btn_shut);
        objmedPlayerbut.start();
     }

     private void sondRDbutt(){
        objmediaPlayerRDbutt = MediaPlayer.create(getBaseContext(),R.raw.phonton1);
        objmediaPlayerRDbutt.start();
     }

     private void ToaseMessage(){
         Toast.makeText(mvc.this,"Are You Sure Your Answer is " + strAnswer,500).show();
     }
}
