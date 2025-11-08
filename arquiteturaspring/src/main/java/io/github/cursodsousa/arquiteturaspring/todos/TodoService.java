package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TodoService {

    private TodoValidator validator;

    private MailSender mailSender;

    private TodoRepository repository;

    public TodoService (TodoRepository todoRepository,
                        MailSender mailSender,
                        TodoValidator validator){
        this.repository = todoRepository;
        this.mailSender = mailSender;
        this.validator = validator;
    }





    public TodoEntity salvar(TodoEntity novoTodo){

        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo){
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "concluido" : "nao concluído";
        mailSender.enviar("Todo " + todo.getDescricao() + "foi atualizado para" + status);
    }

    public TodoEntity buscarPorId(Integer id){
        return repository.findById(id).orElse(null);
    }



}
