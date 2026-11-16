package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

import entities.enums.StatusVoo;

public class PainelAeroporto extends Voo{
    
    private List<Voo> voo = new ArrayList<>();
    
    public PainelAeroporto(String numeroVoo, String companhiaAerea, LocalDate horaEmbarque, LocalDate horaSaida, String destino, StatusVoo status) {
    	super(numeroVoo, companhiaAerea, horarioEmbarque, horarioSaida, destino);
    }

    public void addVoo(Voo voo){
        voo.add(voo);
    }

    public void removeVoo(Voo voo){
        voo.remove(voo);
    }
}

