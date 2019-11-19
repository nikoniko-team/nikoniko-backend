package br.com.senac.nikoniko.repositories;

import br.com.senac.nikoniko.entities.User;
import br.com.senac.nikoniko.enums.RoleEnum;
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
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private static final String NAME = "fulano";
    private static final String EMAIL = "fulano@teste.com";
    private static final String PASSWORD = "123456";
    private static final RoleEnum ROLE = RoleEnum.ROLE_MANAGER;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setName(NAME);
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);
        user.setRole(ROLE);
        this.userRepository.save(user);
    }

    @After
    public final void tearDown() {
        this.userRepository.deleteAll();
    }

    @Test
    public void testFindByName() {
        User user = this.userRepository.findByName(NAME);
        assertEquals(NAME, user.getName());
    }

    @Test
    public void testFindByEmail() {
        var user = this.userRepository.findByEmail(EMAIL).orElse(new User());
        assertEquals(EMAIL, user.getEmail());
    }

}
