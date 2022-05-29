package com.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Integer categoryId;
    @NotBlank
    @Size(min=4,message = "minimum size of category title must be 4")
    private String categoryTitle;
    @NotBlank
    @Size(min=10,message = "minimum size of category description must be 10")
    private String categoryDescription;

}

