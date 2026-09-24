package com.example.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.blog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT DISTINCT p FROM Post p LEFT JOIN FETCH p.tags WHERE " +
           "LOWER(p.title) LIKE LOWER(CONCAT('%', :term, '%')) OR " +
           "LOWER(p.content) LIKE LOWER(CONCAT('%', :term, '%')) OR " +
           "LOWER(p.category) LIKE LOWER(CONCAT('%', :term, '%'))")
    List<Post> searchPosts(@Param("term") String term);

    @Query("SELECT DISTINCT p FROM Post p JOIN p.tags t WHERE LOWER(t) = LOWER(:tag)")
    List<Post> findByTag(@Param("tag") String tag);
}