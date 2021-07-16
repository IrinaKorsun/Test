package ru.kuzmina.service;

import ru.kuzmina.model.WebPhoneContact;

import java.util.List;
import java.util.UUID;

/**
 * Канальный сервис для работы с контактами
 */
public interface PhoneContactWebService {

    /**
     * Сохранение контакта в рамках одной книги
     * @param contact контакт
     * @param bookId uuid книги
     * @return контакт сохраненный
     */
    WebPhoneContact save(WebPhoneContact contact, UUID bookId);

    /**
     * Сохранение списка контактов в рамках одной книги
     * @param contacts список контактов
     * @param bookId uuid книги
     * @return сохраненые контакты
     */
    List<WebPhoneContact> save(List<WebPhoneContact> contacts, UUID bookId);
}
