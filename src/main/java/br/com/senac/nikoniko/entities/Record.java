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
@Table(name = "record", schema = "public")
public class Record {

    @Id
    @SequenceGenerator(name = "record_entity_seq", sequenceName = "record_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "record_entity_seq")
    @Column(name = "id")
    private Long id;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "mood_id", referencedColumnName = "id")
    private Mood mood;

    @OneToMany(mappedBy = "record")
    private List<RecordTag> recordTagList;

}
