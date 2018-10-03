package com.example.user.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        showRandomNumber(); //create된 뒤에 이 메소드 호출함.
    }
    private static final String TOTAL_COUNT = "total_count";
    public void showRandomNumber(){
        TextView randomView = (TextView) findViewById(R.id.textview_random);
        TextView headingView =(TextView) findViewById(R.id.textview_label);

        //Get the count from the intent extras.
        //need to know the type of the extra. eg) getStringExtra(), getIntExtra()
        //arguments are the key and the default value if the key is not found.
        int count = getIntent().getIntExtra(TOTAL_COUNT,0);

        //Generate the random number;
        Random random = new Random();
        int randomInt =0;
        if(count>0)
            randomInt = random.nextInt(count); //count++해줌.

        randomView.setText(Integer.toString(randomInt));

        //Substitute the max value into the string resource.
        //for the heading, and update the heading.
        headingView.setText(getString(R.string.random_heading,count));
    }
}
