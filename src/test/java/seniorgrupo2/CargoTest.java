package seniorgrupo2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CargoTest {

	@BeforeAll
	public static void PopulateBeforeAll() {
		try {
			Cargo.popularDados();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testVisualizarCargo() {
		int id = 2;
		String resultado = Cargo.visualizarCargo(id);
		assertEquals((" " + Cargo.idCargo.get(id) + "\t" + Cargo.nomeCargo.get(id)), resultado);
	}

	@Test
	public void testCadastrarCargo() {
		int id = Cargo.idCargo.size();
		Cargo.cadastrarCargo(id, "Gerente", 4, "Supervisor", 500.40, "5842320-32", "21314", 55, "Superior Completo",
				"12 meses", "Desenvolvedor", "nenhuma");

		assertAll("cargos", () -> assertEquals(Integer.valueOf(id), Cargo.idCargo.get(id)),
				() -> assertEquals("Gerente", Cargo.nomeCargo.get(id)),
				() -> assertEquals(Integer.valueOf(4), Cargo.idSetor.get(id)),
				() -> assertEquals("Supervisor", Cargo.hierarquia.get(id)),
				() -> assertEquals(Double.valueOf(500.40), Cargo.salario.get(id)),
				() -> assertEquals("5842320-32", Cargo.cbo2002.get(id)),
				() -> assertEquals("21314", Cargo.cbo94.get(id)),
				() -> assertEquals(Integer.valueOf(55), Cargo.horaMes.get(id)),
				() -> assertEquals("Superior Completo", Cargo.grauDeInstrucao.get(id)),
				() -> assertEquals("12 meses", Cargo.experienciaMinima.get(id)),
				() -> assertEquals("Desenvolvedor", Cargo.atribuicoes.get(id)),
				() -> assertEquals("nenhuma", Cargo.bonificacao.get(id))

		);
	}

	@Test
	public void testAlterarCargos() {
		int id = 0;
		Cargo.alterarCargo(id, "Dev", 1, "Supervisor", 1000.00, "1111111-22", "222222", 40, "ensino medio", "12",
				"Desenvolver", "nenhuma", 1);

		assertAll("cargos", () -> assertEquals(Integer.valueOf(0), Cargo.idCargo.get(id)),
				() -> assertEquals("Dev", Cargo.nomeCargo.get(id)),
				() -> assertEquals(Integer.valueOf(1), Cargo.idSetor.get(id)),
				() -> assertEquals("Supervisor", Cargo.hierarquia.get(id)),
				() -> assertEquals(Double.valueOf(1000.00), Cargo.salario.get(id)),
				() -> assertEquals("1111111-22", Cargo.cbo2002.get(id)),
				() -> assertEquals("222222", Cargo.cbo94.get(id)),
				() -> assertEquals(Integer.valueOf(40), Cargo.horaMes.get(id)),
				() -> assertEquals("ensino medio", Cargo.grauDeInstrucao.get(id)),
				() -> assertEquals("12", Cargo.experienciaMinima.get(id)),
				() -> assertEquals("Desenvolver", Cargo.atribuicoes.get(id)),
				() -> assertEquals("nenhuma", Cargo.bonificacao.get(id)),
				() -> assertEquals(Integer.valueOf(1), Cargo.status.get(id))

		);
	}

	@Test
	public void testDeletarCargo() {
		int id = 0;
		String nomeDoCargoDeletado = Cargo.nomeCargo.get(id);
		Cargo.deletarCargo(id);
		assertNotEquals(nomeDoCargoDeletado, Cargo.nomeCargo.get(id));
	}

}
