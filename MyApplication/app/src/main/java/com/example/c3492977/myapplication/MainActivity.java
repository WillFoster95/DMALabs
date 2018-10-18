package com.example.c3492977.myapplication;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // call the super class onCreate to complete the creation of activity like
        // the view hierarchy
        super.onCreate(savedInstanceState);

        // set the user interface layout for this Activity
        // the layout file is defined in the project res/layout/activity_todo.xml file
        setContentView(R.layout.activity_main);

        // initialize member TextView so we can manipulate it later
        final TextView TodoTextView;
        TodoTextView = (TextView) findViewById(R.id.textViewTodo);

        // read the todo array from res/values/strings.xml
        Resources res = getResources();
        mTodos = res.getStringArray(R.array.todo);
        // display the first task from mTodo array in the TodoTextView
        TodoTextView.setText(mTodos[mTodoIndex]);

        Button buttonNext;
        buttonNext = (Button) findViewById(R.id.buttonNext);
        // OnClick listener for the  Next button
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTodoIndex += 1;
                mTodoIndex = mTodoIndex % mTodos.length;
                TodoTextView.setText(mTodos[mTodoIndex]);
            }
        });

        Button buttonPrev;
        buttonPrev = (Button) findViewById(R.id.buttonPrev);
        // OnClick listener for the  Prev button
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
}