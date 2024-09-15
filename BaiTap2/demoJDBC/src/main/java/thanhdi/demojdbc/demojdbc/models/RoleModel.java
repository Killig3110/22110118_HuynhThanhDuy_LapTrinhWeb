package thanhdi.demojdbc.demojdbc.models;

public class RoleModel {
    private String roleid;
    private String rollname;

    public RoleModel() {
        super();
    }

    public RoleModel(String roleid, String rollname) {
        super();
        this.roleid = roleid;
        this.rollname = rollname;
    }

    public String getRoleid() {
        return roleid;
    }
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRollname() {
        return rollname;
    }
    public void setRollname(String rollname) {
        this.rollname = rollname;
    }

    @Override
    public String toString() {
        return "RoleModel [rollid=" + roleid +
                ", rollname=" + rollname + "]";
    }
}
