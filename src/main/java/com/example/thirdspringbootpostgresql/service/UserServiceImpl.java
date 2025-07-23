package com.example.thirdspringbootpostgresql.service;

import com.example.thirdspringbootpostgresql.entity.User;
import com.example.thirdspringbootpostgresql.model.UserDTO;
import com.example.thirdspringbootpostgresql.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private final UserRepository userRepository;

  public UserServiceImpl(
      UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<UserDTO> getAllUsers() {
    return userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  @Override
  public Optional<UserDTO> getUserById(Long id) {
    return userRepository.findById(id).map(this::convertToDTO);
  }

  @Override
  public UserDTO saveUser(UserDTO userDTO) {
    User user = convertToEntity(userDTO);
    User savedUser = userRepository.save(user);
    return convertToDTO(savedUser);
  }

  @Override
  public UserDTO updateUser(Long id, UserDTO userDTO) {
    User user = userRepository.findById(id).orElseThrow();
    user.setName(userDTO.name());
    User updatedUser = userRepository.save(user);
    return convertToDTO(updatedUser);
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

  private UserDTO convertToDTO(User user) {
    return new UserDTO(user.getId(), user.getName());
  }

  private User convertToEntity(UserDTO userDTO) {
    User user = new User();
    user.setId(userDTO.id());
    user.setName(userDTO.name());
    return user;
  }
}
