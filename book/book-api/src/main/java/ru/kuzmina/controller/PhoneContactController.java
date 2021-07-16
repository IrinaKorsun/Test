package ru.kuzmina.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kuzmina.model.WebPhoneContact;
import ru.kuzmina.service.PhoneContactWebService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("contact")
public class PhoneContactController {

    @Autowired
    private PhoneContactWebService service;

    @PostMapping("/{bookId}/save")
    @ApiOperation(value = "Create contact in the book",
            notes = "This method creates a new phone contact")
    public WebPhoneContact createContact(@PathVariable(value = "bookId") UUID bookId,
                                         @RequestBody @Valid WebPhoneContact contact) {
        return service.save(contact, bookId);
    }

    @PostMapping("/{bookId}/list/save")
    @ApiOperation(value = "Create contacts in the book",
            notes = "This method creates a new phone contacts")
    public List<WebPhoneContact> createContacts(@PathVariable(value = "bookId") UUID bookId,
                                                @RequestBody @Valid List<WebPhoneContact> contacts) {
        return service.save(contacts, bookId);
    }
}
