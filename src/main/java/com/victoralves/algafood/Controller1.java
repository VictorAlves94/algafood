package com.victoralves.algafood;

import com.victoralves.algafood.di.modelo.Cliente;
import com.victoralves.algafood.di.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Controller1 {
    private AtivacaoClienteService ativacaoClienteService;

    public Controller1(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Cliente joao = new Cliente("João", "joao@xyz.com", "3499998888");

        ativacaoClienteService.ativar(joao);
        return "olá";
    }
}
