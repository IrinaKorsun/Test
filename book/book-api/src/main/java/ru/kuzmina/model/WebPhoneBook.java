package ru.kuzmina.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

/**
 * Телефонная книга
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ApiModel
public class WebPhoneBook {

    @ApiModelProperty(
            value = "Identifier",
            name = "id",
            dataType = "UUID",
            example = "1c7145f9-fb96-4d35-a86a-62155e9be652")
    private UUID id;

    @Valid
    private List<WebPhoneContact> contacts;

    @ApiModelProperty(
            value = "Name of the book",
            name = "name",
            dataType = "String",
            example = "BookName")
    @NotBlank(message = "Book name can't be blank")
    @Size(max = 20)
    private String name;
}
