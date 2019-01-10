package moo.ruts.ac.th.lab;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class mvc_dg extends AppCompatActivity {
    private AlertDialog.Builder objAlert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc_dg);
    }

    public  void  NoChooseEveryThing (Context context){

        objAlert  = new AlertDialog.Builder(context);
        objAlert.setIcon(R.drawable.danger);
        //objAlert.setTile("Please Choose Answer ?");
        objAlert.setMessage("Please on Rabutton");
        objAlert.setCancelable(false);
        objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        objAlert.show();

    }
}
