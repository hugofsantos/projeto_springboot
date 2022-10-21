package com.hugosantos.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Categoria implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nome;

    @JsonManagedReference
    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos;

    public Categoria(){
        this.produtos = new ArrayList<Produto>();
    }

    public Categoria(Integer id, String nome){
        this.id = id;
        this.nome = nome;
        this.produtos = new ArrayList<Produto>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Produto> getProdutos() {
        ArrayList<Produto> copiaProdutos = new ArrayList<Produto>();
        copiaProdutos.addAll(this.produtos);

        return copiaProdutos;
    } 
    public void adicionarProduto(Produto produto){
        if(produto != null && !this.produtos.contains(produto)) this.produtos.add(produto);
    }

    public void adicionarProdutos(List<Produto> produtos){
        this.produtos.addAll(produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Categoria other = (Categoria) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
