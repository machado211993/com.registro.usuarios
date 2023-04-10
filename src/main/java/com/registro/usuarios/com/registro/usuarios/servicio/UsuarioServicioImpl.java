package com.registro.usuarios.com.registro.usuarios.servicio;

import com.registro.usuarios.com.registro.usuarios.dto.UsuarioRegistroDTO;
import com.registro.usuarios.com.registro.usuarios.entidades.Rol;
import com.registro.usuarios.com.registro.usuarios.entidades.Usuario;
import com.registro.usuarios.com.registro.usuarios.repositorio.UsuarioRepositorio;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
        @Autowired
        private BCryptPasswordEncoder passwordEncoder;//estamos inyectando*/
	
	private final UsuarioRepositorio usuarioRepositorio;


	
	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}
        
        
	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		//agrego registroDTO.getGRUPO
		Usuario usuario = new  Usuario(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getGrupo() , registroDTO.getEmail(), passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
                return usuarioRepositorio.save(usuario);
	}
        
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
            Usuario usuario = usuarioRepositorio.findByEmail(username);
            if(usuario==null){
                throw new UsernameNotFoundException("Usuario o password invalidos");
                
            }
            return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
        }
        
        private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}
	@Override
        public List<Usuario> listarUsuarios(){
            return usuarioRepositorio.findAll();
        }
}
