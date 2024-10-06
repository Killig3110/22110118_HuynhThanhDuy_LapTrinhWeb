package thanhdi.demo.demojpa.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId")
    private int userId;
    @Column(name="Username", columnDefinition = "NVARCHAR(50) NOT NULL")
    private String username;
    @Column(name="Password", columnDefinition = "NVARCHAR(50) NOT NULL")
    private String password;
    @Column(name="Images", columnDefinition = "NVARCHAR(500) NULL")
    private String images;
    @Column(name="Fullname", columnDefinition = "NVARCHAR(200) NOT NULL")
    private String fullname;
    @Column(name="Email", columnDefinition = "NVARCHAR(200) NOT NULL")
    private String email;
    @Column(name="Phone", columnDefinition = "NVARCHAR(20) NULL")
    private String phone;
    @Column(name="RoleId")
    private int roleId;
    @Column(name="CreateDate")
    private String createDate;
    //bi-directional many-to-one association to Role
    @ManyToOne
    @JoinColumn(name="RoleId", insertable = false, updatable = false)
    private Role role;
    public User() {
    }
    public User(String username, String password, String images, String fullname, String email, String phone, int roleId, String createDate) {
        this.username = username;
        this.password = password;
        this.images = images;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.roleId = roleId;
        this.createDate = createDate;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getImages() {
        return images;
    }
    public void setImages(String images) {
        this.images = images;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
