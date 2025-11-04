# Anotações 

## Definição de Beans 
Bean é um objeto que é instanciado, montado e gerenciado pelo container IoC (Inversion of Control) do framework Spring.
Isso significa que o Spring é resposável por criar, configurar e fornecer instâncias desses objetos quando necessário.<br>
Assim, Beans são a espinha dorsal de qualquer aplicação Spring Boot.

Um Bean pode ser definido de várias formas, como:

@Component <br>
@Service <br>
@Repository <br>
@Controller <br>

Ou manualmente com @Bean dentro de uma classe anotada com @Configuration. <br>

Os Beans podem ser utilizados para: 

* Organizar o código em componentes reutilizáveis;
* Injetar dependências com @Autowired ou @Inject, evitando instâncias manuais;
* Facilitar testes e manutenção;
* Aplicar lógica d enegócio, como validações, cálculos, integrações com APIs externas, etc.

No exemplo deste projeto foram criados 3 beans com os nomes "motorAspirado", "motorEletrico" e "motorTurbo" na
classe MontadoraConfiguration, sendo o bean "motorAspirado" definido com @Primary como o bean padrão, em caso de
não especificação, o bean @Primary será o utilizado por padrão.

Assim, a classe em que os beans foram definidos ficou: 

```
@Configuration
public class MontadoraConfiguration {

    @Bean(name = "motorAspirado")
    // Bean é um método que retorna um objeto construído
    @Primary // define qe é o Bean primário, padrão
    public Motor motorAspirado (){
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico (){
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(3);
        motor.setModelo("TH-40");
        motor.setLitragem(1.4);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean(name = "motorTurbo")
    public Motor motorTurbo (){
        var motor = new Motor();
        motor.setCavalos(180);
        motor.setCilindros(4);
        motor.setModelo("XPTO-01");
        motor.setLitragem(1.5);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }
}
``` 

### Criação de Annotations
Podemos criar nossas próprias annotations, basta criar a classe do tipo Annotation e definir qual bean queremos utilizar via @Qualifier.

Criar nossas próprias annotations é indicado para quando há vários beans, assim podemos especificar qual bean utilizaremos.
Como no exemplo a seguir: 

```
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD })
@Qualifier("motorAspirado")
public @interface Aspirado {
}
```

Assim, utilizando a annotation criada na classe TestefabricaController fica: 

```
@RestController
@RequestMapping("/carros")
public class TestefabricaController {

    @Autowired //"Spring vá até seu container e me traga uma instância de Motor que vc já tem e injete aqui"
    @Aspirado //Annotation do @Aspirado definida no package de api
    //@Qualifier("motorEletrico") //@Qualifier é o nome do bean
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody  Chave chave) {
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }
}

```