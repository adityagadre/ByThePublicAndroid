package com.example.dbtest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void btn_Click(View view){
    	
    	
    	Thread thread = new Thread(new Runnable(){
    	    @Override
    	    public void run() {
    	        try {
    	        	HttpClient cli=new DefaultHttpClient();
    	        	HttpPost post=new HttpPost("http://ec2-54-215-224-48.us-west-1.compute.amazonaws.com/DatastoreSvc.php");
    	        	
    	        	List<NameValuePair> lst=new ArrayList<NameValuePair>();
    	        	
    	        	lst.add(new BasicNameValuePair("q","Aditya"));
    	        	
    	        	try {
    	    			post.setEntity(new StringEntity("{\"cmd\": 2,\"data\":{\"uid\": 1134567, \"uname\": \"agadre\"}}"));
    	    			
    	    		} catch (UnsupportedEncodingException e) {
    	    			// TODO Auto-generated catch block
    	    			e.printStackTrace();
    	    		}
    	        	
    	        	try {
    	    			HttpResponse res=cli.execute(post);
    	    			
    	    			
    	    			
    	    			HttpEntity entity = res.getEntity();
    	    			String responseString = EntityUtils.toString(entity, "UTF-8");
    	    			String s=res.toString();
    	    			
    	    			s=res.toString();
    	    			
    	    			
    	    		} catch (ClientProtocolException e) {
    	    			// TODO Auto-generated catch block
    	    			e.printStackTrace();
    	    		} catch (IOException e) {
    	    			// TODO Auto-generated catch block
    	    			e.printStackTrace();
    	    		}
    	            //Your code goes here
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	        }
    	    }
    	});

    	thread.start(); 
    	
    	
    	
    	
    	
    }
    
}
