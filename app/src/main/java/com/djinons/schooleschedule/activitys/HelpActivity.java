package com.djinons.schooleschedule.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.djinons.schooleschedule.R;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        TextView helpContentTextView = findViewById(R.id.help_content);
        Button okbutton = findViewById(R.id.okbutton);


        helpContentTextView.setText(Html.fromHtml(getString(R.string.help_content)));


        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(HelpActivity.this, MainActivity.class);
                HelpActivity.this.startActivity(mainIntent);
    }
});
    }
}