package org.bogatskaya.schedule.app.domain.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.bogatskaya.schedule.app.domain.Role;
import org.bogatskaya.schedule.app.domain.SuperEntity;
import org.bogatskaya.schedule.app.domain.schedule.Record;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "users")
public class User extends SuperEntity implements Serializable{

    @Column(name="fullname")
    private String fullname;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="users_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "users_records", joinColumns = @JoinColumn(name = "record_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Record> recordList = new ArrayList<>();

    @Column(name = "isconfirmed")
    private Boolean isConfirmed = false;

    public void addRole(Role role) {
        if(!roles.contains(role)) {
            roles.add(role);
        }
    }

    public boolean hasRole(String role) {
        return roles.stream().anyMatch(r -> r.getName().equalsIgnoreCase(role));
    }

    public void addRecord(Record record) {
        if(!recordList.contains(record)) {
            recordList.add(record);
        }
    }
}
