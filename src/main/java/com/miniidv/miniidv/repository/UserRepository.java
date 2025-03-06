package com.miniidv.miniidv.repository;

import com.miniidv.miniidv.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
