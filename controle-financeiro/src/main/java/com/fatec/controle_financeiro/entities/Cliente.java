package com.fatec.controle_financeiro.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 60)
    private String name;

    @OneToMany(mappedBy = "cliente")
    private List<ContasReceber> ContasReceber;

    public Cliente() { } // Empty Constructor

    public Cliente(Long id, String name) {
        this.id = id;
        this.name = name;
    } // Constructor

    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}