package com.example.bookmybatis;

import com.example.bookmybatis.repository.BookRepository;
import com.example.bookmybatis.repository.DataJpaBookRepository;
import com.example.bookmybatis.repository.JpaBookRepository;
import com.example.bookmybatis.repository.MybatisBookRepository;
import com.example.bookmybatis.service.BookService;
import jakarta.persistence.EntityManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.example.bookmybatis.repository")
@EnableJpaRepositories("com.example.bookmybatis.repository")
public class SpringConfig {
//    private final MybatisBookRepository bookRepository; //MyBatis 용
//    private final DataJpaBookRepository bookRepository;//DataJPA 용
    private EntityManager em; //JPA 용

//    public SpringConfig(MybatisBookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    } //MyBatis용
//    public SpringConfig(DataJpaBookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    } //DataJPA 용
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    } //JPA용
    
    @Bean
    public BookService bookService() {
//        return new BookService(bookRepository); //MyBatis와 DataJPA 용
        return new BookService(bookRepository());
    }
    
    @Bean
    public BookRepository bookRepository() {
        return new JpaBookRepository(em);
    } //JPA 용
}
