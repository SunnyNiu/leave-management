package test.org.niu.leaves.jsp.servlet.dao;

import org.niu.leaves.jsp.servlet.dao.DepartmentDao;
import org.niu.leaves.jsp.servlet.model.UserWithDepartmentInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MockDepartmentDao implements DepartmentDao {

    public List<UserWithDepartmentInfo> queryAllDepartments() throws SQLException {
        List<UserWithDepartmentInfo> userWithDepartmentInfoList = new ArrayList<UserWithDepartmentInfo>();;
        UserWithDepartmentInfo userWithDepartmentInfo1 = new UserWithDepartmentInfo();
        userWithDepartmentInfo1.setDepartmentId("001");
        userWithDepartmentInfo1.setDepartmentName("IT");
        userWithDepartmentInfo1.setManagerUserId(1);
        userWithDepartmentInfo1.setManagerName("John");
        userWithDepartmentInfoList.add(userWithDepartmentInfo1);
        UserWithDepartmentInfo userWithDepartmentInfo2 = new UserWithDepartmentInfo();
        userWithDepartmentInfo2.setDepartmentId("002");
        userWithDepartmentInfo2.setDepartmentName("Sales");
        userWithDepartmentInfo2.setManagerUserId(2);
        userWithDepartmentInfo2.setManagerName("KongNiu");
        userWithDepartmentInfoList.add(userWithDepartmentInfo2);
        UserWithDepartmentInfo userWithDepartmentInfo3 = new UserWithDepartmentInfo();
        userWithDepartmentInfo3.setDepartmentId("001");
        userWithDepartmentInfo3.setDepartmentName("IT");
        userWithDepartmentInfo3.setManagerUserId(2);
        userWithDepartmentInfo3.setManagerName("Kong");
        userWithDepartmentInfoList.add(userWithDepartmentInfo3);
        UserWithDepartmentInfo userWithDepartmentInfo4 = new UserWithDepartmentInfo();
        userWithDepartmentInfo4.setDepartmentId("001");
        userWithDepartmentInfo4.setDepartmentName("IT");
        userWithDepartmentInfo4.setManagerUserId(1);
        userWithDepartmentInfo4.setManagerName("John");
        userWithDepartmentInfoList.add(userWithDepartmentInfo4);
        return userWithDepartmentInfoList;
    }


    public UserWithDepartmentInfo getDepartmentManagerByUserId(int userId) throws SQLException {
        if(userId ==1){
            UserWithDepartmentInfo userWithDepartmentInfo1 = new UserWithDepartmentInfo();
            userWithDepartmentInfo1.setDepartmentId("001");
            userWithDepartmentInfo1.setDepartmentName("IT");
            userWithDepartmentInfo1.setManagerUserId(1);
            userWithDepartmentInfo1.setManagerName("John");
            return userWithDepartmentInfo1;
        }else if(userId ==2){
            UserWithDepartmentInfo userWithDepartmentInfo2 = new UserWithDepartmentInfo();
            userWithDepartmentInfo2.setDepartmentId("002");
            userWithDepartmentInfo2.setDepartmentName("Sales");
            userWithDepartmentInfo2.setManagerUserId(2);
            userWithDepartmentInfo2.setManagerName("KongNiu");
            return userWithDepartmentInfo2;
        }else{
            throw new SQLException("user not found");
        }
    }
}
