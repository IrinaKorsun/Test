package ru.kuzmina.service.impl;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzmina.entity.PhoneContact;
import ru.kuzmina.model.WebPhoneContact;
import ru.kuzmina.service.PhoneContactService;
import ru.kuzmina.service.PhoneContactWebService;

import java.util.List;
import java.util.UUID;

@Service
public class PhoneContactWebServiceImpl implements PhoneContactWebService {

    @Autowired
    private PhoneContactService service;

    @Autowired
    private MapperFacade mapperFacade;

    @Override
    public WebPhoneContact save(WebPhoneContact contact, UUID bookId) {
        PhoneContact phoneContact = service.save(mapperFacade.map(contact, PhoneContact.class), bookId);
        return mapperFacade.map(phoneContact, WebPhoneContact.class);
    }

    @Override
    public List<WebPhoneContact> save(List<WebPhoneContact> contacts, UUID bookId) {
        List<PhoneContact> phoneContacts = service.save(mapperFacade.mapAsList(contacts, PhoneContact.class), bookId);
        return mapperFacade.mapAsList(phoneContacts, WebPhoneContact.class);
    }
}
