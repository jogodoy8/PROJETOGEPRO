package com.ufmt.GEPROAQUIP.itemNf;

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

import com.ufmt.GEPROAQUIP.itemNf.ItemNfRequest;
import com.ufmt.GEPROAQUIP.itemNf.ItemNfResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/itemNf")
@RequiredArgsConstructor
public class ItemNfController {
  
  private final ItemNfRepository repository;

  @GetMapping(path = "/")
  public List<ItemNf> index(){
    return repository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ItemNfResponse> getById(@PathVariable(name = "id") int id) {
    Optional<ItemNf> found = repository.findById(id);
    if(found.isPresent()){
      ItemNfResponse response = ItemNfResponse.from(found.get());
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
  public ResponseEntity cadastrar(@RequestBody ItemNfRequest request){
   ItemNf itemNf = new ItemNf();
    itemNf.setQuantidade(request.getQuantidade());
    itemNf.setTipo(request.getTipo());
    itemNf.setDescricao(request.getDescricao());
    
    try {
      repository.save(itemNf);
    } catch(IllegalArgumentException error){
      return ResponseEntity.badRequest().body("Dados Inválido!");
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity atualizar(@PathVariable int id,
                                @RequestBody ItemNfRequest request){
    ItemNf itemNf = new ItemNf();
    itemNf.setId(id);
    itemNf.setQuantidade(request.getQuantidade());
    itemNf.setTipo(request.getTipo());
    itemNf.setDescricao(request.getDescricao());
    
    try {
      repository.save(itemNf);
    } catch(IllegalArgumentException error){
      error.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }
}

