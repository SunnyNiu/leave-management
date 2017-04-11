package test.org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.dao.LeaveTypeDao;
import org.niu.leaves.jsp.servlet.model.LeaveType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunny on 10/04/2017.
 */
public class MockLeaveTypeDao implements LeaveTypeDao {
    public List<LeaveType> queryLeaveTypes() throws SQLException {
        List<LeaveType> leaveTypeList = new ArrayList<>();
        LeaveType leaveType = null;
        leaveType.setId(1);
        leaveType.setLeaveType("Sick Leave");
        leaveTypeList.add(leaveType);
        LeaveType leaveType1 = null;
        leaveType1.setId(2);
        leaveType1.setLeaveType("Annual Leave");
        leaveTypeList.add(leaveType1);
        return leaveTypeList;
    }
}
