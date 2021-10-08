package com.auth.bcrypt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InputUserRepository extends JpaRepository<InputUser, Long>
{
    InputUser findByUserName(String username);
}
