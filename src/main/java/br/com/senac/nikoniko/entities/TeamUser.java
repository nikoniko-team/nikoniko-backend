package br.com.senac.nikoniko.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "team_user", schema = "public")
public class TeamUser {

    @Id
    @SequenceGenerator(name = "team_user_entity_seq", sequenceName = "team_user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_user_entity_seq")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "teamUser")
    private List<Record> recordList;

    @Column(name = "team_id", insertable = false, updatable = false)
    private Long teamId;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    public Long getUserId() {
        return user == null ? null : user.getId();
    }

    public String getUserName() {
        return user == null ? null : user.getName();
    }

}
