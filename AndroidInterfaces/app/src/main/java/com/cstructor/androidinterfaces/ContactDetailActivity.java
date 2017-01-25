package com.cstructor.androidinterfaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        Intent intent = getIntent();
        String contactId = intent.getStringExtra("ContactId");

        TextView tv = (TextView)findViewById(R.id.uxTextView);
        tv.setText(contactId);
    }
}
