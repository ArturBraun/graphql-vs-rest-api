package com.webapp.api.infrastructure.users;

import com.webapp.api.domain.users.NewUserDto;
import com.webapp.api.domain.users.UserDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@Getter
@Setter
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String name;
  private String surname;

  public User(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public static User of(NewUserDto userDto) {
    return new User(userDto.getName(), userDto.getSurname());
  }

  public UserDto toUserDto() {
    return new UserDto(id, name, surname);
  }
}
