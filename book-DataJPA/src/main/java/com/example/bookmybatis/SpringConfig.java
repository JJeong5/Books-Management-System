package com.example.bookmybatis;

import com.example.bookmybatis.repository.DataJpaBookRepository;
import com.example.bookmybatis.repository.MybatisBookRepository;
import com.example.bookmybatis.service.BookService;
import org.mybatis.spring.annotation.MapperScan;
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
    private final DataJpaBookRepository bookRepository;

//    public SpringConfig(MybatisBookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    } //MyBatis용
    public SpringConfig(DataJpaBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    } //DataJPA 용

    @Bean
    public BookService bookService() {
        return new BookService(bookRepository);
    }
}
