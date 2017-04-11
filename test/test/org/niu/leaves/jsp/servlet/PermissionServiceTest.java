package test.org.niu.leaves.jsp.servlet;

import org.junit.Before;
import org.junit.Test;
import org.niu.leaves.jsp.servlet.ConfigurationGuice.GuiceInjector;
import org.niu.leaves.jsp.servlet.model.Permission;
import org.niu.leaves.jsp.servlet.service.PermissionService;

import java.io.IOException;
import java.sql.SQLException;


import static org.junit.Assert.assertEquals;

/**
 * Created by Sunny on 11/04/2017.
 */
public class PermissionServiceTest {

    @Before
    public void initializeInjector() {
        GuiceInjector.initializeInjector(new TestConfigureModule());
    }

    @Test
    public void getUserPermission() throws SQLException, IOException {
        PermissionService permissionService = new PermissionService();
        Permission p = permissionService.getUserPermission("SunnyN");
        assertEquals("Add new member is not allowed",false ,p.isAddMemberIsPermitted()&&p.isApproveRejectIsPermitted());
    }
}
