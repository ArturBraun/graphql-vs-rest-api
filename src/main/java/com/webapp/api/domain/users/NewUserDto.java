package com.webapp.api.domain.users;

import lombok.Data;

@Data
public class NewUserDto {
  private final String name;
  private final String surname;
}
