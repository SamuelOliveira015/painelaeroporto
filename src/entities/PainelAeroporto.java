package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.enums.StatusVoo;

public class PainelAeroporto {
    
    private List<Voo> voo = new ArrayList<>();
    
    public PainelAeroporto() {
    }

    public void addVoo(Voo voo){
        voo.add(voo);
    }

    public void removeVoo(Voo voo){
        voo.remove(voo);
    }
}

