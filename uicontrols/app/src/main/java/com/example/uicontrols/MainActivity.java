package com.example.uicontrols;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et3,et5,et7,et9;
    public String name,rollno,opt1,opt2,email;
    
    private Button button;
    public static final String Shared_prefs="shared_prefs";
    public static final String Text = "text";
    public static final String Text1 = "text1";
    public static final String Text2 = "text2";
    public static final String Text3 = "text3";
    public static final String Text4 = "text4";
    private String text,text1,text2,text3,text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);

        et3=(EditText)findViewById(R.id.et3);

        et5=(EditText)findViewById(R.id.et5);

        et7=(EditText)findViewById(R.id.et7);

        et9=(EditText)findViewById(R.id.et9);

        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                name=et1.getText().toString();
                rollno=et3.getText().toString();
                opt1=et5.getText().toString();
                opt2=et7.getText().toString();
                email=et9.getText().toString();
                new SendRequest().execute();
                AlertDialog.Builder myAlert=new AlertDialog.Builder(MainActivity.this);
                myAlert.setTitle("Save");
                myAlert.setMessage("Do you Want to make any changes?");
                myAlert.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        save_data();
                    }

                });

                myAlert.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                myAlert.show();

            }
        });
        loadData();
        updateViews();

    }
    public void save_data(){
        SharedPreferences sp=getSharedPreferences(Shared_prefs,MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(Text,name);
        editor.putString(Text1,rollno);
        editor.putString(Text2,opt1);
        editor.putString(Text3,opt2);
        editor.putString(Text4,email);
        editor.apply();
        Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();

    }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(Shared_prefs, MODE_PRIVATE);
        text = sharedPreferences.getString(Text, "");
        text1 = sharedPreferences.getString(Text1, "");
        text2 = sharedPreferences.getString(Text2, "");
        text3 = sharedPreferences.getString(Text3, "");
        text4 = sharedPreferences.getString(Text4, "");

    }
    public void updateViews() {
        et1.setText(text);
        et3.setText(text1);
        et5.setText(text2);
        et7.setText(text3);
        et9.setText(text4);

    }
    public void next(View view){
        Intent i1=new Intent(this,MainActivity2.class);
        i1.putExtra("user",et1.getText().toString());
        i1.putExtra("user1",et9.getText().toString());
        startActivity(i1);
    }
}




public class SendRequest extends AsyncTask<String, Void, String> {

    protected void onPreExecute() {

    }

    protected String doInBackground(String... arg0) {

        try {

            URL url = new URL("https://script.google.com/macros/s/AKfycbypwxoGANn2KKTO2ZxfnYZcnUW51txMrux-8Oi89rtMZ8qsP3Tn/exec");
            JSONObject postDataParams = new JSONObject();
            String id = "1YgD3wsC158o_06GPJZj1vgbu79WCNl5td4qn6lygfWM";
            postDataParams.put("name", name);
            postDataParams.put("rollno", rollno);
            postDataParams.put("opt1", opt1);
            postDataParams.put("opt2", opt2);
            postDataParams.put("email", email);
            postDataParams.put("id", id);


            Log.e("params", postDataParams.toString());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuffer sb = new StringBuffer("");
                String line = "";

                while ((line = in.readLine()) != null) {

                    sb.append(line);
                    break;
                }

                in.close();
                return sb.toString();

            } else {
                return "false : " + responseCode;
            }
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }



    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }
}
