package nsu.questmakersteam.questbackend.web.dto.response;

import nsu.questmakersteam.questbackend.domain.type.UserRole;

public class UserResponse {
    private Long id;
    private String login;
    private String email;
    private UserRole role;

    public UserResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
