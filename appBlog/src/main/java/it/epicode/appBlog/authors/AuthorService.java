package it.epicode.appBlog.authors;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepo authorRepo;

    //metodo per visualizzare tutti i BlogPost
    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    //metodo per trovare un BlogPost
    public Author findById(Long id) {
        if(!authorRepo.existsById(id)) {
            throw new EntityNotFoundException("l'autore non è stato trovato");
        }
        return authorRepo.findById(id).get();
    }

    //metodo per creare un BlogPost
    public Author createAuthor(Author author) {
        return authorRepo.save(author);
    }

    //metodo per aggiornare un BlogPost
    public Author updateAuthor(Long id, Author authorModificato) {
        Author autrModificato = findById(id);
        BeanUtils.copyProperties(authorModificato,authorModificato);
        return authorRepo.save(authorModificato);
    }

    //metodo per eliminare un BlogPost
    public void deleteAuthor(Long id) {
        authorRepo.deleteById(id);
    }

}
