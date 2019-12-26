package com.cs.ajinmathew.project.mycourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.textclassifier.ConversationActions;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ViewCourse extends AppCompatActivity {

   String ApiUrl="https://dummyapilist.herokuapp.com/getcourses";

   RecyclerView recyclerView;
   RecyclerView.Adapter adapter;

    List<Course> my_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_view_course );

        recyclerView=(RecyclerView)findViewById( R.id.recycler );
        recyclerView.setHasFixedSize(true);

        my_list=new ArrayList<>(  );

        recyclerView.setLayoutManager( new GridLayoutManager( this,1 ) );




        callApi();
    }

    private void callApi() {

        StringRequest stringRequest=new StringRequest( Request.Method.GET, ApiUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)  {
                try {
                    JSONArray jsonArray=new JSONArray( response );
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject( i );
                        String title=jsonObject.getString( "courseTitle" );
                        String date=jsonObject.getString( "courseDate" );
                        String duration=jsonObject.getString( "courseDuration" );
                        String description=jsonObject.getString( "courseDescription" );
                        String venue=jsonObject.getString( "courseVenue" );

                        Course course=new Course(title,duration,venue,date,description );

                        /*Log.d("Title",title);
                        Log.d("Date",date);
                        Log.d("Description",description);
                        Log.d("Duration",duration);
                        Log.d("Venue",venue);*/

                        my_list.add( course );



                    }


                    adapter=new CustomAdapter( my_list,getApplicationContext() );
                    recyclerView.setAdapter(adapter);



                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText( getApplicationContext(),String.valueOf( e ),Toast.LENGTH_LONG ).show();
                }



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
