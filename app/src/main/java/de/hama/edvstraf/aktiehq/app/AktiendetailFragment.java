package de.hama.edvstraf.aktiehq.app;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AktiendetailFragment extends Fragment {

    public AktiendetailFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_aktiendetail, container, false);

        //Die AktiendetailActivity wurde über einen Intent aufgerufen
        //Wir lesen aus dem empfangenen Intent die übermittelten Daten aus
        Intent empfangenerIntent = getActivity().getIntent();

        if(empfangenerIntent != null && empfangenerIntent.hasExtra(Intent.EXTRA_TEXT)){

            String aktienInfo = empfangenerIntent.getStringExtra(Intent.EXTRA_TEXT);
            ((TextView) rootView.findViewById(R.id.aktiendetail_text)).setText(aktienInfo);
        }

        return rootView;
    }
}
