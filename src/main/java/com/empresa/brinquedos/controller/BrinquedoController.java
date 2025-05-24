package com.empresa.brinquedos.controller;

import com.empresa.brinquedos.model.Brinquedo;
import com.empresa.brinquedos.service.BrinquedoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService service;

    @GetMapping
    public List<Brinquedo> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Brinquedo> create(@Valid @RequestBody Brinquedo brinquedo) {
        return ResponseEntity.ok(service.create(brinquedo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brinquedo> update(@PathVariable Long id, @Valid @RequestBody Brinquedo brinquedo) {
        return ResponseEntity.ok(service.update(id, brinquedo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
