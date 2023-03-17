package com.skk.Seating_arrangement_system.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String email);
    Optional<User> findById(Long id);


}
