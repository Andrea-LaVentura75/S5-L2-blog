package it.epicode.appBlog.authors;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

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