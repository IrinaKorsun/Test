package ru.kuzmina.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzmina.model.WebBookFilter;
import ru.kuzmina.model.WebPhoneBook;
import ru.kuzmina.service.PhoneBookWebService;

import javax.validation.Valid;

@RestController
@RequestMapping("book")
public class PhoneBookController {

    @Autowired
    PhoneBookWebService service;

    @PostMapping("/get")
    @ApiOperation(value = "Get a book by filter",
            notes = "This method creates a new phone contact")
    public WebPhoneBook getPhoneBook(@RequestBody WebBookFilter filter) {
        return service.getPhoneBook(filter);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save a book with contacts",
            notes = "This method saves a new book")
    public WebPhoneBook savePhoneBook(@RequestBody @Valid WebPhoneBook book) {
        return service.save(book);
    }
}
