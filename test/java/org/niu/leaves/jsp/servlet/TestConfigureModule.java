package org.niu.leaves.jsp.servlet;

import com.google.inject.Binder;
import com.google.inject.Module;
import org.niu.leaves.jsp.servlet.dao.*;

/**
 * Created by Sunny on 10/04/2017.
 */
public class TestConfigureModule implements Module {

    public void configure(Binder binder){
        binder.bind(DepartmentDao.class).to(MockDepartmentDao.class);
        binder.bind(LeaveApplicationDao.class).to(MockLeaveApplicationDao.class);
        binder.bind(LeaveTypeDao.class).to(MockLeaveTypeDao.class);
        binder.bind(LoginDao.class).to(MockLoginDao.class);
        binder.bind(TitleDao.class).to(MockTitleDao.class);
        binder.bind(UserDao.class).to(MockUserDao.class);
    }
}
