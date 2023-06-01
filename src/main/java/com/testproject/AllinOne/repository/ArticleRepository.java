package com.testproject.AllinOne.repository;

import com.testproject.AllinOne.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.UUID;

public interface ArticleRepository extends MongoRepository<Article, UUID> {

}
