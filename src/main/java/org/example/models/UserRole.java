package org.example.models;

import jakarta.persistence.*;
import org.example.models.enums.Role;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity {

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role")
    private Role role;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<User> users;

    public UserRole(){}
    public UserRole(Role role, Set<User> users){
        this.role = role;
        this.users = users;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
