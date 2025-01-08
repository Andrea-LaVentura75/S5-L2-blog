package it.epicode.appBlog.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class authorController {
    @Autowired
    private AuthorService authorSrv;

    //metodo per visualizzare tutti gli autori
    @GetMapping
    public ResponseEntity<List<Author>> listAllAuthors() {
        return ResponseEntity.ok(authorSrv.findAll());
    }

    //metodo per trovare un autore
    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return ResponseEntity.ok(authorSrv.findById(id));
    }

    //metodo per creare un autore
    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(authorSrv.createAuthor(author));
    }

    //metodo per aggiornare un autore
    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author authorModificato) {
        return ResponseEntity.ok(authorSrv.updateAuthor(id, authorModificato));
    }

    //metodo per eliminare un autore
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorSrv.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
