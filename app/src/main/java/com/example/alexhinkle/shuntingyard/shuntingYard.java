package com.example.alexhinkle.shuntingyard;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class shuntingYard extends AppCompatActivity
{
    private EditText inputTF;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shunting_yard);
        System.out.println("here");
        BloomFilter.bloomFilter(69, 155, 79);//change
        this.inputTF = (EditText)this.findViewById(R.id.inputTF);
        this.outputText = (TextView)this.findViewById(R.id.outputText);


    }

    public void shuntingYardButtonPressed(View v)
    {
        ShuntingYardTwo sy = new ShuntingYardTwo(this.inputTF.getText().toString());
        this.outputText.setText(sy.getAnswer());
    }


}











