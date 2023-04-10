package com.registro.usuarios.com.registro.usuarios.controlador;

import com.registro.usuarios.com.registro.usuarios.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroControlador {
    
    @Autowired
    private UsuarioServicio servicio;
    
    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/") //cuando entre a vacio voy a retornar al index 
    public String verPaginaDeInicio(Model modelo) {
        modelo.addAttribute( "usuarios", servicio.listarUsuarios());
        return "index";
    }
 
}
