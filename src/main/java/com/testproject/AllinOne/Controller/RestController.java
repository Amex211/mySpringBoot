package com.testproject.AllinOne.Controller;

import com.testproject.AllinOne.model.*;
import com.testproject.AllinOne.repository.ArticleRepository;
import com.testproject.AllinOne.repository.BookRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1")
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    ArticleRepository articleRepository;


    @GetMapping("/books")
    public List<Book> index(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book show(@PathVariable String id){
        int bookId = Integer.parseInt(id);
        Optional<Book> maybeBook = bookRepository.findById(bookId);
        if(maybeBook.isPresent()){
            return bookRepository.findById(bookId).get();
        }
        else {
            return null;
        }

    }
    @PostMapping("/books")
    public Book create(@Valid @NotNull @RequestBody Book book){
        String title = book.getTitle();
        String author = book.getAuthor();
        String content = book.getContent();
        return bookRepository.save(new Book(title, author, content));
    }
    @PutMapping("/books/{id}")
    public Book update(@PathVariable String id, @Valid @NotNull @RequestBody Book Book){
        int bookId = Integer.parseInt(id);
        Optional<com.testproject.AllinOne.model.Book> maybeBook = bookRepository.findById(bookId);
        maybeBook.get().setTitle(Book.getTitle());
        maybeBook.get().setAuthor(Book.getAuthor());
        maybeBook.get().setContent(Book.getContent());
        return bookRepository.save(maybeBook.get());
    }
    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable String id){
        int bookId = Integer.parseInt(id);
        bookRepository.deleteById(bookId);
        return true;
    }

    @GetMapping("/articles")
    public List<Article> indexArticles(){
        return articleRepository.findAll();
    }

    @GetMapping("/articles/{id}")
    public Article showArticle(@PathVariable String id){
        UUID articleUUID = UUID.fromString(id);
        Optional<Article> maybeArticle = articleRepository.findById(articleUUID);
        if(maybeArticle.isPresent()){
            return articleRepository.findById(articleUUID).get();
        }
        else {
            return null;
        }
    }
    @PostMapping("/articles")
    public Article createArticles(@Valid @NotNull @RequestBody Article article){
        return articleRepository.save(article);
    }
    @PutMapping("/articles/{id}")
    public Article update(@PathVariable String id, @Valid @NotNull @RequestBody Article article){
        Optional<Article> maybeArticle = articleRepository.findById(UUID.fromString(id));
        if(maybeArticle.isPresent())
        {
            maybeArticle.get().setVersionID(article.getVersionID());
            maybeArticle.get().setName(article.getName());
            maybeArticle.get().setItems(article.getItems());
            return articleRepository.save(maybeArticle.get());
        }
        return null;
    }
    @DeleteMapping("articles/{id}")
    public boolean deleteArticle(@PathVariable String id){
        UUID uId = UUID.fromString(id);
        articleRepository.deleteById(uId);
        return true;
    }
}

