package ru.kuzmina.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.UUID;

/**
 * Объект фильтрации даннных
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ApiModel
public class WebBookFilter {

    @ApiModelProperty(
            value = "Identifier for filter",
            name = "id",
            dataType = "UUID",
            example = "1c7145f9-fb96-4d35-a86a-62155e9be652")
    private UUID id;


    @ApiModelProperty(
            value = "Name of the book for filter",
            name = "name",
            dataType = "String",
            example = "BookName")
    private String name;
}
