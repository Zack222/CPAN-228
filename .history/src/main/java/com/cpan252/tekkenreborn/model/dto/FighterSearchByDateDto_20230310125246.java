package com.cpan252.tekkenreborn.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class FighterSearchByDateDto {
    private String name;
    private String startDate;
    private String endDate;
}