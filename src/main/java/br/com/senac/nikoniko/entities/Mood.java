package br.com.senac.nikoniko.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mood", schema = "public")
public class Mood implements Serializable {

    private static final long serialVersionUID = -3707204625149437691L;

    @Id
    @SequenceGenerator(name = "mood_entity_seq", sequenceName = "mood_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mood_entity_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "mood")
    private List<Record> recordList;
}
