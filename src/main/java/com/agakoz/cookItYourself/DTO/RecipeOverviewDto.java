package com.agakoz.cookItYourself.DTO;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class RecipeOverviewDto {
    long id;
    String title;

}
