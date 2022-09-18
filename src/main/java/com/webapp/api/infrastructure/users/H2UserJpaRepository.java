package com.webapp.api.infrastructure.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface H2UserJpaRepository extends JpaRepository<User, Long> {}
