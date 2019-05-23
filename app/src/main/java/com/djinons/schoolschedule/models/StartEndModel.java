package com.djinons.schoolschedule.models;

public class StartEndModel {

    private String startAM;
    private String endAM;
    private String startPM;
    private String endPM;

    public StartEndModel(String startAM,String endAM, String startPM, String endPM){

        this.setStartAM(startAM);
        this.setEndAM(endAM);
        this.setStartPM(startPM);
        this.setEndPM(endPM);

    }

    public String getStartAM() {
        return startAM;
    }

    public void setStartAM(String startAM) {
        this.startAM = startAM;
    }

    public String getEndAM() {
        return endAM;
    }

    public void setEndAM(String endAM) {
        this.endAM = endAM;
    }

    public String getStartPM() {
        return startPM;
    }

    public void setStartPM(String startPM) {
        this.startPM = startPM;
    }

    public String getEndPM() {
        return endPM;
    }

    public void setEndPM(String endPM) {
        this.endPM = endPM;
    }
}
