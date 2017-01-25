package com.cstructor.androidinterfaces;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

public class LocaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locale);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tv = (TextView)findViewById(R.id.uxDate);

        Date date = new Date();
        String dateString = DateFormat.getDateInstance(DateFormat.SHORT).format(date);

        tv.setText(dateString);

        tv = (TextView) findViewById(R.id.uxNumber);

        String numberString = NumberFormat.getNumberInstance().format(1000);
        tv.setText(numberString);

        tv = (TextView) findViewById(R.id.uxMoney);

        String moneyString = NumberFormat.getCurrencyInstance().format(1000.23);
        tv.setText(moneyString);
        Log.d("Money:", moneyString);
    }
}
