package br.com.senac.nikoniko.repositories;

import br.com.senac.nikoniko.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.OffsetDateTime;
import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query("SELECT r " +
        "FROM Record r " +
        "JOIN r.teamUser t " +
        "WHERE t.id = :teamUserId " +
        "AND r.date BETWEEN :startDate AND :endDate")
    List<Record> findCurrentWeekByTeamUserId(Long teamUserId, OffsetDateTime startDate, OffsetDateTime endDate);
}
