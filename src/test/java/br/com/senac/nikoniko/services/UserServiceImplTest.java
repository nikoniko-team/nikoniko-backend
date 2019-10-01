package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.entities.User;
import br.com.senac.nikoniko.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        BDDMockito.given(this.userRepository.save(Mockito.any(User.class))).willReturn(new User());
        BDDMockito.given(this.userRepository.getOne(Mockito.anyLong())).willReturn(new User());
        BDDMockito.given(this.userRepository.findByEmail(Mockito.anyString())).willReturn(new User());
        BDDMockito.given(this.userRepository.findByName(Mockito.anyString())).willReturn(new User());
    }

    @Test
    public void testSaveUser() {
        User user = this.userService.save(new User());
        assertNotNull(user);
    }

    @Test
    public void testFindById() {
        Optional<User> user = this.userService.findById(1L);
        assertTrue(user.isPresent());
    }

    @Test
    public void testFindByName() {
        Optional<User> user = this.userService.findByName("teste");
        assertTrue(user.isPresent());
    }

    @Test
    public void testFindByEmail() {
        Optional<User> user = this.userService.findByEmail("email@email.com");
        assertTrue(user.isPresent());
    }


}
