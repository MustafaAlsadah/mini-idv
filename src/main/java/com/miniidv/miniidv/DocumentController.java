package com.miniidv.miniidv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import java.util.List;

@RestController
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("/docs")
    public List<Document> getDocs(){
        return documentService.getDocs();
    }

    @PostMapping("/docs")
    public Document addDocument(@RequestBody Document doc){
        return documentService.addDocument(doc);
    }

}
