package com.igor.zuber.utils;

public enum UsuariosRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    UsuariosRole(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
