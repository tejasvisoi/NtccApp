package com.example.uicontrols;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textview;
    EditText et1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textview=(TextView)findViewById(R.id.textview);
        et1=(EditText)findViewById(R.id.et1);
        button=(Button)findViewById(R.id.button);
        Bundle b1=getIntent().getExtras();
        String s1=b1.getString("user");
        textview.setText("Welcome "+s1);
        String s2=b1.getString("user1");
        et1.setText(s2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myAlert1=new AlertDialog.Builder(MainActivity2.this);
                myAlert1.setTitle("Alert!");
                myAlert1.setMessage("An Email will be sent regarding your faculty options.Continue?");
                myAlert1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                myAlert1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                myAlert1.show();
            }

        });
    }
}
