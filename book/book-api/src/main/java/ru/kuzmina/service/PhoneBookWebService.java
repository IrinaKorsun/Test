package ru.kuzmina.service;

import ru.kuzmina.model.WebBookFilter;
import ru.kuzmina.model.WebPhoneBook;

/**
 * Канальный сервис для работы с книгой
 */
public interface PhoneBookWebService {

    /**
     *
     * Получение книги по
     * @param filter фильтрация
     * @return кинга
     */
    WebPhoneBook getPhoneBook(WebBookFilter filter);

    /**
     * Сохранение книги
     * @param book книга
     * @return сохраненая кига
     */
    WebPhoneBook save(WebPhoneBook book);
}
