package nsu.questmakersteam.questbackend.service;

import nsu.questmakersteam.questbackend.domain.User;
import nsu.questmakersteam.questbackend.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("Empty username");
        }

        User user = userRepository.findByLoginIgnoreCase(username.trim());
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPasswordHash(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole().toString())));
    }
}