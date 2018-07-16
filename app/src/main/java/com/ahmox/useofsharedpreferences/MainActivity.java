package com.ahmox.useofsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Button btn1,btn2,btn3;
    EditText editText;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 =(Button) findViewById(R.id.add);
        btn1 = (Button) findViewById(R.id.view);
        btn3 =(Button) findViewById(R.id.remove);
        editText =(EditText) findViewById(R.id.editText);
        text =(TextView) findViewById(R.id.textView2);

        sharedPreferences = this.getSharedPreferences("com.ahmox.useofsharedpreferences", Context.MODE_PRIVATE);

    }
    public void onClick1(View view){

        String name = editText.getText().toString();
        sharedPreferences.edit().putString("name",name).apply();
    }

    public void onClick2(View view){

        String savedName = sharedPreferences.getString("name",null);
        text.setText(savedName);
    }

    public void onClick3(View view){

        sharedPreferences.edit().remove("name").apply();
    }

}
