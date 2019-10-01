package br.com.senac.nikoniko.repositories;

import br.com.senac.nikoniko.entities.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {

    @Transactional(readOnly = true)
    Mood findByName(String name);

    @Transactional(readOnly = true)
    Mood findByUrl(String url);

}
