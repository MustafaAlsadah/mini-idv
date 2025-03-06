package com.miniidv.miniidv.controller;

import com.miniidv.miniidv.service.DocumentService;
import com.miniidv.miniidv.service.FaceVerificationService;
import com.miniidv.miniidv.model.Document;
import com.miniidv.miniidv.model.VerificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
