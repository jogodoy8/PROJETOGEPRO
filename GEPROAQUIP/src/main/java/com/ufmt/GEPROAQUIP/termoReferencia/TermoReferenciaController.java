package com.ufmt.GEPROAQUIP.termoReferencia;

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
@RequestMapping(path = "/termoReferencia")
@RequiredArgsConstructor
public class TermoReferenciaController {
  
  private final TermoReferenciaRepository repository;

  @GetMapping(path = "/")
  public List<TermoReferencia> index(){
    return repository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<TermoReferenciaResponse> getById(@PathVariable(name = "id") int id) {
    Optional<TermoReferencia> found = repository.findById(id);
    if(found.isPresent()){
      TermoReferenciaResponse response = TermoReferenciaResponse.from(found.get());
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
  public ResponseEntity cadastrar(@RequestBody TermoReferenciaRequest request){
    TermoReferencia termoReferencia = new TermoReferencia();
    termoReferencia.setNumProcesso(request.getNumProcesso());
    termoReferencia.setTipoProcesso(request.getTipoProcesso());
    termoReferencia.setAberturaProcesso(request.getAberturaProcesso());
    termoReferencia.setNumTR(request.getNumTR());
    termoReferencia.setObjeto(request.getObjeto());
  
    try {
      repository.save(termoReferencia);
    } catch(IllegalArgumentException error){
      return ResponseEntity.badRequest().body("Dados Inválido!");
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity atualizar(@PathVariable int id,
                                @RequestBody TermoReferenciaRequest request){
    TermoReferencia termoReferencia = new TermoReferencia();
    termoReferencia.setId(id);
    termoReferencia.setNumProcesso(request.getNumProcesso());
    termoReferencia.setTipoProcesso(request.getTipoProcesso());
    termoReferencia.setAberturaProcesso(request.getAberturaProcesso());
    termoReferencia.setNumTR(request.getNumTR());
    termoReferencia.setObjeto(request.getObjeto());


    try {
      repository.save(termoReferencia);
    } catch(IllegalArgumentException error){
      error.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }
}
