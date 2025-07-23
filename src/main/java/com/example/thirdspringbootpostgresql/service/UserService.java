package com.example.thirdspringbootpostgresql.service;

import com.example.thirdspringbootpostgresql.entity.User;
import com.example.thirdspringbootpostgresql.model.UserDTO;
import java.util.List;
import java.util.Optional;

public interface UserService {

  List<UserDTO> getAllUsers();

  Optional<UserDTO> getUserById(Long id);

  UserDTO saveUser(UserDTO userDTO);

  UserDTO updateUser(Long id, UserDTO userDTO);

  void deleteUser(Long id);
}
