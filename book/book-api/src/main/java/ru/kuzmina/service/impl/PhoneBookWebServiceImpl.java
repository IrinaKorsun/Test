package ru.kuzmina.service.impl;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzmina.entity.PhoneBook;
import ru.kuzmina.model.WebBookFilter;
import ru.kuzmina.model.WebPhoneBook;
import ru.kuzmina.service.PhoneBookService;
import ru.kuzmina.service.PhoneBookWebService;

import java.util.UUID;


@Service
public class PhoneBookWebServiceImpl implements PhoneBookWebService {

    @Autowired
    PhoneBookService phoneBookService;

    @Autowired
    private MapperFacade mapperFacade;

    @Override
    public WebPhoneBook getPhoneBook(WebBookFilter filter) {
        if (filter != null) {
            UUID uuid = filter.getId();
            if (uuid != null) {
                return mapperFacade.map(phoneBookService.getPhoneBookByUUID(uuid), WebPhoneBook.class);
            }
        }
        if (filter != null) {
            String name = filter.getName();
            if (name != null) {
                return mapperFacade.map(phoneBookService.getPhoneBookByName(name), WebPhoneBook.class);
            }
        }
        return null;
    }

    @Override
    public WebPhoneBook save(WebPhoneBook book) {
        PhoneBook phoneBook = phoneBookService.save(mapperFacade.map(book, PhoneBook.class));
        return mapperFacade.map(phoneBook, WebPhoneBook.class);
    }
}
