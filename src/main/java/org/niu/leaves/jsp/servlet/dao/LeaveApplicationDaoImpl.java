package org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.model.LeaveApplicationHistory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaveApplicationDaoImpl implements LeaveApplicationDao {

    //insert leave application into database
    public void insertLeaveApplication(int userId, String dateFrom, String dateTo, Double days, String reason, String sickType, int managerId) throws SQLException, IOException {
        String sql = "INSERT INTO AP_LEAVE_APPLICATION (USERID,FROM_DATE,TO_DATE,TOTAL_DAYS,REASONS,LEAVE_TYPE_ID,STATUS,APPROVER_USER_ID) " +
                "VALUES ( ? , TO_DATE( ?,'yyyy/mm/dd'),TO_DATE(?,'yyyy/mm/dd'),  ? , ? ," +
                "? ,'Pending',?)";
        int i = 1;
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(i++, userId);
            ps.setString(i++, dateFrom);
            ps.setString(i++, dateTo);
            ps.setDouble(i++, days);
            ps.setString(i++, reason);
            ps.setString(i++, sickType);
            ps.setInt(i++, managerId);
            ps.executeUpdate();
        }
    }

    //Search leaveHistory by user, fromDate, toDate, leaveType
    public List<LeaveApplicationHistory> queryLeaveHistory(int userId, String leaveType, String fromDate, String toDate, int startRow, int endRow) throws SQLException, IOException {
        String sql = " select * from (select rownum runm, a.* from(select application.ID as id,application.USERID as userId,application.FROM_DATE as fromDate, " +
                "application.TO_DATE as toDate,application.STATUS as status, " +
                "application.REASONS as reason,application.TOTAL_DAYS as days, " +
                "leaveType.LEAVE_TYPE as leaveType,u.FIRST_NAME||u.LAST_NAME as managerName, " +
                "users.FIRST_NAME||users.LAST_NAME as username " +
                "from AP_LEAVE_APPLICATION application " +
                "inner join AP_LEAVE_TYPE leaveType " +
                "on application.LEAVE_TYPE_ID=leaveType.ID and application.userId =? and leaveType.ID=? " +
                "and application.from_date >= TO_DATE(?,'yyyy/mm/dd') " +
                "and application.TO_DATE <=TO_DATE(?,'yyyy/mm/dd') " +
                "left join AP_USERS u on application.APPROVER_USER_ID=u.USERID " +
                "left join AP_USERS users on users.USERID = application.USERID )  a where rownum <= ?)where runm > = ?";

        ResultSet rs = null;
        ArrayList<LeaveApplicationHistory> leaveApplicationHistoryList;
        int i = 1;
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(i++, userId);
            ps.setInt(i++, Integer.parseInt(leaveType));
            ps.setString(i++, fromDate);
            ps.setString(i++, toDate);
            ps.setInt(i++, endRow);
            ps.setInt(i++, startRow);
            rs = ps.executeQuery();
            leaveApplicationHistoryList = getLeaveHistoryResult(rs);
            return leaveApplicationHistoryList;
        } finally {
            if (rs != null)
                rs.close();
        }
    }


    public int queryTotalRecords(int userId, String leaveType, String fromDate, String toDate) throws SQLException, IOException {
        String sql = "select  count(*) as totalRecord " +
                "from AP_LEAVE_APPLICATION application " +
                "inner join AP_LEAVE_TYPE leaveType " +
                "on application.LEAVE_TYPE_ID=leaveType.ID and application.userId =? and leaveType.ID=? " +
                "and application.from_date >= TO_DATE(?,'yyyy/mm/dd') " +
                "and application.TO_DATE <=TO_DATE(?,'yyyy/mm/dd') " +
                "left join AP_USERS u on application.APPROVER_USER_ID=u.USERID " +
                "left join AP_USERS users on users.USERID = application.USERID ";

        ResultSet rs = null;
        int i = 1;
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(i++, userId);
            ps.setInt(i++, Integer.parseInt(leaveType));
            ps.setString(i++, fromDate);
            ps.setString(i++, toDate);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("totalRecord");
            } else {
                return 0;
            }
        } finally {
            if (rs != null)
                rs.close();
        }
    }

    public List<LeaveApplicationHistory> queryApplicationByStatus(int approverId, String status, int start, int end) throws SQLException, IOException {
        String sql = "select * from (select rownum runm, a.* from (select application.ID as id,application.USERID as userId,application.FROM_DATE as fromDate,  " +
                "                application.TO_DATE as toDate,application.STATUS as status,  " +
                "                application.REASONS as reason,application.TOTAL_DAYS as days,  " +
                "                leaveType.LEAVE_TYPE as leaveType,u.FIRST_NAME||u.LAST_NAME as managerName, " +
                "                users.FIRST_NAME||users.LAST_NAME as username " +
                "                from AP_LEAVE_APPLICATION application  " +
                "                inner join AP_LEAVE_TYPE leaveType " +
                "                on application.LEAVE_TYPE_ID=leaveType.ID and application.APPROVER_USER_ID =? and application.STATUS=? " +
                "                left join AP_USERS u on application.APPROVER_USER_ID=u.USERID  " +
                "                left join AP_USERS users on users.USERID = application.USERID order by application.id)  a where rownum <= ?)where runm > = ?";
        ResultSet rs = null;
        ArrayList<LeaveApplicationHistory> leaveApplicationHistoryList;
        int i = 1;
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(i++, approverId);
            ps.setString(i++, status);
            ps.setInt(i++, end);
            ps.setInt(i++, start);
            rs = ps.executeQuery();
            leaveApplicationHistoryList = getLeaveHistoryResult(rs);
            return leaveApplicationHistoryList;
        } finally {
            if (rs != null)
                rs.close();
        }
    }

    public int queryTotalApplicationByStatus(int approverId, String status) throws SQLException, IOException {
        String sql = " select count(*)  as totalNumber from (select application.ID as id,application.USERID as userId,application.FROM_DATE as fromDate,  " +
                "                application.TO_DATE as toDate,application.STATUS as status,  " +
                "                application.REASONS as reason,application.TOTAL_DAYS as days,  " +
                "                leaveType.LEAVE_TYPE as leaveType,u.FIRST_NAME||u.LAST_NAME as managerName, " +
                "                users.FIRST_NAME||users.LAST_NAME as username " +
                "                from AP_LEAVE_APPLICATION application  " +
                "                inner join AP_LEAVE_TYPE leaveType " +
                "                on application.LEAVE_TYPE_ID=leaveType.ID and application.APPROVER_USER_ID =? and application.STATUS=? " +
                "                left join AP_USERS u on application.APPROVER_USER_ID=u.USERID  " +
                "                left join AP_USERS users on users.USERID = application.USERID)";
        ResultSet rs = null;
        int i = 1;
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(i++, approverId);
            ps.setString(i++, status);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("totalNumber");
            } else return 0;
        } finally {
            if (rs != null)
                rs.close();
        }
    }


    public LeaveApplicationHistory getApplicationById(int applicationId) throws SQLException, IOException {
        String sql = "select application.ID as id,application.USERID as userId,application.FROM_DATE as fromDate,  " +
                "                application.TO_DATE as toDate,application.STATUS as status,  " +
                "                application.REASONS as reason,application.TOTAL_DAYS as days,  " +
                "                leaveType.LEAVE_TYPE as leaveType,u.FIRST_NAME||u.LAST_NAME as managerName," +
                "                u.USERID as managerId, u.OFFICE_EMAIL as managerEmail, u.EMAIL_PASSWORD as managerEmailPassword,  " +
                "                users.FIRST_NAME||users.LAST_NAME as username, users.OFFICE_EMAIL as userEamil, " +
                "                users.EMAIL_PASSWORD as userEmailPassword " +
                "                from AP_LEAVE_APPLICATION application  " +
                "                inner join AP_LEAVE_TYPE leaveType " +
                "                on application.LEAVE_TYPE_ID=leaveType.ID and application.ID =? " +
                "                left join AP_USERS u on application.APPROVER_USER_ID=u.USERID  " +
                "                left join AP_USERS users on users.USERID = application.USERID ";
        ResultSet rs = null;
        LeaveApplicationHistory leaveApplicationHistory = new LeaveApplicationHistory();
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, applicationId);
            rs = ps.executeQuery();
            while (rs.next()) {
                leaveApplicationHistory.setId(applicationId);
                leaveApplicationHistory.setUserName(rs.getString("username"));
                leaveApplicationHistory.setLeaveType(rs.getString("leaveType"));
                leaveApplicationHistory.setFromDate(rs.getString("fromDate"));
                leaveApplicationHistory.setToate(rs.getString("toDate"));
                leaveApplicationHistory.setDays(Double.parseDouble(rs.getString("days")));
                leaveApplicationHistory.setStatus(rs.getString("status"));
                leaveApplicationHistory.setApproverName(rs.getString("managerName"));
                leaveApplicationHistory.setManagerId(Integer.parseInt(rs.getString("managerId")));
                leaveApplicationHistory.setUserEmail(rs.getString("userEamil"));
                leaveApplicationHistory.setManagerEmail(rs.getString("managerEmail"));
                leaveApplicationHistory.setUserEmailPassword(rs.getString("userEmailPassword"));
                leaveApplicationHistory.setManagerEmailPassword(rs.getString("managerEmailPassword"));
            }
            return leaveApplicationHistory;
        } finally {
            if (rs != null)
                rs.close();
        }
    }

    //updateStatus
    public void updateApplicationStatus(int applicationId, String status) throws SQLException, IOException {
        String sql = "UPDATE AP_LEAVE_APPLICATION SET status =? WHERE ID =?";
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            int i = 1;
            ps.setString(i++, status);
            ps.setInt(i++, applicationId);
            ps.executeUpdate();
            ps.close();
        }
    }

    public ArrayList<LeaveApplicationHistory> getLeaveHistoryResult(ResultSet rs) throws SQLException, IOException {
        ArrayList<LeaveApplicationHistory> leaveApplicationHistoryList = new ArrayList<>();
        while (rs.next()) {
            LeaveApplicationHistory leaveApplicationHistory = new LeaveApplicationHistory();
            leaveApplicationHistory.setId(rs.getInt("id"));
            leaveApplicationHistory.setUserName(rs.getString("username"));
            leaveApplicationHistory.setLeaveType(rs.getString("leaveType"));
            leaveApplicationHistory.setFromDate(rs.getString("fromDate"));
            leaveApplicationHistory.setToate(rs.getString("toDate"));
            leaveApplicationHistory.setDays(rs.getDouble("days"));
            leaveApplicationHistory.setStatus(rs.getString("status"));
            leaveApplicationHistory.setApproverName(rs.getString("managerName"));
            leaveApplicationHistoryList.add(leaveApplicationHistory);
        }
        return leaveApplicationHistoryList;
    }

    public int getTotalDays(String from, String to) throws SQLException, IOException {
        ResultSet rs = null;
        String sql = "select ceil(To_date(?,'yyyy/mm/dd') - To_date(?,'yyyy/mm/dd')) as days FROM DUAL";
        int i = 1;
        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(i++, to);
            ps.setString(i++, from);
            rs = ps.executeQuery();
            if (rs.next())
                return rs.getInt("days") + 1;
            else {
                throw new SQLException("There is something wrong with from, to");
            }
        } finally {
            if (rs != null)
                rs.close();
        }
    }
}
