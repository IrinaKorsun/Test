package ru.kuzmina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kuzmina.dao.PhoneBookRepository;
import ru.kuzmina.entity.PhoneBook;
import ru.kuzmina.entity.PhoneContact;
import ru.kuzmina.exception.DuplicateException;
import ru.kuzmina.service.PhoneBookService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    @Autowired
    PhoneBookRepository repository;

    @Autowired
    PhoneContactServiceImpl phoneContactService;

    @Override
    public Optional<PhoneBook> getPhoneBookByUUID(UUID id) {
        return repository.findById(id);
    }

    @Override
    public PhoneBook getPhoneBookByName(String name) {
        return repository.findPhoneBookByName(name);
    }

    @Override
    @Transactional
    public PhoneBook save(PhoneBook book) {
        String bookName = book.getName();
        if (isNew(book)) {
            if (repository.findPhoneBookByName(bookName) != null) {
                throw new DuplicateException("The book with name " + bookName + " already exists");
            }
        }
        PhoneBook phoneBook = repository.save(book);
        List<PhoneContact> bookContacts = book.getContacts();
        if (bookContacts != null) {
            bookContacts.forEach(c -> c.setPhoneBook(phoneBook));
            List<PhoneContact> phoneContacts = phoneContactService.save(bookContacts);
            phoneBook.setContacts(phoneContacts);
        }
        return phoneBook;
    }

    private boolean isNew(PhoneBook book) {
        return book.getId() == null;
    }
}
