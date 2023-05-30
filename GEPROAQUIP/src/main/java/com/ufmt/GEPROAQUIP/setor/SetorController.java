package com.ufmt.GEPROAQUIP.setor;

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
@RequestMapping(path = "/setor")
@RequiredArgsConstructor
public class SetorController {
  
  private final SetorRepository repository;

  @GetMapping(path = "/")
  public List<Setor> index(){
    return repository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<SetorResponse> getById(@PathVariable(name = "id") int id) {
    Optional<Setor> found = repository.findById(id);
    if(found.isPresent()){
      SetorResponse response = SetorResponse.from(found.get());
      return ResponseEntity.ok().body(response);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping(path = "/{pk}")
  public ResponseEntity<Void> remover(@PathVariable(name = "pk") int id){
    try {
      repository.deleteById(id);
      return ResponseEntity.ok().build();
    } catch(EmptyResultDataAccessException erro){
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping (path = "/cadastrar")
  public ResponseEntity cadastrar(@RequestBody SetorRequest request){
    Setor setor = new Setor();
    setor.setNome(request.getNome());
    setor.setDescricao(request.getDescricao());

    try {
      repository.save(setor);
    } catch(IllegalArgumentException error){
      return ResponseEntity.badRequest().body("Dados Inválido!");
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity atualizar(@PathVariable int id,
                                @RequestBody SetorRequest request){
    Setor setor = new Setor();
    setor.setId(id);
    setor.setNome(request.getNome());
    setor.setDescricao(request.getDescricao());

    try {
      repository.save(setor);
    } catch(IllegalArgumentException error){
      error.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }
}

