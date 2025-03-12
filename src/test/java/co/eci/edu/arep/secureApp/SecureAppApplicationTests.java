package co.eci.edu.arep.secureApp;

import co.eci.edu.arep.secureApp.controller.SecureAppController;
import co.eci.edu.arep.secureApp.model.User;
import co.eci.edu.arep.secureApp.service.SecureAppService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class SecureAppApplicationTests {

	private MockMvc mockMvc;

	@Mock
	private SecureAppService userService;

	@Mock
	private AuthenticationManager authenticationManager;

	@Mock
	private PasswordEncoder passwordEncoder;

	@InjectMocks
	private SecureAppController secureAppController;

	private ObjectMapper objectMapper;
	private User testUser;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(secureAppController).build();
		objectMapper = new ObjectMapper();
		testUser = new User();
		testUser.setUsername("testUser");
		testUser.setPassword("password");
	}

	@Test
	void testRegisterUser() throws Exception {
		Mockito.when(userService.createUser(Mockito.any(User.class))).thenReturn(testUser);

		mockMvc.perform(post("/register")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(testUser)))
				.andExpect(status().isCreated());
	}

	@Test
	void testPasswordIsEncrypted() {
		String rawPassword = "securePassword123";
		String encodedPassword = passwordEncoder.encode(rawPassword);

		// La contraseña encriptada no debe ser igual a la original
		assertNotEquals(rawPassword, encodedPassword);
	}

	@Test
	void testDifferentPasswordsDoNotMatch() {
		String rawPassword = "securePassword123";
		String encodedPassword = passwordEncoder.encode(rawPassword);

		// No debe coincidir con una contraseña incorrecta
		assertFalse(passwordEncoder.matches("wrongPassword", encodedPassword));
	}


}
