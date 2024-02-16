package ru.rudnev.hotelbooking.service;

import ru.rudnev.hotelbooking.dto.UserRegistrationDto;
import ru.rudnev.hotelbooking.model.User;

public interface UserService {
    User saveUser(UserRegistrationDto userRegistrationDto);
}
