package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Incomedto {

    private Long id;

    private String title;

    private Integer amount;

    private LocalDate date;

    private String category;

    private String description;

}
