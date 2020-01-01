package com.example.app_1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.app_1.DBUtils.DBHelper;
import com.example.app_1.DBUtils.Utils;
import com.example.app_1.beans.people;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Rigister extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigister);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button commit=findViewById(R.id.commit);
        commit.setOnClickListener(this);
        Button cancel=findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.commit:
                DBHelper dbHelper=MainActivity.getDbHelper();
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                EditText nameText=(EditText)findViewById(R.id.rname);
                EditText pwdText=(EditText)findViewById(R.id.rpwd);
                EditText rrpwd=(EditText)findViewById(R.id.rrpwd);
//                Button sex=(RadioButton)findViewById(R.id.sex);
                if(!rrpwd.equals(rrpwd)){
                    // 提示出错
                }
                else{
                    people p=new people();
                    p.setName(nameText.toString());
                    p.setPwd(pwdText.toString());
                    p.setSex(1);// 这里暂时赋值
                    Utils.Insert(db,p);
                }
                break;
            case R.id.cancel:
                startActivity(new Intent(Rigister.this,MainActivity.class));
                break;
        }
    }
}
