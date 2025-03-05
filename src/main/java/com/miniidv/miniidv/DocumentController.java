package com.miniidv.miniidv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @Autowired
    FaceVerificationService kyc;

    @GetMapping("/docs")
    public List<Document> getDocs(){
        return documentService.getDocs();
    }

    @PostMapping("/docs")
    public Document addDocument(@RequestBody Document doc){
        return documentService.addDocument(doc);
    }

    @PostMapping("/verify")
    public String verifyIdentity(@RequestBody VerificationRequest reqBody){
        return kyc.compareFaces(reqBody.getSelfieUrl(), reqBody.getIdCardUrl());
    }

}
