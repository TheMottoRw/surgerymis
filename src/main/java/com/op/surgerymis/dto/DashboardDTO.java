package com.op.surgerymis.dto;

import com.op.surgerymis.models.Operations;

import java.util.List;

public class DashboardDTO {
    private List<TransferStatDTO> transfers;
    private List<OperationStatDTO> operations;
    private UsersStatsDTO users;


    public List<TransferStatDTO> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<TransferStatDTO> transferStatDTO) {
        this.transfers = transferStatDTO;
    }

    public List<OperationStatDTO> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationStatDTO> operationStatDTO) {
        this.operations = operationStatDTO;
    }

    public UsersStatsDTO getUsers() {
        return users;
    }

    public void setUsers(UsersStatsDTO usersStatsDTO) {
        this.users = usersStatsDTO;
    }
}
