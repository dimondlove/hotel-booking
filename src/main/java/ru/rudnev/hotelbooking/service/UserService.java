package ru.rudnev.hotelbooking.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.rudnev.hotelbooking.dto.UserRegistrationDto;
import ru.rudnev.hotelbooking.model.User;

public interface UserService extends UserDetailsService {
    User saveUser(UserRegistrationDto userRegistrationDto);

    User saveAdmin(UserRegistrationDto userRegistrationDto);
}
