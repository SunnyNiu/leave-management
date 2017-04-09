package org.niu.leaves.jsp.servlet.utility;

import org.niu.leaves.jsp.servlet.model.RowDetail;

/**
 * Created by Sunny on 31/03/2017.
 */
public class AddRowDetail {
    public RowDetail addRowDetail(String from, String to, String totalDay) {
        RowDetail rowDetail = new RowDetail();
        rowDetail.setFromDate(from);
        rowDetail.setToDate(to);
        rowDetail.setTotalDays(totalDay);
        return rowDetail;
    }
}
