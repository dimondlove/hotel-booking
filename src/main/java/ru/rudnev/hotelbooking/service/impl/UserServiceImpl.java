package ru.rudnev.hotelbooking.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rudnev.hotelbooking.dto.UserRegistrationDto;
import ru.rudnev.hotelbooking.model.Role;
import ru.rudnev.hotelbooking.model.User;
import ru.rudnev.hotelbooking.repository.UserRepository;
import ru.rudnev.hotelbooking.service.UserService;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User saveUser(UserRegistrationDto userRegistrationDto) {
        return userRepository.save(new User(userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(), userRegistrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER"))));
    }
}
