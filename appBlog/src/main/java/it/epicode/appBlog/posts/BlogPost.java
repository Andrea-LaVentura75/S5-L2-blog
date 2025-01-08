package it.epicode.appBlog.posts;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String categoria;

    private String titolo;

    private String cover;

    private String contenuto;

    private int tempoDiLettura;




}