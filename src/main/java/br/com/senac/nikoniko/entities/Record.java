package br.com.senac.nikoniko.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
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

    @ManyToOne
    @JoinColumn(name = "mood_id", referencedColumnName = "id")
    private Mood mood;

    @OneToMany(mappedBy = "record")
    private List<RecordTag> recordTagList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "team_user_id", referencedColumnName = "id")
    private TeamUser teamUser;

    @Column(name = "date")
    private OffsetDateTime date;

    public LocalDate getLocalDate() {
        return date.toLocalDate();
    }

    public void setTags(List<Tag> tags) {
        if (tags != null) {
            tags.forEach(tag -> recordTagList.add(new RecordTag(tag)));
        }
    }
}
