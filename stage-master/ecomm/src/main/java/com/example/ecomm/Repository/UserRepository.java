package com.example.ecomm.Repository;

import com.example.ecomm.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}