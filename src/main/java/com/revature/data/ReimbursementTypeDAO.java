package com.revature.data;

import com.revature.beans.ReimbursementType;

import java.util.List;

public interface ReimbursementTypeDAO {
    ReimbursementType getReimbursementType(int typeID);

    List<ReimbursementType> getReimbursementTypes();
}
