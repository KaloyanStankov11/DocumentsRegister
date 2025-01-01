package com.example.documentsregister.document;

public class UpdateDocumentDescriptionRequest {
    private Long documentId;
    private String description;

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
