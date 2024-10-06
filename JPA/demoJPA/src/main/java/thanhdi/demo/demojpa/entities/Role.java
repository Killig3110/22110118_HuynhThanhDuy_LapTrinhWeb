package thanhdi.demo.demojpa.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleId")
    private int roleid;

    @Column(name = "RoleName", length = 100, nullable = false)
    private String name;

    // Default constructor
    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    // Getters and Setters
    public int getRoleId() {
        return roleid;
    }

    public void setRoleId(int roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
