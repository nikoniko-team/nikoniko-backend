package br.com.senac.nikoniko.service;

import br.com.senac.nikoniko.entity.Mood;
import br.com.senac.nikoniko.exception.InexistentMoodException;

import java.util.List;

public interface MoodService {

    Mood find(Integer id) throws InexistentMoodException;

    List<Mood> findAll();
}
