package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    boolean existsByDescricao(String descricao);
    /*
    * Como eu so quero saber se existe a descricao, eu uso o existsByDescription.
    * Se eu quisesse buscar os dados, aí seria necessário utilizar o findByDescricao:
    * TodoEntity findByDescricao(String descricao);
    *
    * */
}
