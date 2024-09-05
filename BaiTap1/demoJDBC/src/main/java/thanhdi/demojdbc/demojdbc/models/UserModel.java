package thanhdi.demojdbc.demojdbc.models;

public class UserModel {
    private int id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String images;

    public UserModel() {
        super();
    }

    public UserModel(String username, String password, String email, String fullname, String images) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.images = images;
    }

    public UserModel(int id, String username, String password, String email, String fullname, String images) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.images = images;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getImage() {
        return images;
    }
    public void setImage(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", images='" + images + '\'' +
                '}';
    }
}
