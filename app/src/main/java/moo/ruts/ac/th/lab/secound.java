package moo.ruts.ac.th.lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secound extends AppCompatActivity {

    Button btnNext,butmvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);

        btnNext = (Button) findViewById(R.id.button2);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(secound.this, tem.class);
                startActivity(intent);
            }
        });

        butmvc = (Button) findViewById(R.id.button6);
        butmvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(secound.this, mvc.class);
                startActivity(intent);
            }
        });
    }
}
