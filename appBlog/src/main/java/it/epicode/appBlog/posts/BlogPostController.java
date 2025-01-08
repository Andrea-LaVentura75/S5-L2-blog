package it.epicode.appBlog.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")

public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    // qui vanno definite le chiamate che si possono fare sull'endpoint

    //chiamata findAll all'endpoint http://localhost:8080/api/blogPosts
    @GetMapping
    public ResponseEntity<List<BlogPost>> listofAllBlogPosts(){
        return ResponseEntity.ok(blogPostService.findAll());
    }

    //chiamata per findById all endpoint http://localhost:8080/api/blogPosts/{id}
    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> findById( @PathVariable Long id){
        return  ResponseEntity.ok(blogPostService.findById(id));
    }

    //chiamata per creare un nuovo blogPost http://localhost:8080/api/blogPosts
    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost( @RequestBody BlogPost request){
        return new ResponseEntity<>(blogPostService.createBlogPost(request), HttpStatus.CREATED);
    }

    //metodo per aggiornare un BlogPost
    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost blogPostModificato) {
        return ResponseEntity.ok(blogPostService.updateBlogPost(id, blogPostModificato));
    }

    //metodo per eliminare un BlogPost
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.noContent().build();
    }

}
