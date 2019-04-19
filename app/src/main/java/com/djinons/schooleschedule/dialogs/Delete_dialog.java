package com.djinons.schooleschedule.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.djinons.schooleschedule.R;

/**
 * Created by macbookpro on 103//18.
 */

public class Delete_dialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater l_inflater = getActivity().getLayoutInflater();
        final View delete_dialog = l_inflater.inflate(R.layout.delete_dialog,null);

        Button cancelButton = delete_dialog.findViewById(R.id.cancel_btn);
        Button okButton = delete_dialog.findViewById(R.id.ok_btn);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete_dialog.this.dismiss();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Delete_dialog.this.getActivity().finishAffinity();
            }
        });

        builder.setView(delete_dialog);



        return builder.create();
    }


}