package com.example.bookmybatis.repository;

import com.example.bookmybatis.entity.BookEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DataJpaBookRepository extends JpaRepository<BookEntity, Long> {
    //기본 CRUD는 스프링이 자동으로 만들어 줌

    @Query("select b from book b where b.name LIKE concat('%', :inputName, '%')" +
    "and b.publisher LIKE concat('%', :inputPublisher, '%')")
    List<BookEntity> findCond(@Param("inputName") String name,
                              @Param("inputPublisher") String publisher);

}
