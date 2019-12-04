package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.entities.Mood;
import br.com.senac.nikoniko.repositories.MoodRepository;
import br.com.senac.nikoniko.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoodServiceImpl implements MoodService {

    private static final Logger log = LoggerFactory.getLogger(MoodServiceImpl.class);

    private MoodRepository moodRepository;

    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public Mood save(Mood mood) {
        log.info("Persistindo mood: {}", mood);
        return this.moodRepository.save(mood);
    }

    @Override
    public Optional<Mood> findByName(String name) {
        log.info("Buscando mood pelo nome {}", name);
        return Optional.ofNullable(this.moodRepository.findByName(name));
    }

    @Override
    public Optional<Mood> findByUrl(String email) {
        log.info("Buscando mood pelo email {}", email);
        return Optional.ofNullable(this.moodRepository.findByUrl(email));
    }

    @Override
    public Optional<Mood> findById(Long id) {
        log.info("Buscando mood pelo ID {}", id);
        return Optional.ofNullable(this.moodRepository.getOne(id));
    }

    @Override
    public List<Mood> findAll() {
        log.info("Buscando todos os moods");
        return moodRepository.findAll();
    }

}
