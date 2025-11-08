# Anotações 



### @RequestParam x @PathVariable 



Ambos são usados para extrair valores da requisição HTTP, porém de lugares diferentes. 



**@RequestParam** -> vem da query string, ou seja, parâmetros após ? na URL.

Ex.: 



@GetMapping("/users")

public List<User> getUsers(@RequestParam String name){

&nbsp;	...

&nbsp;	// o name vem da URL, por ex: /users?name=João

}



Utlizado em filtros, paginação, ordenação etc. Só passa parâmetros para a URL e não faz parte do caminho.

___




**@PathVariable ->** faz parte da URL.



Identifica recursos específicos

E.: 



@GetMapping 

public User getUser(@PathVariable Long id) {

&nbsp;	// id virá da URL, ex: /users/44

}

___
___

# Arquitetura e Estrutura do Framework 


- Container Spring; 
- Componentes Spring;
- Application Context; 
- Scan de Componentes;
- Configurações (Configutions) e Beans; 
- Application.yml/properties e Profiles (ambientes).

## Spring Framework e Spring Boot
Para que o Spring Boot exista é necessário o Spring Framework, que é o core, o coração do Spring Boot é o que faz com que o Spring Boot funcione.
Spring Boot é o agregador, é como se fosse o bolo completo. <br>

Uma aplicação Spring Boot roda dentro do servidor Tomcat, que é o padrão, mas pode ser trocado se quiser.

## Container Spring 
Componente principal de uma aplicação Spring. É formado por Configuration e Components.<br>
Container é quem vai gerenciar e cuidar dos beans como classes anotadas com @Component, @Service, @Repository, @Controller e outras.

A configuration pode possuir vários beans e application.yml/properties.<br>

Components são componentes específicos, como por exemplo Services (lógica de negócio, camada lógica), Repositories (acesso a dados, como SQL e No SQL), Controllers (por exemplo Rest Controllers de API Rest, que recebe as requisições).<br><br>

## Application (@SpringBottApplication)
Essencial para o funcionamento da aplicação, sem ela a aplicação não roda.
Somente uma classe possui @SpringBottApplication. <br>









