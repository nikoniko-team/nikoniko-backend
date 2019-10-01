package br.com.senac.nikoniko.repositories;

import br.com.senac.nikoniko.entities.Mood;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MoodRepositoryTest {

    @Autowired
    private MoodRepository moodRepository;


    private static final String NAME = "triste";
    private static final String URL = "https:www.example.com/icons/triste.jpg";

    @Before
    public void setUp() throws Exception {
        Mood mood = new Mood();
        mood.setName(NAME);
        mood.setUrl(URL);
        this.moodRepository.save(mood);
    }

    @After
    public final void tearDown() {
        this.moodRepository.deleteAll();
    }

    @Test
    public void findByName() {
        Mood mood = this.moodRepository.findByName(NAME);
        assertEquals(NAME, mood.getName());
    }

}
