package com.op.surgerymis.dto;

import java.util.Date;

public class OperationStatDTO {
    private String month;
    private long repetition;

    public OperationStatDTO(Date month, long repetition){
        this.month = !String.valueOf(month).equals("null")?String.valueOf(month).substring(0,7):"N/A";
        this.repetition = repetition;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public long getRepetition() {
        return repetition;
    }

    public void setRepetition(long repetition) {
        this.repetition = repetition;
    }
}
