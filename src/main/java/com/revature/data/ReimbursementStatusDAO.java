package com.revature.data;

import com.revature.beans.ReimbursementStatus;

import java.util.List;

public interface ReimbursementStatusDAO {
    ReimbursementStatus getReimbursementStatus(int statusId);

    List<ReimbursementStatus> getReimbursementStatus();
}
