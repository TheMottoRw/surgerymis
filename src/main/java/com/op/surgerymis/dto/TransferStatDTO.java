package com.op.surgerymis.dto;

import javax.persistence.Entity;

public class TransferStatDTO {
    private String transfer;
    private long repetition;

    public TransferStatDTO(String transfer,long repetition){
        this.transfer = transfer;
        this.repetition = repetition;
    }
    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public long getRepetition() {
        return repetition;
    }

    public void setRepetition(long repetition) {
        this.repetition = repetition;
    }
}
