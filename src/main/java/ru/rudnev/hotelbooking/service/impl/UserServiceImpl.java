package ru.rudnev.hotelbooking.service.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rudnev.hotelbooking.config.MyUserDetails;
import ru.rudnev.hotelbooking.dto.UserRegistrationDto;
import ru.rudnev.hotelbooking.model.Role;
import ru.rudnev.hotelbooking.model.User;
import ru.rudnev.hotelbooking.repository.UserRepository;
import ru.rudnev.hotelbooking.service.UserService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, @Lazy BCryptPasswordEncoder passwordEncoder){
        super();
        this.userRepository=userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(UserRegistrationDto userRegistrationDto) {
        return userRepository.save(new User(userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(), passwordEncoder.encode(userRegistrationDto.getPassword()), List.of(new Role("ROLE_USER"))));
    }

    @Override
    public User saveAdmin(UserRegistrationDto userRegistrationDto) {
        return userRepository.save(new User(userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(), passwordEncoder.encode(userRegistrationDto.getPassword()), List.of(new Role("ROLE_USER"), new Role("ROLE_ADMIN"))));
    }

    @Override
    public Boolean IsUserUnique(UserRegistrationDto userRegistrationDto) {
        Optional<User> user = userRepository.findByEmail(userRegistrationDto.getEmail());
        if (user.isPresent())
            return true;
        return false;
    }

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> user = userRepository.findByEmail(username);
        if(user.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new MyUserDetails(user.get(), mapRolesToAuthorities(user.get().getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
