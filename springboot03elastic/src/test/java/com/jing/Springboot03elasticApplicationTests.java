package com.jing;

import com.jing.bean.Article;
import com.jing.bean.Book;
import com.jing.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03elasticApplicationTests {
    @Autowired
    JestClient jestClient;
    @Autowired
    BookRepository bookRepository;
    @Test
    public void contextLoads() {
    }
//jest式
    @Test
    public void test01() {
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("zhang");
        article.setContent("hello world");

        Index index = new Index.Builder(article).index("atguigu").type("news").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void search(){
        //查询方式
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();
        //执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println("----"+result.getJsonString()+"----");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//springdata
    @Test
    public void test02(){
        Book book = new Book();
        book.setId(2);
        book.setBookName("游记");
        book.setAuthor("wu");
        bookRepository.index(book);
    }
    @Test
    public void test03(){
        //模糊查询
        for (Book book:bookRepository.findByBookNameLike("游")
             ) {
            System.out.println(book+"------");
        }
    }
}
