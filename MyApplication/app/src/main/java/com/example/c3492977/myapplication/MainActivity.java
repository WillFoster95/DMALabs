package com.example.c3492977.myapplication;

import android.content.Intent;
import android.util.Log;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{

    private String[] mTodos;
    private int mTodoIndex = 0;

    public static final String TAG = "TodoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        if (savedInstanceState != null)
        {
            mTodoIndex = savedInstanceState.getInt(TODO_INDEX, 0);
        }

        super.onCreate(savedInstanceState);

        Log.d(TAG, " *** Just to say the PC is in onCreate!");

        setContentView(R.layout.activity_main);                         //The layout is defined by res/layout/activity_main.xml

        final TextView TodoTextView;                                    //Initialize member TextView so we can manipulate it later
        TodoTextView = (TextView) findViewById(R.id.textViewTodo);      //textViewTodo is from res/layout/activity.xml

        Resources res = getResources();
        mTodos = res.getStringArray(R.array.todo);                      //todo is from res/values/strings.xml
        TodoTextView.setText(mTodos[mTodoIndex]);                       //Display the first task from mTodo array in the TodoTextView

        Button buttonNext;
        buttonNext = (Button) findViewById(R.id.buttonNext);            //OnClick listener for the  Next button
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTodoIndex += 1;
                mTodoIndex = mTodoIndex % mTodos.length;
                TodoTextView.setText(mTodos[mTodoIndex]);
            }
        });

        Button buttonPrev;
        buttonPrev = (Button) findViewById(R.id.buttonPrev);            //OnClick listener for the  Prev button
        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTodoIndex -= 1;
                if (mTodoIndex == -1)
                {
                    mTodoIndex = mTodos.length - 1;
                }
                TodoTextView.setText(mTodos[mTodoIndex]);
            }
        });
    }

    private static final String TODO_INDEX = "todoIndex";
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)          //Override to write the value of mTodoIndex into the Bundle with TODO_INDEX as its key
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(TODO_INDEX, mTodoIndex);
    }
}