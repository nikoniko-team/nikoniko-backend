package br.com.senac.nikoniko.repositories;

import br.com.senac.nikoniko.dtos.EntryDto;
import br.com.senac.nikoniko.entities.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {

    @Transactional(readOnly = true)
    Mood findByName(String name);

    @Transactional(readOnly = true)
    Mood findByUrl(String url);

    @Query("SELECT new br.com.senac.nikoniko.dtos.EntryDto(m.name, count(r.mood.id)) " +
        "FROM Mood m " +
        "JOIN m.recordList r " +
        "JOIN r.teamUser tu " +
        "WHERE tu.teamId = :teamId " +
        "AND r.date BETWEEN :startDate AND :endDate " +
        "GROUP BY m.name")
    List<EntryDto> findPeriodByTeamId(Long teamId, OffsetDateTime startDate, OffsetDateTime endDate);
}
