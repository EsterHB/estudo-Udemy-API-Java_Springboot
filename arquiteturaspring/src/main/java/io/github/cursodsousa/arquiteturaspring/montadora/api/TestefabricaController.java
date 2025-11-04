package io.github.cursodsousa.arquiteturaspring.montadora.api;

import io.github.cursodsousa.arquiteturaspring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class TestefabricaController {

    @Autowired //"Spring vá até seu container e me traga uma instância de Motor que vc já tem e injete aqui"
    @Qualifier("motorEletrico") //@Qualifier é o nome do bean
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody  Chave chave) {
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }
}
