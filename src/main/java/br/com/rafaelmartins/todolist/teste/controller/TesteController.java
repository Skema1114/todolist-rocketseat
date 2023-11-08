package br.com.rafaelmartins.todolist.teste.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste-rota")
public class TesteController {

    @GetMapping("/teste-metodo")
    public String testeMensagem() {
        return "Funcionou";
    }
}
