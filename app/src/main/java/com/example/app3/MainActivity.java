package com.example.app3;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    Button button = null;
    TextView textView = null;
    EditText editText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
        button = (Button) findViewById(R.id.button3);
        textView = (TextView) findViewById(R.id.textView5);
        editText = (EditText) findViewById(R.id.editText4);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = editText.getText().toString();
                textView.setText("Hello " + name + " Welcome to Android Tutorial");
            }

        });

    }

    private void addListenerOnButton() {
        final Context context = this;
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, Main2Activity.class);
                startActivity(intent);

            }

        });
    }
}