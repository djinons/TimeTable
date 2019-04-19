package com.djinons.schooleschedule.activitys;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.djinons.schooleschedule.CustomAdapter;
import com.djinons.schooleschedule.DbHelper;
import com.djinons.schooleschedule.R;
import com.djinons.schooleschedule.models.ClassnameModel;

import java.util.ArrayList;



public class AddClassNameActivity extends ListActivity {


    ListView listView;
    EditText editTextView;
    ArrayList<ClassnameModel> itemClassnameModelList;
    CustomAdapter customAdapter;
    DbHelper myDb;
    int id;
    String name;
    ArrayList<ClassnameModel> ClassnameArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_class_name);
        listView = (ListView) findViewById(R.id.listView);
        editTextView = (EditText) findViewById(R.id.editTextView);
        itemClassnameModelList = new ArrayList<ClassnameModel>();
        customAdapter = new CustomAdapter(getApplicationContext(), itemClassnameModelList);
        listView.setEmptyView(findViewById(android.R.id.empty));

        ClassnameArray = new ArrayList<>();
        myDb = new DbHelper(this);
        myDb.getWritableDatabase();
        Cursor resclass = myDb.getAllDataClass();

        while (resclass.moveToNext()){
            ClassnameModel Classname = new ClassnameModel(id,name);
            Classname.setId(resclass.getInt(0));
            Classname.setClassname(resclass.getString(1));

            if (Classname.getId()!=1) {

                itemClassnameModelList.add(Classname);
                ClassnameArray.add(Classname);
            }

        }
        resclass.close();
        myDb.close();

        listView.setAdapter(customAdapter);

    }
    @SuppressLint("NewApi")
    public void addValue(View v) {
        String name = editTextView.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(getApplicationContext(), R.string.please_enter_classname,
                    Toast.LENGTH_SHORT).show();
        } else {


            ClassnameModel classname = new ClassnameModel(id,name);

            myDb.getWritableDatabase();


            itemClassnameModelList.add(classname);
            myDb.insertDataClass(name);
            myDb.close();
            customAdapter.notifyDataSetChanged();
            editTextView.setText("");
        }
    }

    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(AddClassNameActivity.this, MainActivity.class);
        AddClassNameActivity.this.startActivity(mainIntent);
        super.onBackPressed();
    }
}
