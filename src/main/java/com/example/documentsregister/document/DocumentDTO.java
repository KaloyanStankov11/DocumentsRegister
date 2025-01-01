package com.example.documentsregister.document;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public class DocumentDTO {
    private Long id;
    private String name;
    private DocumentType type;
    private String description;
    private LocalDate publishDate;

    public DocumentDTO(Long id, String name, DocumentType type, String description, LocalDate publishDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.publishDate = publishDate;
    }

    public Long getId() {
        return id;
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
