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
@Table(name = "team", schema = "public")
public class Team {

    @Id
    @SequenceGenerator(name = "team_id_entity_seq", sequenceName = "team_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_id_entity_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "team")
    private List<TeamUser> teamUserList;

}
