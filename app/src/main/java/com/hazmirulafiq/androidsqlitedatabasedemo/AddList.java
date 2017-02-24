package com.hazmirulafiq.androidsqlitedatabasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class AddList extends AppCompatActivity {

    private EditText inputTitle;
    private EditText inputDesc;
    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputTitle = (EditText) findViewById(R.id.titleInput);
        inputDesc = (EditText) findViewById(R.id.descInput);

        dbManager = new DatabaseManager(this);
        dbManager.open();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myInputTitle = inputTitle.getText().toString();
                String myInputDesc = inputDesc.getText().toString();
                if (myInputTitle.isEmpty() || myInputDesc.isEmpty()) {
                    Snackbar.make(view,"Please fill in both form!",Snackbar.LENGTH_LONG).show();
                } else {
                    dbManager.insert(myInputTitle, myInputDesc);
                    Intent intent = new Intent(AddList.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });

    }
}
