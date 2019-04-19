package com.djinons.schooleschedule.models;

/**
 * Created by macbookpro on 83//18.
 */

public class SchedulenameModel {

    private int scheduleid;
    private String schedulename;

    public SchedulenameModel(int id, String schedulename) {
        this.setId(id);
        this.setSchedulename(schedulename);
    }

    public int getId() {
        return scheduleid;
    }

    public void setId(int id) {
        this.scheduleid = id;
    }

    public String getSchedulename() {
        return schedulename;
    }

    public void setSchedulename(String schedulename) {
        this.schedulename = schedulename;
    }
}
