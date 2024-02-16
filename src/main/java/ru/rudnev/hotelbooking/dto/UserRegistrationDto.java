package ru.rudnev.hotelbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rudnev.hotelbooking.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {
    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
