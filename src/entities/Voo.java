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
		verificarDados(numeroVoo, this.numeroVoo);
		verificarDados(companhiaAerea, this.companhiaAerea);
		verificarDados(destino, this.destino);
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
		verificarDados(companhiaAerea, this.companhiaAerea);
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
		verificarDados(destino, this.destino);
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
			throw new DateTimeParseException("Horário Inválido, o embarque deve ser antes da saída",
					"dd/MM/yyyy HH:mm:ss", 0);
		}
		if (horarioEmbarque.equals(null) || horarioSaida.equals(null)) {
			throw new NullPointerException("Horário inexitente, insira um novo hor[ario");
		}
	}

	private void verificarStatVoo() {
		if (status == StatusVoo.DECOLOU) {
			throw new BusinessException("O Voo já decolou, alterações impossibilitadas");
		}
	}

	private void verificarDados(String entrada, String campo) {
		if (entrada == null || entrada.isBlank()) {
			throw new BusinessException("Erro ao inserir uma informação inválida em " + Voo.class.getDeclaredFields());
		}
	}

	@Override
	public String toString() {
		return numeroVoo + ", " + companhiaAerea + ", " + FMT.format(horarioEmbarque) + ",  " + FMT.format(horarioSaida)
				+ ", " + destino + ", " + status;
	}

}
