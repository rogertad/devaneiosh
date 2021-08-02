package br.lippe.devaneios.devaneios.db;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
class User {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @OneToMany (
        fetch = FetchType.LAZY, 
        mappedBy = "user",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Causo> causo;

    public List<Causo> getCauso() {
        return causo;
    }

    public void setCauso(List<Causo> causo) {
        this.causo = causo;
    }

    public User() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}