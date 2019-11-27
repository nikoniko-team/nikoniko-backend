package br.com.senac.nikoniko.repositories;

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

    @Query("SELECT m " +
        "FROM Mood m " +
        "JOIN m.recordList r " +
        "JOIN r.teamUser tu " +
        "JOIN tu.team t " +
        "WHERE t.id = :teamId " +
        "AND r.date BETWEEN :startDate AND :endDate")
    List<Mood> findCurrentMonthByTeamId(Long teamId, OffsetDateTime startDate, OffsetDateTime endDate);
}
