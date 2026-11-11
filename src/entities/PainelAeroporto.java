package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.enums.StatusVoo;

public class PainelAeroporto extends Voo{
    
    private List<Voo> voos = new ArrayList<>();

    public PainelAeroporto(){
    }

    public PainelAeroporto(String numeroVoo, String companhiaAerea, LocalDate horaEmbarque, LocalDate horaSaida, String destino, StatusVoo status) {
        super();
    }

    public void addVoo(Voo voo){
        voos.add(voo);
    }

    public void removeVoo(Voo voo){
        voos.remove(voo);
    }
}

