package ru.kuzmina.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuzmina.entity.PhoneContact;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhoneContactRepository extends JpaRepository<PhoneContact, UUID> {

    /**
     * Проверка наличия контактов с именем из списка
     */
    boolean existsByNameIn(List<String> names);
}
