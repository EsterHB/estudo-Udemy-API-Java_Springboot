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



\_\_\_



**@PathVariable ->** faz parte da URL.



Identifica recursos específicos

E.: 



@GetMapping 

public User getUser(@PathVariable Long id) {

&nbsp;	// id virá da URL, ex: /users/44

}



\_\_\_

\_\_\_





# Arquitetura e Estrutura do Framework 









