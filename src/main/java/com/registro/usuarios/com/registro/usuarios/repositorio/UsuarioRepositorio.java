
package com.registro.usuarios.com.registro.usuarios.repositorio;

import com.registro.usuarios.com.registro.usuarios.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    public Usuario findByEmail(String email);
    
    
    
}
