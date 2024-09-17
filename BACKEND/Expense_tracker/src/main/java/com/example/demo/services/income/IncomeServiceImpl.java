package com.example.demo.services.income;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Incomedto;
import com.example.demo.entity.Income;
import com.example.demo.repository.IncomeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService{
    private final IncomeRepository incomeRepository;

    public Income postIncome(Incomedto incomeDTO){
        return saveOrUpdateIncome(new Income(), incomeDTO);
    }

    private Income saveOrUpdateIncome(Income income, Incomedto incomeDTO){
        income.setTitle(incomeDTO.getTitle());
        income.setDate(incomeDTO.getDate());
        income.setAmount(incomeDTO.getAmount());
        income.setCategory(incomeDTO.getCategory());
        income.setDescription(incomeDTO.getDescription());
        return incomeRepository.save(income);
    }

    public List<Incomedto> getAllIncomes(){
        return incomeRepository.findAll().stream()
        .sorted(Comparator.comparing(Income::getDate).reversed())
        .map(Income::getIncomeDto)
        .collect(Collectors.toList());
       
    }

    //UPDATE
    public Income updateIncome(Long id, Incomedto incomeDTO){
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if(optionalIncome.isPresent()){
            return saveOrUpdateIncome(optionalIncome.get(), incomeDTO);
        }else{
            throw new EntityNotFoundException("Income is not present with id "+id);
        }
    }
    //GET INCOME BY API
    public Incomedto getIncomeById(Long id){
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if(optionalIncome.isPresent()){
            return optionalIncome.get().getIncomeDto();
            }else{
                throw new EntityNotFoundException("Income is not present with id "+id);
                }
    }

    //DELETE INCOME BY ID
   public void deleteIncomeById(Long id){
    Optional<Income> optionalIncome = incomeRepository.findById(id);
    if(optionalIncome.isPresent()){
        incomeRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Income is not present with id "+id);
            }
    }


}
