package com.webapp.api.domain.users;

public interface UserRepository {
  UserDto getById(long id);

  UserDto save(NewUserDto newUserDto);
}
