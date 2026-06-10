package com.locadora.repositories;

import com.locadora.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // VULNERABILIDADE: SQL Injection
    @Query(value = "SELECT * FROM usuarios WHERE email = :email AND senha = :senha", nativeQuery = true)
    Usuario loginSQLInjection(@Param("email") String email, @Param("senha") String senha);
    
    Usuario findByEmailAndSenha(String email, String senha);
}