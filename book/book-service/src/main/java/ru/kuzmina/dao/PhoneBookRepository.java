package ru.kuzmina.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuzmina.entity.PhoneBook;

import java.util.UUID;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBook, UUID> {

    /**
     * Поиск книги по имени
     * @param name имя
     * @return книга
     */
    PhoneBook findPhoneBookByName(String name);
}

