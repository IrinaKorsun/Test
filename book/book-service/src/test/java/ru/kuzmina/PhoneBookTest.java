package ru.kuzmina;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kuzmina.config.ServiceConfig;
import ru.kuzmina.dao.PhoneBookRepository;
import ru.kuzmina.dao.PhoneContactRepository;
import ru.kuzmina.entity.PhoneBook;
import ru.kuzmina.service.PhoneBookService;
import ru.kuzmina.service.PhoneContactService;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan("ru.kuzmina")
@ContextConfiguration(classes = {ServiceConfig.class, PhoneBookRepository.class, PhoneContactRepository.class, PhoneBookService.class, PhoneContactService.class})
public class PhoneBookTest {

    @Autowired
    PhoneBookRepository phoneBookRepository;

    @Test
    public void dummyTest() {
        PhoneBook book = phoneBookRepository.save(PhoneBook.builder().name("name").build());
        Assert.assertEquals("name", book.getName());
    }
}
