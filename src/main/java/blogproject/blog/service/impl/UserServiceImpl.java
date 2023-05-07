package blogproject.blog.service.impl;

import blogproject.blog.config.mapper.ModelMapperService;
import blogproject.blog.dto.request.CreateUserRequest;
import blogproject.blog.dto.request.UpdateUserRequest;
import blogproject.blog.dto.response.UserDto;
import blogproject.blog.model.User;
import blogproject.blog.repository.UserRepository;
import blogproject.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();

        return users.stream().map(user -> this.modelMapperService.forResponse().map(user, UserDto.class)).toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = this.userRepository.findById(id).orElseThrow();

        return this.modelMapperService.forResponse().map(user, UserDto.class);
    }

    @Override
    public void createUser(CreateUserRequest createUserRequest) {
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);


        this.userRepository.save(user);
    }

    @Override
    public void updateUser(UpdateUserRequest updateUserRequest) {
        User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);

        this.userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }
}
