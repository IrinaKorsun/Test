package ru.kuzmina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kuzmina.dao.PhoneContactRepository;
import ru.kuzmina.entity.PhoneBook;
import ru.kuzmina.entity.PhoneContact;
import ru.kuzmina.exception.DuplicateException;
import ru.kuzmina.exception.ResourceNotFoundException;
import ru.kuzmina.service.PhoneContactService;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class PhoneContactServiceImpl implements PhoneContactService {

    @Autowired
    private PhoneContactRepository phoneContactRepository;

    @Autowired
    private PhoneBookServiceImpl phoneBookServiceImpl;

    @Override
    public PhoneContact save(PhoneContact contact, UUID bookUUID) {
        if (phoneContactRepository.existsByNameIn(Collections.singletonList(contact.getName()))) {
            throw new DuplicateException("Contact with name " + contact.getName() + " already exists");
        }
        PhoneBook phoneBookByUUID = phoneBookServiceImpl.getPhoneBookByUUID(bookUUID)
                .orElseThrow(() -> new ResourceNotFoundException("BookId " + bookUUID + " not found"));
        contact.setPhoneBook(phoneBookByUUID);
        return phoneContactRepository.save(contact);
    }

    @Override
    @Transactional
    public List<PhoneContact> save(List<PhoneContact> contacts) {
        if (phoneContactRepository.existsByNameIn(contacts.stream().map(PhoneContact::getName).collect(Collectors.toList()))) {
            throw new DuplicateException("Check duplicating contact");
        }
        return phoneContactRepository.saveAll(contacts);
    }

    @Override
    @Transactional
    public List<PhoneContact> save(List<PhoneContact> contacts, UUID bookUUID) {
        if (phoneContactRepository.existsByNameIn(contacts.stream().map(PhoneContact::getName).collect(Collectors.toList()))) {
            throw new DuplicateException("Check duplicating contact");
        }
        Set<String> duplicateBySetAdd = findDuplicateBySetAdd(contacts.stream().map(PhoneContact::getName).collect(Collectors.toList()));
        if (duplicateBySetAdd != null && !duplicateBySetAdd.isEmpty()) {
            throw new DuplicateException("Found duplicate names: " + duplicateBySetAdd.toString());
        }
        PhoneBook phoneBookByUUID = phoneBookServiceImpl.getPhoneBookByUUID(bookUUID)
                .orElseThrow(() -> new ResourceNotFoundException("BookId " + bookUUID + " not found"));
        contacts.forEach(c -> c.setPhoneBook(phoneBookByUUID));
        return phoneContactRepository.saveAll(contacts);
    }

    private <T> Set<T> findDuplicateBySetAdd(List<T> list) {
        Set<T> items = new HashSet<>();
        return list.stream()
                .filter(n -> !items.add(n))
                .collect(Collectors.toSet());
    }
}
