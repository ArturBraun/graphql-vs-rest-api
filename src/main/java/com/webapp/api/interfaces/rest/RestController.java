package com.webapp.api.interfaces.rest;

import com.webapp.api.domain.users.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Controller
public class RestController {
  private static final Logger LOG = LoggerFactory.getLogger(RestController.class);
  private final UserService userService;

  @GetMapping(value = "/users/{id}")
  public ResponseEntity getUser(@PathVariable long id) {
    try {
      var user = userService.getUser(id);
      return ResponseEntity.ok(user);
    } catch (EntityNotFoundException e) {
      LOG.info("User for id={} not found", id);
      return ResponseEntity.notFound().build();
    }
  }
}
