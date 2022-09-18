package com.webapp.api.domain.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
  private final UserRepository userRepository;

  public void addUser(NewUserDto newUserDto) {
    userRepository.save(newUserDto);
  }

  public UserDto getUser(Long id) {
    return userRepository.getById(id);
  }
}
