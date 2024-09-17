package com.example.demo.services.stats;

import com.example.demo.dto.Graphdto;
import com.example.demo.dto.Statsdto;


public interface StatsService {

 Graphdto getChartData();
Statsdto getStats();
}
