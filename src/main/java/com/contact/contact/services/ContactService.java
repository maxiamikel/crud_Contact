package com.contact.contact.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.contact.entity.Contact;
import com.contact.contact.repository.ContactRepository;

@RestController
@RequestMapping("/api/contact")
public class ContactService {

    @Autowired
    private ContactRepository repo;

    @GetMapping
    public List<Contact> listarContact()
    {
        return repo.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody Contact contact)
    {
        repo.save(contact);
    }


    @PutMapping
    public void alterarContact(@RequestBody Contact contact)
    {
        if(contact.getId() > 0)
        {
            repo.save(contact);
        }
    }

    @DeleteMapping
    public void excluirContact(@RequestBody Contact contact)
    {
        if(contact.getId() > 0)
        {
            repo.delete(contact);
        }
    }
    
}
