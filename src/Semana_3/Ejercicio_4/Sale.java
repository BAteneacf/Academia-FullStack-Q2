package Semana_3.Ejercicio_4;

import java.time.LocalDate;

public record Sale(String product, String category, double amount,
                   String region, LocalDate date) {}
