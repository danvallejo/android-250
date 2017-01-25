package com.cstructor.androidinterfaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ContactActivity
        extends AppCompatActivity
        implements ContactItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    @Override
    public void onListFragmentInteraction(String id) {
        Log.d("master.onFragment", id);

        if (findViewById(R.id.uxContactDetail) == null) {
            Log.d("ContactActivity", "ContactDetailActivity");
            Intent intent = new Intent(this, ContactDetailActivity.class);

            Bundle b = new Bundle();
            b.putString("ContactId", id);

            intent.putExtras(b);

            startActivity(intent);
        } else {
            Log.d("ContactActivity", "setContactId");

            ContactDetailFragment contactDetailFragment = new ContactDetailFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.uxContactDetail, contactDetailFragment)
                    .commit();

            contactDetailFragment.setContactId(id);
        }
    }
}
