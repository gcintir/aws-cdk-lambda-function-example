package com.awscloudprojects.model;

public class InputText {
    private String text;
    public InputText(String text) {
        this.text = text;
    }
    public InputText() {
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
