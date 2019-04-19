package com.djinons.schooleschedule.models;

/**
 * Created by macbookpro on 182//18.
 */

public class ClassnameModel {

    private int id;
    private String classname;

    public ClassnameModel(int id, String classname) {
        this.id = id;
        this.classname = classname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
       this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
