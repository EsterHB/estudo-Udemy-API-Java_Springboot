# Exercício 1 

![Enunciado do exercício 1](./Exercicio_1.png)

## Saída Esperada

![Saída esperada do exercício 1](./saida_esperada_ex1.png)

### Observações
As instanciações da superclasse Employee e da subclasse OutSourcedEmployee fora feitos dentro do laço for e dentro dos if, por que? 

* Se o objeto (Employee employee = new Employee(); por exemplo) for declarado fora do laço, ele será reutilizado em cada iteração, o que pode causar problemas na hora de armazenar os objetos em uma lista. Por que armazenar os osbjetos em uma lista? Porque é necessário seguir o modelo de saída desejado do exercício, no caso pede-se que sejam exibidos os PAYMENTS em uma lista da forma como está na imagem em anexo, tnão para isso pensei em criar uma lista para exibi-la no final em um print;

* Mantém o escopo limpo, ou seja, declarar dentro do laço for garante que cada objeto só exista durante aquela iteração, evitando confusão e uso indevido fora do contexto;

* **Por fim, o motivo principal: para inserir os valores corretamente na lista e exibir o print como foi pedido.** 