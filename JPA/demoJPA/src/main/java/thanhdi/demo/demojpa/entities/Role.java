package thanhdi.demo.demojpa.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {

    @Id
    @Column(name = "roleid")
    private int roleid;

    @Column(name = "name", length = 100, nullable = false)
    private String name;
}
