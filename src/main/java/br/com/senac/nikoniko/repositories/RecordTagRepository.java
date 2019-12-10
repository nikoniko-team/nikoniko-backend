package br.com.senac.nikoniko.repositories;

import br.com.senac.nikoniko.dtos.TagReportDto;
import br.com.senac.nikoniko.entities.RecordTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecordTagRepository extends JpaRepository<RecordTag, Long> {

    @Query("SELECT new br.com.senac.nikoniko.dtos.TagReportDto(t.name, count(rt.id)) " +
        "FROM RecordTag rt " +
        "JOIN rt.tag t " +
        "JOIN rt.record r " +
        "JOIN r.teamUser tu " +
        "WHERE tu.teamId = :teamId " +
        "GROUP BY rt.tag.name")
    List<TagReportDto> findTagUsage(Long teamId);

}
