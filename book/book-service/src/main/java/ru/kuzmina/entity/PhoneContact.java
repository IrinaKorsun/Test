package ru.kuzmina.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "contact", uniqueConstraints =
@UniqueConstraint(name = "uk_contact_name_bookuuid", columnNames = {"name", "bookuuid"}))
public class PhoneContact {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(length = 20)
    private String name;

    @Column(length = 11)
    private String phone;

    @Column(length = 50)
    private String email;

    @ManyToOne
    @JoinColumn(name = "bookuuid", foreignKey = @ForeignKey(name = "fk_contact_bookuuid"))
    private PhoneBook phoneBook;
}
