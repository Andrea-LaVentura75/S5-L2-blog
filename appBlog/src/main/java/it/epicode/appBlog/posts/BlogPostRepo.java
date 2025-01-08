package it.epicode.appBlog.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepo extends JpaRepository<BlogPost,Long> {
}
