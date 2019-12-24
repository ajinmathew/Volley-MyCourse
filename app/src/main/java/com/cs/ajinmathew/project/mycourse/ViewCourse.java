package com.cs.ajinmathew.project.mycourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.textclassifier.ConversationActions;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Method;

public class ViewCourse extends AppCompatActivity {

   String ApiUrl="https://dummyapilist.herokuapp.com/getcourses";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_view_course );

        callApi();
    }

    private void callApi() {

        StringRequest stringRequest=new StringRequest( Request.Method.GET, ApiUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText( getApplicationContext(),response,Toast.LENGTH_LONG ).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        } );

        RequestQueue requestQueue= Volley.newRequestQueue( getApplicationContext() );
        requestQueue.add( stringRequest );

    }
}
