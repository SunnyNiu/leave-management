package org.niu.leaves.jsp.servlet.service;

import org.niu.leaves.jsp.servlet.dao.LeaveTypeDAO;
import org.niu.leaves.jsp.servlet.model.LeaveType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunny on 3/04/2017.
 */
public class LeaveTypeService {
    private LeaveTypeDAO leaveTypeDAO = new LeaveTypeDAO();

    public List<LeaveType> getLeaveTypes() throws SQLException {
        List<LeaveType> leaveTypes = leaveTypeDAO.queryLeaveTypes();
        return leaveTypes;
    }

    public boolean leaveTypeExist(int leaveTypeId) throws SQLException {
        List<LeaveType> leaveTypes = leaveTypeDAO.queryLeaveTypes();
        for (LeaveType leaveTypeValue : leaveTypes) {
            if (leaveTypeValue.getId() == leaveTypeId) {
                return true;
            }
        }
        return false;
    }
}
