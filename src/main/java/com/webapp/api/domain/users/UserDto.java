package com.webapp.api.domain.users;

import lombok.Data;

@Data
public class UserDto {
  private final long id;
  private final String name;
  private final String surname;
}
