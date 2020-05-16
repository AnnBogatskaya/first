package org.bogatskaya.schedule.app.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bogatskaya.schedule.app.domain.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="roles")
public class Role extends SuperEntity{

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userList = new ArrayList<>();

    public Role(final Long id) {
        super(id);
    }

    public void addUser(User user) {
        if(!userList.contains(user)) {
            userList.add(user);
        }
    }

}
