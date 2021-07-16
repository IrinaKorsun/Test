package ru.kuzmina.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "phonebook", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "uk_book_name")
})
public class PhoneBook {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 20)
    private String name;

    @OneToMany(mappedBy = "phoneBook", fetch = FetchType.EAGER)
    private List<PhoneContact> contacts;

}
