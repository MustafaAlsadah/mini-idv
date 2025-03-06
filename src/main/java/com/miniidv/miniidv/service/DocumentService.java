package com.miniidv.miniidv.service;

import com.miniidv.miniidv.repository.DocumentRepository;
import com.miniidv.miniidv.model.Document;
import com.miniidv.miniidv.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository docsRepo;
    @Autowired
    private UserService userService;

    public List<Document> getDocs(){
        return  docsRepo.findAll();
    }

    public Document addDocument(Document doc) {
        int userID = doc.getUser().getId();
        User existingUser = userService.getUserById(userID);
        if(existingUser == null){
            throw new EntityNotFoundException("User not found");
        }
        doc.setUser(existingUser);

        return docsRepo.save(doc);
    }
}
