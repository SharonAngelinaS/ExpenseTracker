package com.example.demo.services.stats;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;



import com.example.demo.dto.Statsdto;
import com.example.demo.entity.Expense;
import com.example.demo.entity.Income;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Graphdto;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.repository.IncomeRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    @Override
    public Graphdto getChartData(){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(27);
        Graphdto graphDTO = new Graphdto();
        graphDTO.setExpenseList(expenseRepository.findByDateBetween(startDate, endDate));
        graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate, endDate));

        return graphDTO;
    }
    @Override
    public Statsdto getStats()
    {
        Double totalIncome = incomeRepository.sumAllAmounts();
        Double totalExpense = expenseRepository.sumAllAmounts();
        Optional<Income> optionalIncome = incomeRepository.findFirstByOrderByDateDesc();
        Optional<Expense> optionalExpense = expenseRepository.findFirstByOrderByDateDesc();


        Statsdto statsdto = new Statsdto();
        statsdto.setExpense(totalExpense);
        statsdto.setIncome(totalIncome);

        optionalIncome.ifPresent(statsdto::setLatestIncome);
        optionalExpense.ifPresent(statsdto::setLatestExpense);



        //balance
        statsdto.setBalance(totalIncome-totalExpense);

        List<Income> incomeList = incomeRepository.findAll();
        List<Expense> expenseList = expenseRepository.findAll();
        
        OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();

        OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
        OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();

        statsdto.setMaxExpense(maxIncome.isPresent() ? maxExpense.getAsDouble() : null);
        statsdto.setMinExpense(minExpense.isPresent() ? minExpense.getAsDouble() : null);
        statsdto.setMaxIncome(maxIncome.isPresent() ? maxIncome.getAsDouble() : null);
        statsdto.setMinIncome(minIncome.isPresent() ? minIncome.getAsDouble() : null);
    
        return statsdto;
    }
}
