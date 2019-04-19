package com.djinons.schooleschedule.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.djinons.schooleschedule.R;

/**
 * Created by macbookpro on 162//18.
 */

public class Info_dialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View info_dialog = inflater.inflate(R.layout.info_dialog,null);

        ImageButton closeButton = info_dialog.findViewById(R.id.closeButton);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Info_dialog.this.dismiss();
            }
        });

        builder.setView(info_dialog);



        return builder.create();
    }


}
