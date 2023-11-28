package org.example.models;

import jakarta.persistence.*;
import org.example.models.enums.Role;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity {


    private Role role;

    private Set<User> users;

    public UserRole(){}
    public UserRole(Role role, Set<User> users){
        this.role = role;
        this.users = users;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
