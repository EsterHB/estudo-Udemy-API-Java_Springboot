# Herança 

* É um tipo de associação que permite que uma class herde dados e comportamentos de outra classe;

* Permite o reuso de atributos e métodos (dados e comportamentos);

* **Herança é uma associação entre classes** e não entre objetos, pois **objetos já nascem com as características herdadas**. Um objeto é a instância de uma classe, ou seja, é o resultado da instância de uma classe. Além disso, **a herança é um conceito que define a estrutura e comportamento de tipos (classes)**, já o **objeto** apenas **utiliza o que a classe já herdou**;

Por exemplo, na imagem a seguir a classe BusinessAccount (subclasse/classe derivada) herda os atributos e métodos da classe Account (superclasse/classe base). Ou seja, a BusinessAccount extende a classe Account. 

![Imagem ilustrando a herança](./heranca.png)


## Upcasting e Downcasting

* **Upcasting (superficial)**: 
  
  * Casting (converter) da subclasse para superclasse;

  * Uso comum: polimorfismo;

  * Serve para tratar objetos de forma genérica;

  * Utilizado quando quer guardar um objeto da subclasse numa variável da superclasse, permitindo usar o mesmo código para diferentes tipos de objetos;

* **Downcasting (específico)**:
  
  * Casting da superclasse para a subclasse;

  * Uso da palavra *instanceof*;
  Uso comum: métodos que recebem parâmetros genéricos (ex.: Equals);

  * Serve para **acessar comportamentos específicos da subclasse**;

  * Utilizado quando se tem certeza que aquele objeto é de uma subclasse e queremos acessar métodos que **só existem naquela subclasse**;

Por exemplo, imagine um controle remoto genérico (superclasse) e um controle remoto de uma TV específica (subclasse). 

Neste caso temos: 

**Upcasting** -> se vc usar o controle genérico na TV vc só vai poder usar os botões básicos (ligar/desligar);

**Downcasting** -> se vc pegar o controle da TV vc vai poder utilizar vários outros botões especiais (mudar canal, volume, etc.) além dos botões básicos.

No exemplo a seguir há a superclasse Account e as subclasses SavingsAccount e BusinessAccount.

![Exemplo de Down e Upcasting](./downUpCasting.png)

``` Java
Account acc = new Account (1001, "Alex", 0.0);

BusinessAccount bacc = new BusinessAccount (1002, "Maria", 0.0, 500.0);

//UPCASTING
Account acc1 = bacc;
Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
Account acc3 = new SavingAccount(1004, "Anna", 0.0, 0.01);


//DOWNCASTING
BusinessAccount acc4 = (BusinessAccount)acc2; 
//Neste caso devemos afirmar que trata-se de uma BusinessAccount, isso é se tivermos certeza que acc2 de fato é uma BusinessAccount.

//Porém, se não tivermos certeza, o erro será acusado quando a aplicação rodar, pois o compilador está acreditando que sabemos o que estamos fazendo nesse caso e não apontará o erro de imediato, somente quando o programa for executado.

//Qaundo não temos certeza de que instância aquele objeto é de fato, devemos fazer uma verificação com instanceof:

// BusinessAccount acc5 = (BusinessAccount)acc3 -> gera erro!
if(acc3 instanceof BusinessAccount){
  BusinessAccount acc5 = (BusinessAccount)acc3;
  acc5.loan(200.0);
  System.out.println("Loan!");
}

if(acc3 instanceof SavingAccount){
  SavingAccount acc5 = (SavingAccount)acc3;
  acc5.updateBalance();
  System.out.println("Update!");
}
```
___

## Sobreposição, palavra super, anotação @Override

