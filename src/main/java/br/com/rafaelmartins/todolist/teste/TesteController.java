package br.com.rafaelmartins.todolist.teste;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MÉTODOS:
 * GET - Busca um dado
 * POST - Adiciona um dado
 * PUT - Atualiza um dado
 * DELETE - Remove um dado
 * PATCH - Atualiza parte de um dado
 */
@RestController
@RequestMapping("/teste-rota")
public class TesteController {

    @GetMapping("/teste-metodo")
    public String testeMensagem() {
        return "Funcionou";
    }
}
