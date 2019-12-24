package com.cs.ajinmathew.project.mycourse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddCourse extends AppCompatActivity {
EditText edCourseTitle,edCourseDuration,edCourseVenue,edCourseDate,edCourseDescrption;
Button btnAddCourse;
String ctitle,cdate,cduration,cdescription,cvenue;
ProgressBar progressBar;
Course course;
String WebApi="https://dummyapilist.herokuapp.com/addcourse";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_course );
        edCourseDate=(EditText)findViewById( R.id.coursedate );
        edCourseTitle=(EditText)findViewById( R.id.coursetitle );
        edCourseDuration=(EditText)findViewById( R.id.courseduration );
        edCourseDescrption=(EditText)findViewById( R.id.coursedescription );
        edCourseVenue=(EditText)findViewById( R.id.coursevenue);

        progressBar=(ProgressBar)findViewById(R.id.pb);
        btnAddCourse=(Button)findViewById( R.id.uploadCourse );
        btnAddCourse.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility( View.VISIBLE );
                ctitle=edCourseTitle.getText().toString();
                cdate=edCourseDate.getText().toString();
                cduration=edCourseDuration.getText().toString();
                cdescription=edCourseDescrption.getText().toString();
                cvenue=edCourseVenue.getText().toString();
                course=new Course(  );
                course.setCourse_Title( ctitle );
                course.setCourse_duration( cduration );
                course.setCourse_description( cdescription );
                course.setCourse_venue( cvenue );
                course.setCourse_date( cdate );

                callApi();

            }
        } );
    }

    private void callApi() {

        StringRequest stringRequest=new StringRequest( Request.Method.POST, WebApi, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText( getApplicationContext(),response,Toast.LENGTH_LONG ).show();
                progressBar.setVisibility( View.INVISIBLE );
                edCourseDate.setText( "" );
                edCourseDescrption.setText( "" );
                edCourseDuration.setText( "" );
                edCourseTitle.setText( "" );
                edCourseVenue.setText( "" );
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility( View.INVISIBLE );
            }
        } )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String,String> params=new HashMap<>(  );
                params.put( "courseDuration",cduration );
                params.put( "courseVenue",cvenue );
                params.put( "courseDate",cdate );
                params.put( "courseDescription",cdescription );
                params.put( "courseTitle",ctitle );

                return params;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue( getApplicationContext() );
        requestQueue.add( stringRequest );


    }


}
