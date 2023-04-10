package com.registro.usuarios.com.registro.usuarios.dto;

public class UsuarioRegistroDTO {

    private Long id;
    private String nombre;
    private String apellido; //añado el atributo grupo
    private String grupo;
    private String email;
    private String password;
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    //añado el set y get de grupo
     public String getGrupo() {
        return grupo;
    }

    
    public void setGrupo(String grupo) {    
        this.grupo = grupo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioRegistroDTO(Long id, String nombre, String apellido, String grupo, String email, String password) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.grupo = grupo;
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDTO(String nombre, String apellido, String grupo, String email, String password) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.grupo = grupo;
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDTO(String email) {
        super();
        this.email = email;
    }

    public UsuarioRegistroDTO() {
    }
    //agrego el constructor con grupo

    
    
}
