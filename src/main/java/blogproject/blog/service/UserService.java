package blogproject.blog.service;

import blogproject.blog.dto.request.CreateUserRequest;
import blogproject.blog.dto.request.UpdateUserRequest;
import blogproject.blog.dto.response.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    void createUser(CreateUserRequest createUserRequest);

    void updateUser(UpdateUserRequest updateUserRequest);

    void deleteUserById(Long id);

}
