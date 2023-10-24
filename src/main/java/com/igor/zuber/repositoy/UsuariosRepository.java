package com.igor.zuber.repositoy;

import com.igor.zuber.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuariosRepository extends JpaRepository<Usuarios, String> {
    UserDetails findByLogin(String login);
}
