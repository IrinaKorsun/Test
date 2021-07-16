package ru.kuzmina.service;

import ru.kuzmina.entity.PhoneContact;

import java.util.List;
import java.util.UUID;

/**
 * Доменный сервис контактов
 */
public interface PhoneContactService {
    /**
     * Сохраненине коннтакта в рамках книнги
     * @param contact контакт
     * @param bookUUID UUID книнги для сохранения
     */
    PhoneContact save(PhoneContact contact, UUID bookUUID);

    /**
     * Сохранение контактов
     * @param contacts список контактов
     */
    List<PhoneContact> save(List<PhoneContact> contacts);

    /**
     * Сохраненине списка контактов
     * @param contacts контакты
     * @param bookUUID uuid продукта
     * @return сохраненные контакты
     */
    List<PhoneContact> save(List<PhoneContact> contacts, UUID bookUUID);
}
