package br.com.rafaelmartins.todolist.user;


import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * MODIFICADORES:
 * PUBLIC - A classe pode ser acessada de qualquer lugar
 * PRIVATE - A classe só pode ser acessada de dentro da própria classe
 * PROTECTED - A classe só pode ser acessada de dentro da própria classe e de classes filhas
 *
 * TÍPOS:
 * String (texto) - "Texto"
 * Integer (número inteiro) - 1
 * Double (número decimal) - 1.5
 * Float (número decimal) - 1.5f
 * Char (caractere) - 'a'
 * Date (data) - new Date()
 * Boolean (verdadeiro ou falso) - true
 * List (lista) - [1, 2, 3]
 * Map (dicionário) - {"nome": "Rafael"}
 * Object (objeto) - {}
 * Array (array) - []
 * Null (nulo) - null
 * Void (vazio) - void
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel user) {
        var userExists = this.userRepository.findByUsername(user.getUsername());

        if (userExists != null) {
            System.out.println("Usuário já existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        var passwordHashed = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        var userCreated = this.userRepository.save(user);

        user.setPassword(passwordHashed);

        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
