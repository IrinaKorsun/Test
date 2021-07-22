package ru.kuzmina.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import ru.kuzmina.constraint.ContactNumberConstraint;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * Контактные данные в книге
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ApiModel
public class WebPhoneContact {

    @ApiModelProperty(
            value = "Identifier",
            name = "id",
            dataType = "UUID",
            example = "1c7145f9-fb96-4d35-a86a-62155e9be652")
    private UUID id;

    @ApiModelProperty(
            value = "Contact name",
            name = "name",
            dataType = "String",
            example = "ContactName")
    @NotBlank(message = "Contact name can't be blank")
    @Size(max = 20)
    private String name;

    @ApiModelProperty(
            value = "Contact number",
            name = "number",
            dataType = "String",
            example = "82345678912")
    @NotBlank(message = "Contact name can't be blank")
    @ContactNumberConstraint
    private String phone;


    @ApiModelProperty(
            value = "Contact email",
            name = "email",
            dataType = "String",
            example = "gmail@gmail.com")
    @Email(message = "invalid format")
    @Size(max = 50)
    private String email;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(
            value = "Book uuid",
            name = "bookUUID",
            dataType = "UUID",
            example = "1c7145f9-fb96-4d35-a86a-62155e9be652")
    private UUID bookUUID;

}
