package br.com.cad.digital.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cad.digital.models.UsuarioModel;

@RestController
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    List<UsuarioModel> usuarios = new ArrayList<>();

    @GetMapping("/api/usuarios")
    public List<UsuarioModel> index() {
        return usuarios;
    }

    @GetMapping("/api/usuarios/{id}")
    public ResponseEntity<UsuarioModel> show(@PathVariable Long id) {
        log.info("Buscando usuário com o id: " + id);
        var coiso = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();
        if (coiso.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(coiso.get());
    }

    @PostMapping("/api/usuarios")
    public ResponseEntity<UsuarioModel> create(@RequestBody UsuarioModel usuario) {
        log.info("cadastrando despesa" + usuario);
        usuario.setId(usuarios.size() + 1L);
        usuarios.add(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @DeleteMapping("/api/usuarios/{id}")
    public ResponseEntity<UsuarioModel> destroy(@PathVariable Long id) {
        log.info("Apagando usuário com o id: " + id);
        var coiso = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();
        if (coiso.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        usuarios.remove(coiso.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/api/usuarios/{id}")
    public ResponseEntity<UsuarioModel> update(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
        log.info("Atualizando usuário com o id: " + id);
        var coiso = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();
        if (coiso.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        usuarios.remove(coiso.get());
        usuario.setId(id);
        usuarios.add(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }
}
