package com.webapp.api.infrastructure.users;

import com.webapp.api.domain.users.UserDto;
import com.webapp.api.domain.users.UserInput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "User_Id")
  private Long id;

  @Column(name = "User_Name")
  private String name;

  @Column(name = "User_Surname")
  private String surname;

  public User(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public static User of(UserInput userDto) {
    return new User(userDto.getName(), userDto.getSurname());
  }

  public UserDto toUserDto() {
    return new UserDto(id, name, surname);
  }
}
