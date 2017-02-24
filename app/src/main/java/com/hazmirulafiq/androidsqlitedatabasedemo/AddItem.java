package com.hazmirulafiq.androidsqlitedatabasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class AddItem extends AppCompatActivity {

    private EditText inputTitle;
    private EditText inputDesc;
    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputTitle = (EditText) findViewById(R.id.inputItem);
        inputDesc = (EditText) findViewById(R.id.inputDesc);

        dbManager = new DatabaseManager(this);
        dbManager.open();
    }

    public void onClickDone(View view) {
        String myInputTitle = inputTitle.getText().toString();
        String myInputDesc = inputDesc.getText().toString();
        if (myInputTitle.isEmpty() || myInputDesc.isEmpty()) {
            Snackbar.make(view,"Please fill in both form!",Snackbar.LENGTH_SHORT).show();
        } else {
            dbManager.insert(myInputTitle, myInputDesc);
            Intent intent = new Intent(AddItem.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
