package com.cs.ajinmathew.project.mycourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnAddCourse,btnViewCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        btnAddCourse=(Button)findViewById( R.id.addCourse );
        btnViewCourse=(Button)findViewById( R.id.viewCourse );
        btnAddCourse.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),AddCourse.class ) );
            }
        } );
        btnViewCourse.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getApplicationContext(),ViewCourse.class ) );
            }
        } );
    }
}
