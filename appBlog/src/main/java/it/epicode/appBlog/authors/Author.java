package it.epicode.appBlog.authors;

import it.epicode.appBlog.posts.BlogPost;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private String nome;

    private String cognome;

    private String email;

    private LocalDate dataDiNascita;

    private String avatar;

}