package com.ufmt.GEPROAQUIP.statusTr;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/statusTr")
@RequiredArgsConstructor
public class StatusTrController {

    private final StatusTrRepository repository;

    @GetMapping(path = "/")
    public List<StatusTr> index() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StatusTrResponse> getById(@PathVariable(name = "id") int id) {
        Optional<StatusTr> found = repository.findById(id);
        if (found.isPresent()) {
            StatusTrResponse response = StatusTrResponse.from(found.get());
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{pk}")
    public ResponseEntity<Void> remover(@PathVariable(name = "pk") int id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException erro) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping (path = "/cadastrar")
    public ResponseEntity cadastrar(@RequestBody StatusTrRequest request) {
        StatusTr statusTr = new StatusTr();
        statusTr.setData(request.getData());
        statusTr.setAndamento(request.getAndamento());

        try {
            repository.save(statusTr);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().body("Dados Inválido!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable int id,
            @RequestBody StatusTrRequest request) {
        StatusTr statusTr = new StatusTr();
        statusTr.setId(id);
        statusTr.setData(request.getData());
        statusTr.setAndamento(request.getAndamento());

        try {
            repository.save(statusTr);
        } catch (IllegalArgumentException error) {
            error.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}

