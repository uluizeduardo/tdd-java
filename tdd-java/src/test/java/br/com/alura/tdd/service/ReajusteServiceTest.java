package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {

	private ReajusteService reajusteService;
	private Funcionario funcionario;
	
	@BeforeEach
	public void iniciarAtributos(){
		reajusteService = new ReajusteService();
		funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
	}

	@Test
	public void reajusteDeTresPorCentoQuandoDesempenhoForADesejar() {
		
		reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeQuinzePorCentoQuandoDesempenhoForADesejar() {
		
		reajusteService.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeVintePorCentoQuandoDesempenhoForADesejar() {
		
		reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

}
