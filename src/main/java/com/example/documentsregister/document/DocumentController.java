package com.example.documentsregister.document;

import com.example.documentsregister.exceptions.DescriptionTooLongException;
import com.example.documentsregister.exceptions.InvalidIdException;
import com.example.documentsregister.exceptions.InvalidNameException;
import com.example.documentsregister.exceptions.InvalidTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/get-by-type/{documentType}")
    public ResponseEntity<Object> getAllDocumentsByType(@PathVariable String documentType){
        try{
            return ResponseEntity.ok(documentService.getAllDocumentsByType(documentType));
        } catch (InvalidTypeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

    @PatchMapping("/update-document")
    public ResponseEntity<Object> updateDocument(@RequestBody UpdateDocumentDescriptionRequest request){
        try{
            return ResponseEntity.ok(documentService.updateDocument(request));
        } catch (DescriptionTooLongException | InvalidIdException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

    @PostMapping("/add-document")
    public ResponseEntity<Object> addDocument(@RequestBody AddDocumentRequest request){
        try{
            return ResponseEntity.ok(documentService.addDocument(request));
        } catch (DescriptionTooLongException | InvalidNameException | InvalidTypeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete-document/{documentId}")
    public ResponseEntity<Object> deleteDocument(@PathVariable Long documentId){
        try{
            return ResponseEntity.ok(documentService.deleteDocument(documentId));
        } catch (InvalidIdException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }
}
