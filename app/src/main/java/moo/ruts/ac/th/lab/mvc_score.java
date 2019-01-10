package moo.ruts.ac.th.lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class mvc_score extends AppCompatActivity {
    TextView ttshowScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc_score);


        ttshowScore = (TextView)findViewById(R.id.ttshowScore);
        ttshowScore.setText(String.valueOf(getIntent().getExtras().getInt("Score")));

    }

    public void clickPlayAgain(View view){
        Intent intent = new Intent(mvc_score.this,mvc.class);
      startActivity(intent);
      finish();
      }

    public void ClicExit (View view){
        Intent intent = new Intent(mvc_score.this,secound.class);
        startActivity(intent);
        finish();

    }


}


