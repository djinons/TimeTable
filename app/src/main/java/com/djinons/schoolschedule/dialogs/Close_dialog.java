package com.djinons.schoolschedule.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.djinons.schoolschedule.R;


/**
 * Created by macbookpro on 162//18.
 */

public class Close_dialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater l_inflater = getActivity().getLayoutInflater();
        final View close_dialog = l_inflater.inflate(R.layout.close_dialog,null);

        Button cancelButton = close_dialog.findViewById(R.id.cancel_btn);
        Button okButton = close_dialog.findViewById(R.id.ok_btn);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Close_dialog.this.dismiss();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Close_dialog.this.getActivity().finishAffinity();
            }
        });

        builder.setView(close_dialog);



        return builder.create();
    }


}
