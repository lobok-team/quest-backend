package nsu.questmakersteam.questbackend.web.dto.mapper;

import nsu.questmakersteam.questbackend.domain.User;
import nsu.questmakersteam.questbackend.web.dto.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toDto(User user);
}
