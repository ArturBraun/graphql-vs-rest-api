package com.webapp.api.interfaces.graphql;

import com.webapp.api.domain.users.UserDto;
import com.webapp.api.domain.users.UserInput;
import com.webapp.api.domain.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class GraphqlController {
  private final UserService userService;

  @QueryMapping
  public UserDto userById(@Argument Long id) {
    return userService.getUser(id);
  }

  @MutationMapping
  public UserDto createUser(@Argument UserInput userInput){
    return userService.addUser(userInput);
  }
}
