package org.niu.leaves.jsp.servlet.model;

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
