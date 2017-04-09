package org.niu.leaves.jsp.servlet.model;

/**
 * Created by Sunny on 2/04/2017.
 */
public class Permission {
    private boolean approveRejectIsPermitted;
    private boolean addMemberIsPermitted;

    public boolean isApproveRejectIsPermitted() {
        return approveRejectIsPermitted;
    }

    public void setApproveRejectIsPermitted(boolean approveRejectIsPermitted) {
        this.approveRejectIsPermitted = approveRejectIsPermitted;
    }

    public boolean isAddMemberIsPermitted() {
        return addMemberIsPermitted;
    }

    public void setAddMemberIsPermitted(boolean addMemberIsPermitted) {
        this.addMemberIsPermitted = addMemberIsPermitted;
    }
}
