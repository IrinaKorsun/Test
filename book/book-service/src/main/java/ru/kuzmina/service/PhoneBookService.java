package ru.kuzmina.service;

import ru.kuzmina.entity.PhoneBook;

import java.util.Optional;
import java.util.UUID;

/**
 * Доменный сервис телевонного справчоника
 */
public interface PhoneBookService {

    /**
     * Сохраненине книги с коннтактами
     * @param book книга
     */
    PhoneBook save(PhoneBook book);

    /**
     * Получеине телефонной книнги по наимеонваиню
     * @param name имя
     * @return кннига
     */
    PhoneBook getPhoneBookByName(String name);

    /**
     * Полученние книнги по UUID
     * @param id идентификатор
     * @return книга
     */
    Optional<PhoneBook> getPhoneBookByUUID(UUID id);
}
