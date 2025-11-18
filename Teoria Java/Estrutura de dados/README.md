# Estrutura de dados 

Estruturas de dados são modelos de organização de dados que facilitam o acesso, manipulação e armazenamento de informações.

Em Java as estrtuturas de dados são implementadas por meio de coleções (Collection Framework) e também por estruturas manuais como arrays.

## Principais estruturas de dados em Java

### Arrays

* Estrtutura mais simples;
* Possui tamanho fixo;
* Acesso rápido por índice;

Ex.: ``` int[] numeros = new int[5]; ```

### List 

* Lista ordenada que permite elementos repetidos;
* Tamanho dinâmico;
* Implementações: ArrayList, LinkedList;

Ex.: ``` List<String> nomes = new ArrayList<>(); ```

#### ArrayList 
* Baseado em array dinâmico;
* Acesso rápido por índice; 
* **Mais eficiente para leitura** do que para inserção/remoção no meio da lista (quando remove ou adiciona, quase todos os elementos da lsita precisam ser movidos na memória e isso custa tempo);


#### LinkedList
* Baseado na lista duplamente encadeada; 
* **Melhor para inseções e remoções frequentes**, especialmente no início ou meio da lista;
* Um pouco mais lento para acesso pro índice;
___ 

### Set 

Set é uma coleção que **não permite elementos duplicados**. Senado assim ideal para quando deseja-se que cada item apareça apenas uma vez. 

Características: 

* Não aceita elementos repetidos;
* Não garante ordem (dependendo da implementação, LinkedHashSet mantém a ordem, por exemplo);
* Muito útil para:

  * **Filtrar duplicatas**;
  * **Verificar existência e trabalhar com conjuntos matemáticos**.

#### Principais implementações de set:

1. **HashSet**
* Mais ocmum e rápido;
* Não matém a ordem dos elementos;
* Baseado em tabela de dispersão (hash table).

```Java
Set<String> nomes = new HashSet<>();
nomes.add("Joana");
nomes.add("Mateus");
nomes.add("Joana");//IGNORADO!
``` 

2. **LinkedHashSet** 
* **Mantém a ordem de inserção**;
* Útil quando deseja-se **evitar duplicatas e manter a ordem**;

```Java 
Set<String> cidades = new LinkedHashSet<>();
cidades.add("São Paulo");
cidades.add("Rio");
cidades.add("São Paulo");//IGNORADO!
```

3. **TreeSet** 
* Mantém os elementos **ordenados** naturalmente (ou por comparador);
* Baseado em árvore binária de busca;

```Java 
Set<Integer> numeros = new TreeSet<>();
numeros.add(3);
numeros.add(1);
numeros.add(2);
//ORDEM -> 1, 2, 3
```

##### Quando usar set? 
* Quando deseja-se evitar duplicatas;
* Quando precisa verificar rapidamente se um item existe;
* Quando trabalha com **conjuntos matemáticos**(união, interseção, diferença).
___

### Map 

Map é uma estrutura que armazena **pares chave-valor**. Cada chave é única, e cada valor está associado a uma chave.

```Java 
Map<String, Integer> estoque = new HashMap<>();
estoque.put("Maçã", 10);
estoque.put("Banana", 5);
```

#### Principais implementações de Map

1. **HashMap**

* Mais comum e rápido; 
* **Não garante a ordem**;
* Ideal para buscas rápidas por chave.

```Java 
Map<String, String> capitais = new HashMap<>();
capitais.put("SP", "São Paulo");
capitais.put("RJ", "Rio de Janeiro");
```

2. **LinkedHashMap**

* **Mantém a ordem de inserção**;
* Útil quando **deseja-se preservar a sequência dos dados**.

```Java 
Map<String, Integer> notas = new LikedHashMap<>();
notas.put("Ana", 9);
notas.put("João", 7);
```

3. **TreeMap**

* Mantém as **chaves ordenadas naturalmente** ou por comparador; 
* Baseado em árvore binária de busca.

```Java 
Map<String, Integer> ranking = new TreeMap<>();
ranking.put("Carlos", 3);
ranking.put("Ana", 1);
ranking.put("Bruno", 2);
// ORDEM: Ana, Bruno, Carlos -> alfabética
```

##### Quando usar Map?

* Quando precisa-se associar dados (alunos-> nota, nome-> idade);
* Qaundo precisa **buscar rapidamente por uma chave**;
* Quando quer **organizar dados por categorias**. 

