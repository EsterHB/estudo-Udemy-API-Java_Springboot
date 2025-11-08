package io.github.cursodsousa.arquiteturaspring;


import io.github.cursodsousa.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciado {


    @Autowired
    private TodoValidator validator;

}
