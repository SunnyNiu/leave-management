package org.niu.leaves.jsp.servlet.utility;

import org.niu.leaves.jsp.servlet.model.ApplicationForm;
import org.niu.leaves.jsp.servlet.model.RowDetail;

import java.util.ArrayList;

public class InitializeLeaveApplicationForm {
    public ApplicationForm initializeApplicationForm(){
        ApplicationForm applicationForm = new ApplicationForm();
        RowDetail rowDetail = new RowDetail();
        ArrayList<RowDetail> rowDetailList = new ArrayList<>();
        rowDetail.setFromDate(" ");
        rowDetailList.add(rowDetail);
        applicationForm.setLeaveList(rowDetailList);
        return applicationForm;
    }
}
