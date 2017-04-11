package test.org.niu.leaves.jsp.servlet;

import org.junit.Before;
import org.junit.Test;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.model.LeaveType;
import org.niu.leaves.jsp.servlet.service.LeaveTypeService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sunny on 11/04/2017.
 */
public class LeaveTypeServiceTest {
    @Before
    public void initializeInjector() {
        GuiceInjector.initializeInjector(new TestConfigureModule());
    }

    @Test
    public void getLeaveTypes() throws SQLException, IOException {
        LeaveTypeService leaveTypeService = new LeaveTypeService();
        List<LeaveType> leaveTypes = leaveTypeService.getLeaveTypes();
        String leaveType = "Sick Leave";
        assertEquals("Leave Types are not correct", leaveType, leaveTypes.get(0).getLeaveType());
    }

    @Test
    public void leaveTypeExist() throws SQLException, IOException {
        LeaveTypeService leaveTypeService = new LeaveTypeService();
        boolean exist = leaveTypeService.leaveTypeExist(3);
        assertEquals("Leave Type is not exist", false, exist);
    }
}
