package com.webapp.api.infrastructure.users;

import com.webapp.api.domain.users.NewUserDto;
import com.webapp.api.domain.users.UserDto;
import com.webapp.api.domain.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class H2UserRepository implements UserRepository {
  private final H2UserJpaRepository h2UserJpaRepository;

  @Override
  public UserDto getById(long id) {
    return h2UserJpaRepository.getReferenceById(id).toUserDto();
  }

  @Override
  public UserDto save(NewUserDto newUserDto) {
    return h2UserJpaRepository.saveAndFlush(User.of(newUserDto)).toUserDto();
  }
}
