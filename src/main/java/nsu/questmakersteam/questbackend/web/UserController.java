package nsu.questmakersteam.questbackend.web;

import nsu.questmakersteam.questbackend.service.SecurityService;
import nsu.questmakersteam.questbackend.web.dto.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class UserController extends BaseController {
    private final SecurityService securityService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(SecurityService securityService,
                          UserMapper userMapper) {
        this.securityService = securityService;
        this.userMapper = userMapper;
    }

    @RequestMapping(path = "user", method = RequestMethod.GET)
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(userMapper.toDto(securityService.getUser()));
    }
}
