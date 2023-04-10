
package com.registro.usuarios.com.registro.usuarios.servicio;

import com.registro.usuarios.com.registro.usuarios.dto.UsuarioRegistroDTO;
import com.registro.usuarios.com.registro.usuarios.entidades.Usuario;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UsuarioServicio extends UserDetailsService  {
    public Usuario guardar(UsuarioRegistroDTO registroDTO);
    
    public List<Usuario> listarUsuarios();
    
}
