package com.example.recursohub.repository;

import com.example.recursohub.models.Recurso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RecursoRepository {

    private final List<Recurso> recursos = new ArrayList<>();
    private Long contador = 1L;

    public List<Recurso> findAll() {
        return recursos;
    }

    public Optional<Recurso> findById(Long id) {
        return recursos.stream()
                .filter(recurso -> recurso.getId().equals(id))
                .findFirst();
    }

    public Recurso save(Recurso recurso) {
        if (recurso.getId() == null) {
            recurso.setId(contador++);
            recursos.add(recurso);
        } else {
            // Si el recurso ya existe, sus cambios se conservan en la lista.
            Optional<Recurso> recursoExistente = findById(recurso.getId());
            if (recursoExistente.isEmpty()) {
                recursos.add(recurso);
            }
        }
        return recurso;
    }

    public boolean deleteById(Long id) {
        return recursos.removeIf(recurso -> recurso.getId().equals(id));
    }
}
