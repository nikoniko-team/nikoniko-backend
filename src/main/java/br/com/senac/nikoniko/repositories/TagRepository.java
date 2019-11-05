package br.com.senac.nikoniko.repositories;

import br.com.senac.nikoniko.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
