package com.example.user.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //this method executes when the activity starts.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //sets the layout of the activity to activity_main.xml
    }

    /**
     * Show a toast
     * @param view -- the view that is clicked
     */
    public void toastMe(View view){ // public, return void, take a single argument of View -> xml가서 onClick property로 이 method 이름 지정.
        //Toast myToast = Toast.makeText(this,message,duration);
        Toast myToast = Toast.makeText(this,"Hello Toast!", Toast.LENGTH_SHORT);
        myToast.show();
    }
    public void countMe(View view){
        //Get the text view.
        TextView showCountTextView = (TextView) findViewById(R.id.textView);

        //Get the value of the text view.
        String countString = showCountTextView.getText().toString();

        //Convert value to a number and increment it.
        Integer count = Integer.parseInt(countString);
        count++;

        //Display the new value in the text view.
        showCountTextView.setText(count.toString());
    }
    private static final String TOTAL_COUNT ="total_count"; //extra data
    public void randomMe(View view){
        //Create an Intent to start the second activity
        Intent randomIntent = new Intent(this,SecondActivity.class);

        //Get the text view that shows the count.
        TextView showCountTextView = (TextView) findViewById(R.id.textView);

        //Get the value of the text view.
        String countString = showCountTextView.getText().toString();

        //Convert the count to an int.
        int count = Integer.parseInt(countString);

        //Add the count to the extras for the Intent.
        randomIntent.putExtra(TOTAL_COUNT,count);

        //Start the new activity.
        startActivity(randomIntent);
    }
}