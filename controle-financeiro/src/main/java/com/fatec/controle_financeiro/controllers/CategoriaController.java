package com.fatec.controle_financeiro.controllers;
import com.fatec.controle_financeiro.entities.Categoria;
import com.fatec.controle_financeiro.domain.categoria.CategoriaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Categoria categoria) {
        try {
            Categoria categoriaCreated = categoriaService.create(categoria);
            return new ResponseEntity<>(categoriaCreated, HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}