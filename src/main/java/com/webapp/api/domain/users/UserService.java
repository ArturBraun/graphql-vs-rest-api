package com.webapp.api.domain.users;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
  private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
  private final UserRepository userRepository;

  public UserDto addUser(NewUserDto newUserDto) {
    LOG.info("Adding new user - {}", newUserDto);
    var user = userRepository.save(newUserDto);
    LOG.info("New user added - {}", newUserDto);
    return user;
  }

  public UserDto getUser(Long id) {
    LOG.info("Getting user for id={}", id);
    var user = userRepository.getById(id);
    LOG.info("Found user={}", user);
    return user;
  }
}
