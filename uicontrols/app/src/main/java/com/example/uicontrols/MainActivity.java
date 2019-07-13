package com.example.uicontrols;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private TextView et2;
    private Button button,button2,togglebutton;
    public static final String Shared_prefs="sharedprefs";
    public static final String Text = "text";
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(TextView)findViewById(R.id.et2);
        button=(Button)findViewById(R.id.button);
        togglebutton=(Button)findViewById(R.id.toggleButton);

        togglebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et2.setText(et1.getText().toString());
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myAlert=new AlertDialog.Builder(MainActivity.this);
                myAlert.setTitle("Save");
                myAlert.setMessage("Are You Sure?");
                myAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        savedata();
                    }

                });

                myAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                myAlert.show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        loadData();
        updateViews();
    }
    public void savedata(){
        SharedPreferences sp=getSharedPreferences(Shared_prefs,MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(Text,et1.getText().toString());
        editor.apply();
        Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();

    }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(Shared_prefs, MODE_PRIVATE);
        text = sharedPreferences.getString(Text, "");
    }
    public void updateViews() {
        et2.setText(text);

    }
}
