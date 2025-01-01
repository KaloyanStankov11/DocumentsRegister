package com.example.documentsregister.document;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private DocumentType type;
    @Column(columnDefinition="TEXT", length = 512)
    private String description;
    private LocalDate publishDate;

    public Long getId() {
        return id;
    }

    public DocumentDTO toDocumentDTO(){
        return new DocumentDTO(this.id, this.name, this.type, this.description, this.publishDate);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
