package com.example.app3;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button button = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void goTo1 (View view) {
        goToUrl ("https://classroom.udacity.com/courses/ud834/lessons/4027328704/concepts/5aea4e14-9ea5-426b-b1bc-5ae53d2e5025");
    }

    public void goTo2 (View view) {
        goToUrl ( "https://classroom.udacity.com/courses/ud834/lessons/4330701752/concepts/0a8099ed-1531-4e5d-860f-6af4f5501580");
    }
    public void goTo3 (View view) {
        goToUrl ( "https://classroom.udacity.com/courses/ud834/lessons/4034888704/concepts/41974487440923");
    }
    public void goTo4 (View view) {
        goToUrl ( "https://classroom.udacity.com/courses/ud834/lessons/46e6b33a-0d6e-433d-9ac4-701a2156d584/concepts/c2c15e7a-8c5b-457b-ae2b-ba26f31558cb");
    }
    public void goTo5 (View view) {
        goToUrl ( "https://classroom.udacity.com/courses/ud836/lessons/4038208680/concepts/42872653270923");
    }
    public void goTo6 (View view) {
        goToUrl ( "https://classroom.udacity.com/courses/ud836/lessons/4329970891/concepts/43237591300923");
    }
    public void goTo7 (View view) {
        goToUrl ( "https://classroom.udacity.com/courses/ud836/lessons/4036438656/concepts/43176113290923");
    }
    public void goTo8 (View view) {
        goToUrl ( "https://classroom.udacity.com/courses/ud836/lessons/7830628637239847/concepts/78286506390923");
    }
    public void goTo9 (View view) {
        goToUrl ( "https://material.io/design/introduction/#principles");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
