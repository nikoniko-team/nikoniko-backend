package br.com.senac.nikoniko.repositories;

import br.com.senac.nikoniko.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
