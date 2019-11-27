package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.MoodDto;
import br.com.senac.nikoniko.entities.Mood;

import java.util.List;
import java.util.Optional;

public interface MoodService {

    /**
     * Persiste um mood na base de dados.
     *
     * @param mood
     * @return Mood
     */
    Mood save(Mood mood);

    /**
     * Busca e retorna um mood por um nome.
     *
     * @param name
     * @return Optional<Mood>
     */
    Optional<Mood> findByName(String name);

    /**
     * Busca e retorna um mood por um url.
     *
     * @param url
     * @return Optional<Mood>
     */
    Optional<Mood> findByUrl(String url);

    /**
     * Busca e retorna um mood por ID.
     *
     * @param id
     * @return Optional<Mood>
     */
    Optional<Mood> findById(Long id);

    /**B
     * Busca e retorna um lista de mood por ID.
     *
     * @return List<Mood>
     */
    List<Mood> findAll();

    /**
     * Busca e retorna todos os moods do mês atual para um time.
     *
     * @return List<MoodDto>
     */
    List<Mood> findAllByTeamAndCurrentMonth(Long teamId);
}
