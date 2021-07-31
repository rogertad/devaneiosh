package br.lippe.devaneios.devaneios.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cidade;

    protected Local(){}

    public Local(String nome, String cidade){
        this.setNome(nome);
        this.setCidade(cidade);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Long getId() {
        return id;
    }//ddawewe

    public void setId(Long id) {
        this.id = id;
        
    }
 
    @Override
    public String toString() {
        return new String().concat("eu sou --->>>> ")
            .concat(id.toString())
            .concat(" ||| ")
            .concat(nome)
            .concat(" ||| ")
            .concat(cidade);
    }


}
