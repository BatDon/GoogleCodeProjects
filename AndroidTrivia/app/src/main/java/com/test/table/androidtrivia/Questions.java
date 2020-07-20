package com.test.table.androidtrivia;

import java.util.List;

public class Questions {
    String text;
    List<String> answers;

    public Questions(String text, List<String> answers){
        this.text=text;
        this.answers=answers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
