package entities;

import java.time.LocalDateTime;

import entities.enums.StatusVoo;

public class Voo {

    private String numeroVoo;
    private String companhiaAerea;
    private LocalDateTime horarioEmbarque;
    private LocalDateTime horarioSaida;
    private String destino;
    private StatusVoo status;

    public Voo(String numeroVoo, String companhiaAerea, LocalDateTime horarioEmbarque, LocalDateTime horarioSaida, String destino,
            StatusVoo status) {
        super();
        this.numeroVoo = numeroVoo;
        this.companhiaAerea = companhiaAerea;
        this.horarioEmbarque = horarioEmbarque;
        this.horarioSaida = horarioSaida;
        this.destino = destino;
        this.status = status.PREVISTO;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public String getCompanhiaAerea() {
        return companhiaAerea;
    }

    public void setCompanhiaAerea(String companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }

    public LocalDateTime getHorarioEmbarque() {
        return horarioEmbarque;
    }

    public void setHorarioEmbarque(LocalDateTime horarioEmbarque) {
        this.horarioEmbarque = horarioEmbarque;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalDateTime horaSaida) {
        this.horarioSaida = horaSaida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public StatusVoo getStatus() {
        return status;
    }

    public void setStatus(StatusVoo status) {
        this.status = status;
    }

}
