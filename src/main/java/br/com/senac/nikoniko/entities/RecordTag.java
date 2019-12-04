package br.com.senac.nikoniko.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "record_tag", schema = "public")
public class RecordTag {

    @Id
    @SequenceGenerator(name = "record_tag_entity_seq", sequenceName = "record_tag_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "record_tag_entity_seq")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "record_id", referencedColumnName = "id")
    private Record record;

    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    private Tag tag;

    @Column(name = "comment")
    private String comment;

    public RecordTag(Tag tag) {
        this.tag = tag;
    }
}
