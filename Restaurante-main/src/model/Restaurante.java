/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

/**
 *
 * @author Beatriz
 */
public class Restaurante {

     private String nome;
     private String telefone;
     private String email;
     private String restaurante;
     private String qtddpessoas;
     private String data;
     
    
     public Restaurante(String nome, String telefone, String email, String restaurante, String qtddpessoas, String data) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.restaurante = restaurante;
        this.qtddpessoas = qtddpessoas;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public String getQtddpessoas() {
        return qtddpessoas;
    }

    public void setQtddpessoas(String qtddpessoas) {
        this.qtddpessoas = qtddpessoas;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
