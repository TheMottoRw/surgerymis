package com.op.surgerymis.dto;

import com.op.surgerymis.helpers.Utils;

import java.util.Date;

public class OperationStatDTO {
    private String month;
    private String repetition;

    public OperationStatDTO(Date month, String repetition){
        System.out.println(Utils.getCurrentYear());
            this.month = !String.valueOf(month).equals("null") ? String.valueOf(month).substring(0, 7) : "N/A";
            this.repetition = repetition;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getRepetition() {
        return repetition;
    }

    public void setRepetition(String repetition) {
        this.repetition = repetition;
    }
}
