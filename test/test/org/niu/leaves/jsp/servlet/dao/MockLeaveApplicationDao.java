package test.org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.dao.LeaveApplicationDao;
import org.niu.leaves.jsp.servlet.model.LeaveApplicationHistory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MockLeaveApplicationDao implements LeaveApplicationDao {
    public void insertLeaveApplication(int userId, String dateFrom, String dateTo, Double days, String reason, String sickType, int managerId) throws SQLException {

    }

    public List<LeaveApplicationHistory> queryLeaveHistory(int userId, String leaveType, String fromDate, String toDate, int start, int end) throws SQLException {
        ArrayList<LeaveApplicationHistory> leaveApplicationHistoryList = new ArrayList<>();
        LeaveApplicationHistory leaveApplicationHistory = new LeaveApplicationHistory();
        leaveApplicationHistory.setId(1);
        leaveApplicationHistory.setUserName("SunnyNiu");
        leaveApplicationHistory.setLeaveType("Sick Leave");
        leaveApplicationHistory.setFromDate("2017-04-01");
        leaveApplicationHistory.setToate("2017-04-01");
        leaveApplicationHistory.setDays(1.0);
        leaveApplicationHistory.setStatus("Pending");
        leaveApplicationHistory.setApproverName("John");
        leaveApplicationHistoryList.add(leaveApplicationHistory);
        return leaveApplicationHistoryList;
    }

    public List<LeaveApplicationHistory> queryApplicationByStatus(int approverId, String status) throws SQLException {
        ArrayList<LeaveApplicationHistory> leaveApplicationHistoryList = new ArrayList<>();
        if (approverId == 1) {
            LeaveApplicationHistory leaveApplicationHistory = new LeaveApplicationHistory();
            leaveApplicationHistory.setId(1);
            leaveApplicationHistory.setUserName("SunnyNiu");
            leaveApplicationHistory.setLeaveType("Sick Leave");
            leaveApplicationHistory.setFromDate("2017-04-01");
            leaveApplicationHistory.setToate("2017-04-01");
            leaveApplicationHistory.setDays(1.0);
            leaveApplicationHistory.setStatus("Pending");
            leaveApplicationHistory.setApproverName("John");
            leaveApplicationHistoryList.add(leaveApplicationHistory);
        }
        return leaveApplicationHistoryList;
    }

    public LeaveApplicationHistory getApplicationById(int applicationId) throws SQLException {
        LeaveApplicationHistory leaveApplicationHistory = new LeaveApplicationHistory();
        if (applicationId == 1) {
            leaveApplicationHistory.setId(1);
            leaveApplicationHistory.setUserName("SunnyNiu");
            leaveApplicationHistory.setLeaveType("Sick Leave");
            leaveApplicationHistory.setFromDate("2017-04-01");
            leaveApplicationHistory.setToate("2017-04-01");
            leaveApplicationHistory.setDays(1.0);
            leaveApplicationHistory.setStatus("Pending");
            leaveApplicationHistory.setApproverName("John");
        }
        return leaveApplicationHistory;
    }

    public void updateApplicationStatus(int applicationId, String status) throws SQLException {
    }


    public int getTotalDays(String from, String to) throws SQLException {
        return Integer.parseInt(from) - Integer.parseInt(to);
    }

    public int queryTotalRecords(int userId, String leaveType, String fromDate, String toDate) {
        return 0;
    }
}
