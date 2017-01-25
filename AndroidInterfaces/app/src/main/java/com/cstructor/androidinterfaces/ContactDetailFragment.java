package com.cstructor.androidinterfaces;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContactDetailFragment extends Fragment {
    private String contactId;

    public ContactDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_detail, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        TextView uxTextView = (TextView) getView().findViewById(R.id.uxTextView);

        uxTextView.setText(contactId);
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
}
