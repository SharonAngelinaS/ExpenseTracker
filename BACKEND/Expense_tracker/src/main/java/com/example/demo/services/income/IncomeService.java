package com.example.demo.services.income;

import java.util.List;

import com.example.demo.dto.Incomedto;
import com.example.demo.entity.Income;

public interface IncomeService {

    Income postIncome(Incomedto incomeDTO);
    List<Incomedto> getAllIncomes();
    Income updateIncome(Long id, Incomedto incomeDTO);
    Incomedto getIncomeById(Long id);
    void deleteIncomeById(Long id);
}
