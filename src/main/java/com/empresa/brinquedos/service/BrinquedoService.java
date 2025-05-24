package com.empresa.brinquedos.service;

import com.empresa.brinquedos.model.Brinquedo;
import com.empresa.brinquedos.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrinquedoService {

    @Autowired
    private BrinquedoRepository repository;

    public List<Brinquedo> getAll() {
        return repository.findAll();
    }

    public Optional<Brinquedo> getById(Long id) {
        return repository.findById(id);
    }

    public Brinquedo create(Brinquedo brinquedo) {
        return repository.save(brinquedo);
    }

    public Brinquedo update(Long id, Brinquedo brinquedo) {
        brinquedo.setId(id);
        return repository.save(brinquedo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
