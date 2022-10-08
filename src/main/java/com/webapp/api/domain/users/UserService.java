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

  public UserDto addUser(UserInput userInput) {
    LOG.info("Adding new user - {}", userInput);
    var user = userRepository.save(userInput);
    LOG.info("New user added - {}", userInput);
    return user;
  }

  public UserDto getUser(Long id) {
    LOG.info("Getting user for id={}", id);
    var user = userRepository.getById(id);
    LOG.info("Found user={}", user);
    return user;
  }
}
