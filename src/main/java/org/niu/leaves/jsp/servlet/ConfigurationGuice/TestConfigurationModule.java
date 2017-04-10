package org.niu.leaves.jsp.servlet.ConfigurationGuice;

import com.google.inject.Binder;
import com.google.inject.Module;
import org.niu.leaves.jsp.servlet.dao.*;

public class TestConfigurationModule implements Module {
    public void configure(Binder binder) {
        binder.bind(DepartmentDao.class).to(DepartmentDaoImpl.class);
        binder.bind(LeaveApplicationDao.class).to(LeaveApplicationDaoImpl.class);
        binder.bind(LeaveTypeDao.class).to(LeaveTypeDaoImpl.class);
        binder.bind(LoginDao.class).to(LoginDaoImpl.class);
        binder.bind(TitleDao.class).to(TitleDaoImpl.class);
        binder.bind(UserDao.class).to(UserDaoImpl.class);
    }
}

