package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import entities.enums.StatusVoo;
import exception.BusinessException;

public class Voo {

	private String numeroVoo;
	private String companhiaAerea;
	private LocalDateTime horarioEmbarque;
	private LocalDateTime horarioSaida;
	private String destino;
	private StatusVoo status;

	public static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public Voo(String numeroVoo, String companhiaAerea, LocalDateTime horarioEmbarque, LocalDateTime horarioSaida,
			String destino) {
		verificarDados(numeroVoo, "Companhia Aérea");
		verificarDados(companhiaAerea, "Companhia Aérea");
		verificarDados(destino, "Destino");
		verificarHorario(horarioEmbarque, horarioSaida);
		this.numeroVoo = numeroVoo;
		this.companhiaAerea = companhiaAerea;
		this.horarioEmbarque = horarioEmbarque;
		this.horarioSaida = horarioSaida;
		this.destino = destino;
		this.status = StatusVoo.PREVISTO;
	}

	public String getNumeroVoo() {
		return numeroVoo;
	}

	public String getCompanhiaAerea() {
		return companhiaAerea;
	}

	public void alterarCompanhiaAerea(String companhiaAerea) {
		verificarStatVoo();
		verificarDados(companhiaAerea, getCompanhiaAerea());
		this.companhiaAerea = companhiaAerea;
	}

	public LocalDateTime getHorarioEmbarque() {
		return horarioEmbarque;
	}

	public void alterarHorarios(LocalDateTime horarioEmbarque, LocalDateTime horarioSaida) {
		verificarStatVoo();
		verificarHorario(horarioEmbarque, horarioSaida);
		this.horarioEmbarque = horarioEmbarque;
		this.horarioSaida = horarioSaida;
	}

	public LocalDateTime getHorarioSaida() {
		return horarioSaida;
	}

	public String getDestino() {
		return destino;
	}

	public void alterarDestino(String destino) {
		verificarStatVoo();
		verificarDados(destino, getDestino());
		this.destino = destino;
	}

	public StatusVoo avancarStatus() {
		verificarStatVoo();
		StatusVoo[] lista = StatusVoo.values();
		this.status = lista[status.ordinal() + 1];
		System.out.println("Voo: "+ numeroVoo + " - Novo Status: " + status );
		return status;
	}

	private void verificarHorario(LocalDateTime horarioEmbarque, LocalDateTime horarioSaida) {
		if (horarioSaida.isBefore(horarioEmbarque) || horarioSaida.equals(horarioEmbarque)) {
			throw new BusinessException("Horário Inválido, o embarque deve ser antes da saída");
		}

		if (horarioSaida.isBefore(horarioEmbarque)) {
			throw new DateTimeParseException("Horário Inválido, formato inadequada",
					"dd/MM/yyyy HH:mm:ss", 0);
		}
		if (horarioEmbarque.equals(null) || horarioSaida.equals(null)) {
			throw new BusinessException("Horários iguais, insira um novo horário onde a saída é depois do Embarque");
		}
	}

	private void verificarStatVoo() {
		if (status == StatusVoo.DECOLOU) {
			throw new BusinessException("O Voo já decolou, alterações impossibilitadas");
		}
	}

	private void verificarDados(String entrada, String campo) {
		if (entrada == null || entrada.isBlank()) {
			throw new BusinessException("Erro ao inserir uma informação inválida em " + campo);
		}
		if(entrada.contains(" ")) {
			throw new BusinessException("Erro ao inserir espaços em branco");
		}
		if(entrada.equalsIgnoreCase(campo)){
			
		}
	}

	@Override
	public String toString() {
		return numeroVoo + ", " + companhiaAerea + ", " + FMT.format(horarioEmbarque) + ",  " + FMT.format(horarioSaida)
				+ ", " + destino + ", " + status;
	}

}
