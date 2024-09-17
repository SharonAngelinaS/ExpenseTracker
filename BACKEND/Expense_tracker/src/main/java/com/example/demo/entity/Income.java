package com.example.demo.entity;

import java.time.LocalDate;

import com.example.demo.dto.Incomedto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity@Data
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer amount;

    private LocalDate date;

    private String category;

    private String description;

    public Incomedto getIncomeDto(){
        Incomedto incomeDTO = new Incomedto();
        incomeDTO.setId(id);
        incomeDTO.setTitle(title);
        incomeDTO.setAmount(amount);
        incomeDTO.setCategory(category);
        incomeDTO.setDate(date);
        incomeDTO.setDescription(description);
        return incomeDTO;
        
    }

}
