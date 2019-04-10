package com.jing.repository;

import com.jing.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    public List<Book> findByBookNameLike(String bookName);//用于模糊查询
}
