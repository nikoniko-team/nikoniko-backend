package br.com.senac.nikoniko.service;

import br.com.senac.nikoniko.entity.Mood;
import br.com.senac.nikoniko.exception.InexistentMoodException;
import br.com.senac.nikoniko.repository.MoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoodServiceImpl implements MoodService {

    private final MoodRepository moodRepository;

    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public Mood find(Integer id) {
        return moodRepository.findById(id)
                .orElseThrow(InexistentMoodException::new);
    }

    @Override
    public List<Mood> findAll() {
        return moodRepository.findAll();
    }
}
