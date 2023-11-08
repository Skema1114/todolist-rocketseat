package br.com.rafaelmartins.todolist.user.controller;

import br.com.rafaelmartins.todolist.user.model.UserModel;
import br.com.rafaelmartins.todolist.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository repository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel user) {
        var userExists = this.repository.findByUsername(user.getUsername());

        if (userExists != null) {
            System.out.println("Usuário já existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        var userCreated = this.repository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
