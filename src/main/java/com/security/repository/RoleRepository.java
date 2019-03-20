package com.security.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.security.dm.Role;
import com.security.dm.Users;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}


