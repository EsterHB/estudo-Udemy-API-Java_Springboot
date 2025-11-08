package io.github.cursodsousa.arquiteturaspring;

import io.github.cursodsousa.arquiteturaspring.todos.*;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;

public class ExemploInjecaoDependencia {
    public static void main(String[] args) {

        //Tudo isso seria necessário escrever como código para injetar dependência no Controller

       /* DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("user");
        dataSource.setPassword("password");

        Connection connection = dataSource.getConnection();

        EntityManager entityManager = null;

        TodoRepository repository = new SimpleJpaRepository<TodoEntity, Integer>();
        TodoValidator validator = new TodoValidator(repository);
        MailSender sender =  new MailSender();

        TodoService todoService = new TodoService(repository, sender, validator);

    */

    }

}
