package com.synerzip.restwithspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synerzip.restwithspring.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
 
}