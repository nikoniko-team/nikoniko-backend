package br.com.senac.nikoniko.repository;

import br.com.senac.nikoniko.entity.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Integer> {

}
