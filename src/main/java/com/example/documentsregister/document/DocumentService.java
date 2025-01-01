package com.example.documentsregister.document;

import com.example.documentsregister.exceptions.DescriptionTooLongException;
import com.example.documentsregister.exceptions.InvalidIdException;
import com.example.documentsregister.exceptions.InvalidNameException;
import com.example.documentsregister.exceptions.InvalidTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public List<DocumentDTO> getAllDocumentsByType(String type) throws InvalidTypeException {
        DocumentType documentType;
        try{
            documentType = DocumentType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException ex){
            throw new InvalidTypeException(type);
        }
        return documentRepository.findAllByType(documentType).stream().map(Document::toDocumentDTO).toList();
    }

    public DocumentDTO updateDocument(UpdateDocumentDescriptionRequest request) throws InvalidIdException, DescriptionTooLongException {
        if(!checkDescription(request.getDescription())) throw new DescriptionTooLongException();
        Document document = documentRepository.findById(request.getDocumentId()).orElse(null);
        if(document == null){
            throw new InvalidIdException("Document with ID: " + request.getDocumentId() + " not found!");
        }
        document.setDescription(request.getDescription());
        return documentRepository.save(document).toDocumentDTO();
    }

    public DocumentDTO addDocument(AddDocumentRequest request) throws InvalidNameException, DescriptionTooLongException, InvalidTypeException {
        if (!checkName(request.getName())) throw new InvalidNameException();
        if(!checkDescription(request.getDescription())) throw new DescriptionTooLongException();
        DocumentType documentType;
        try{
            documentType = DocumentType.valueOf(request.getType().toUpperCase());
        } catch (IllegalArgumentException ex){
            throw new InvalidTypeException(request.getType());
        }
        Document document = new Document();
        document.setName(request.getName());
        document.setDescription(request.getDescription());
        document.setType(documentType);
        document.setPublishDate(request.getPublishDate());
        return documentRepository.save(document).toDocumentDTO();
    }

    public List<DocumentDTO> deleteDocument(Long documentId) throws InvalidIdException {
        if(!documentRepository.existsById(documentId)) throw new InvalidIdException("Document with ID: " + documentId + " not found!");
        documentRepository.deleteById(documentId);
        return documentRepository.findAll().stream().map(Document::toDocumentDTO).toList();
    }

    private boolean checkDescription(String text){
        return text.length() > 2 && text.length() < 513;
    }

    private boolean checkName(String name){
        return name.length() > 2 && name.length() < 49;
    }
}
