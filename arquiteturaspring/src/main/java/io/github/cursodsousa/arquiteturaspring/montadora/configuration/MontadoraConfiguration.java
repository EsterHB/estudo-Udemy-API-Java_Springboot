package io.github.cursodsousa.arquiteturaspring.montadora.configuration;

import io.github.cursodsousa.arquiteturaspring.montadora.Motor;
import io.github.cursodsousa.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Definição dos beans pode ser feita dentro da @Configuration. Os beans são componenetes que serão utilizados em algum momento na aplicação.
// Em geral, um bean é um componente que pode ser complexo, como uma conexão com banco de dados,
// que é complexo e configuramos uma vez para utilizarmos várias vezes na aplicação. Outro exemplo é
// configurar um servidor de email, em que definimos as configurações dele em um bean, registrando-o
// na @Configuration

@Configuration
public class MontadoraConfiguration {

    @Bean
    // Bean é um método que retorna um objeto construído
    public Motor motor (){
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }
}
