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
Dessa forma, as @Qualifier serão definidas conforme o name dos Beans, definido durante sua criação dentro da classe
@Configuration. 
___
___
Perfeito, Ester! Seu resumo está ótimo como ponto de partida — você captou bem a estrutura básica de uma aplicação Spring Boot. Fiz uma revisão completa, corrigi a gramática, melhorei a clareza e complementei com explicações úteis. Aqui está a versão final formatada em **Markdown** para você colocar no seu GitHub:

---

## Estudo sobre Camadas em uma API Spring Boot

### Controller
- Responsável por receber as requisições HTTP e encaminhá-las para o serviço apropriado.
- Atua como ponte entre o cliente (frontend ou outro sistema) e a lógica de negócio.
- Injeta o `Service` para executar as operações necessárias.

### Service
- Representa a **lógica de negócio** da aplicação.
- É onde ocorre o processamento mais pesado da API.
- Pode acionar:
    - A camada de persistência (`Repository`)
    - Outras APIs externas
    - Componentes auxiliares (como utilitários, validadores, etc.)
- Normalmente é a camada com **mais injeções de dependência**.
- Não acessa diretamente o banco de dados — isso é feito indiretamente via `Repository`.
- Um `Service` pode existir sem depender de um `Repository`, especialmente quando lida com integrações externas ou lógica pura.

###  Repository
- Responsável por **acessar diretamente o banco de dados**.
- Utiliza o Spring Data JPA para facilitar operações como `save`, `findById`, `delete`, etc.
- É um **bean gerenciado pelo Spring**, assim como o `Service` e o `Controller`.
- Não depende de nenhuma outra camada — é a base da persistência.

###  Relação entre as camadas
```plaintext
[Controller] → depende do → [Service]
[Service] → depende do → [Repository] (e outros componentes)
[Repository] → não depende de ninguém
```

###  Observações
- A injeção de dependência é feita via `@Autowired`, construtor ou outras formas suportadas pelo Spring.
- Todas essas camadas são **beans**, ou seja, são gerenciadas pelo contêiner do Spring.
- O uso de boas práticas como separação de responsabilidades e injeção de dependência facilita testes, manutenção e escalabilidade da aplicação.

___
___

# Observações

* Em Java, com Spring, só é necessário injetar uma classe se ela representar uma dependência **funcional**, ou seja, se precisarmos utilizar seus
métodos (comportamentos). Assim, ao invés de utilizar classes tradicionais par ainjeção de depndência, é recomendado utilizar interfaces, pois o
uso de interfaces, nesse caso, promoverá desacoplamento (independência entre componentes, se um mudar não interfere nos demais), maiores testabilidade 
e flexibilidade. As interfaces geralmente possuem apenas métodos abstratos (metodo apenas declarado, sem corpo, pois ele será implementado por outra classe)
e constantes (variáveis que são automaticamente *public static final*) como atributos.


* O @Component é o pai de todas as outras annotations de stereotypes.


* Quando uma classe é anotada com @Repository, ela será otimizada para trabalhar com banco de dados.

## Injeção de dependências 

Há três formas de injetar dependências:

* **Com @Autowired**, **injeção via propriedade/injeção por campo**, injeta diretamente, sem precisar de construtor;
```
@Autowired 
private TodoValidator validator;

public void usandoValidatorDiretamente(){
    var todo = new TodoEntity();
    validator.validar(todo);
}
```

É uma forma simples de injeção, mas não a mais recomendada por boas práticas porque dificulta testes. O ideal é injeção via construtor.
Além disso, com apenas @Autowired não denota-se nem obrigatoriedade e nem opcionalidade, além de que a instância (no caso do exemplo, validator) não pode ser modificada.

<br>

* **Com método setter**, deve utilizar o @Autowired. É uma forma menos comum de se utilizar, porque ela nos diz que a dependência por outro 
objeto é opcional. Assim, podemos interpretar que, pelo exemplo a seguir, o objeto BeanGerenciado pode ou não depender do objeto TodoValidator.
Denotando, portanto, a **não obrigatoriedade**.

```
@Autowired
public void setValidator ( TodoValidator validator){
    this.validator = validator;
} 
```

<br> 

* **Via construtor**, a recomendada, pode ou não utilziar o @Autowired. O ideal é usar construtor pela obrigatoriedade, ou seja, para construir um
objeto do tipo BeanGerenciado precisamos do objeto do tipo (TodoValidator validator), expressando a obrigatoriedade de dependência específica.
Assim, o código abaixo nos diz que o BeanGerenciado **NECESSITA obrigatoriamente** do objeto do tipo TodoValidator.

```
@Component
public classe BeanGerenciado {
    
    @Autowired // opcional utilizar
    public BeanGerenciado(TodoValidator validator){
        this.validator = validator;
    }
    
}

```

