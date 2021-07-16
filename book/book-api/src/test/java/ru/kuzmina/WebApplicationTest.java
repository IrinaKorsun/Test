package ru.kuzmina;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.kuzmina.model.WebBookFilter;
import ru.kuzmina.model.WebPhoneBook;
import ru.kuzmina.model.WebPhoneContact;
import ru.kuzmina.service.PhoneBookWebService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class WebApplicationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PhoneBookWebService phoneBookService;

    @Test
    void storeTestData() throws Exception {
        List<WebPhoneContact> contacts = Collections.singletonList(
                WebPhoneContact.builder()
                        .phone("79584585845")
                        .email("google@gmail.com")
                        .name("contact1")
                        .build()
        );
        WebPhoneBook book = WebPhoneBook.builder().name("name1").contacts(contacts).build();

        mvc.perform(post("/book/save")
                .contentType("application/json")
                .content(asJsonString(book)))
                .andExpect(status().isOk());
    }

    @Test
    void saveBook() throws Exception {

        WebBookFilter webBookFilter = WebBookFilter.builder().name("name").build();
        WebPhoneBook book = WebPhoneBook.builder().name("name").build();
        mvc.perform(post("/book/save")
                .contentType("application/json")
                .content(asJsonString(book)))
                .andExpect(status().isOk());

        WebPhoneBook guestbook = phoneBookService.getPhoneBook(webBookFilter);

        List<WebPhoneContact> contacts = Arrays.asList(
                WebPhoneContact.builder()
                        .phone("79584585845")
                        .email("google@gmail.com")
                        .name("contact2")
                        .build(),
                WebPhoneContact.builder()
                        .phone("79584585846")
                        .email("google@gmail.com")
                        .name("contact3")
                        .build()
        );

        guestbook.getContacts().addAll(contacts);

        mvc.perform(post("/book/save")
                .contentType("application/json")
                .content(asJsonString(guestbook)))
                .andExpect(status().isOk());

        WebPhoneBook webPhoneBook = phoneBookService.getPhoneBook(webBookFilter);
        Assertions.assertEquals(2, webPhoneBook.getContacts().size());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
