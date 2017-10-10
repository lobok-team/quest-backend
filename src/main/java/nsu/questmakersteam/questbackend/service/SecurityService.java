package nsu.questmakersteam.questbackend.service;

import nsu.questmakersteam.questbackend.domain.repository.UserRepository;
import nsu.questmakersteam.questbackend.exception.NotAuthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    private final UserRepository userRepository;

    @Autowired
    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserDetails() {
        Authentication authentication = getAuthentication();
        if (!isAuthorized(authentication)) {
            throw new NotAuthorizedException("Not authorized");
        }

        return (User) authentication.getPrincipal();
    }

    public boolean isAuthorized() {
        Authentication authentication = getAuthentication();
        return isAuthorized(authentication);
    }

    public nsu.questmakersteam.questbackend.domain.User getUser() {
        User user = getUserDetails();
        return userRepository.findByLoginIgnoreCase(user.getUsername());
    }

    private boolean isAuthorized(Authentication authentication) {
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken);
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
