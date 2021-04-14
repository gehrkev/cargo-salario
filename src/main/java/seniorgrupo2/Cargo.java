

package seniorgrupo2;

// Imports
import java.io.BufferedReader; 
import java.io.FileInputStream;// Para leitura de arquivos de texto
import java.io.IOException;
import java.io.InputStreamReader;

import java.time.LocalDateTime; // Para usar o formato Data
import java.time.format.DateTimeFormatter;

import java.util.ArrayList; // import the ArrayList class

/**
 * Classe Cargo. 
 * Um cargo é uma posição de trabalho em um determinada empresa que usa o sistema. Essa classe implementa o CRUD de um cargo.
 * @author Equipe da Sprint 1: David Willian, Jonata Caetano, Lucas Grijó, Thiago Luiz, Vitor André.
 *
 */
public class Cargo {

	/* Variáveis
	 * A persistência dos dados foi feita através de ArrayLists estáticas (por enquanto até que o Banco de Dados seja implementado).
	 *Para exemplificar, digamos que queremos acessar o Cargo de id 2, os dados desse cargo estariam na índice “2” de cada ArrayList. idCargo.get(2), nomeCargo.get(2), e assim por diante...
	 */ 
	static ArrayList<Integer> idCargo = new ArrayList<Integer>(); 
	static ArrayList<String> nomeCargo = new ArrayList<String>(); 
	static ArrayList<Integer> idSetor = new ArrayList<Integer>();  
	static ArrayList<String> hierarquia = new ArrayList<String>(); // Exemplo: Supervisão/Gerência
	static ArrayList<Double> salario = new ArrayList<Double>();
	static ArrayList<LocalDateTime> dataCadastro = new ArrayList<LocalDateTime>();
	static ArrayList<LocalDateTime> dataUltimaRevisao = new ArrayList<LocalDateTime>();
	static ArrayList<String> cbo2002 = new ArrayList<String>(); // Vide http://www.mtecbo.gov.br/ CBO - Classificação Brasileira de Ocupações 
	static ArrayList<String> cbo94 = new ArrayList<String>();
	static ArrayList<Integer> horaMes = new ArrayList<Integer>();
	static ArrayList<String> grauDeInstrucao = new ArrayList<String>();// Exemplo: Superior Completo
	static ArrayList<String> experienciaMinima = new ArrayList<String>();// Exemplo: 2 anos.
	static ArrayList<String> atribuicoes = new ArrayList<String>(); // Exemplo: Programação em Java, Criação de Banco de Dados, etc...
	static ArrayList<String> bonificacao = new ArrayList<String>(); // Exemplo: ???
	static ArrayList<Integer> status = new ArrayList<Integer>(); // Status do Cargo Cadastrado - 1 Ativo 2 Bloqueado 3 Inativo.


	/**
	 * Visualizar Cargo
	 * Visualiza os detalhes básicos um cargo.
	 * 
	 * Recebe o ID de um cargo e retorna o ID e o nome correspondente do cargo. (Por enquanto retorna uma String com essas informações, 
	 * pois ainda não podemos utilizar Orientação a Objeto)
	 * 
	 * @param _id 		ID do cargo
	 * @return String 	contendo idCargo e nomeCargo
	 */
	public static String visualizarCargo(int _id) {
		return (" " + idCargo.get(_id) + "\t" + nomeCargo.get(_id));
	}
	
	/**
	 * Listar Cargos
	 * Lista todos os cargos do sistema. Para cada cargo no sistema, chama o método visualizarCargo().
	 */
	public static void listarCargos() {
		System.out.println(" Id\tNome do Cargo");
		for (int i = 0; i < idCargo.size(); i++) {
			visualizarCargo(i);
		}
	}

	/**
	 * Visualiza todos os detalhes de um cargo.
	 * 
	 * Recebe o ID de um cargo e retorna todos os detalhes correspondentes daquele Cargo. (Por enquanto retorna uma String com essas informações, 
	 * pois ainda não podemos utilizar Orientação a Objeto)
	 * 
	 * @param _id
	 */
	public static void visualizarDetalhesDoCargo(int _id) {
		System.out.println("\nNome do cargo: " + nomeCargo.get(_id));
		System.out.println("ID do setor: " + idSetor.get(_id));
		System.out.println("Nível de hierarquia: " + hierarquia.get(_id));
		System.out.println("Salário: R$" + salario.get(_id));
		System.out.println("Data criação do cargo: "
				+ dataCadastro.get(_id).format(DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm")));
		System.out.println("Data alteração do cargo: "
				+ dataUltimaRevisao.get(_id).format(DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm")));
		System.out.println("Código CBO2002: " + cbo2002.get(_id));
		System.out.println("Código CBO94: " + cbo94.get(_id));
		System.out.println("Carga horária (h/Mês): " + horaMes.get(_id));
		System.out.println("Grau de instrução necessário: " + grauDeInstrucao.get(_id));
		System.out.println("Experiência mínima (meses): " + experienciaMinima.get(_id));
		System.out.println("Atribuições do cargo: " + atribuicoes.get(_id));
		System.out.println("Bonificações do cargo: " + bonificacao.get(_id));
		System.out.println("Status do cargo: " + status.get(_id));
	}

	/**
	 * Cadastrar Cargo
	 * Realiza o cadastro de cargos
	 * 
	 * Este método recebe os dados de um cadastro de cargo e efetua a persistência dos dados nas correspondentes arrayLists contidas 
	 * na classe estática Cargo. 
	 * 
	 * @param _id					ID do cargo
	 * @param _nomeCargo			Nome do cargo
	 * @param _idSetor				ID do setor do cargo
	 * @param _hierarquia 			Nível de hierarquia do cargo
	 * @param _salario 				Salário/mês do cargo
	 * @param _cbo2002 				CBO2002 do cargo - Vide <a href="http://www.mtecbo.gov.br/">CBO - Classificação Brasileira de Ocupações</a> 
	 * @param _cbo94 				CBO2002 do cargo - Vide <a href="http://www.mtecbo.gov.br/">CBO - Classificação Brasileira de Ocupações</a>
	 * @param _horaMes 				Horas trabalhadas por mês do cargo
	 * @param _grauDeInstrucao 		Grau de instrução necessário para o cargo
	 * @param _experienciaMinima 	Número de meses de experiência mínima para o cargo
	 * @param _atribuicoes 			Atribuições (funções, deveres) do cargo
	 * @param _bonificacao 			Bonificações do cargo
	 */
	public static void cadastrarCargo(
			int _id, 
			String _nomeCargo, 
			int _idSetor, 
			String _hierarquia, 
			double _salario,
			String _cbo2002,
			String _cbo94,
			int _horaMes,
			String _grauDeInstrucao,
			String _experienciaMinima,
			String _atribuicoes,
			String _bonificacao) 
	{

		LocalDateTime data;

		// ID Cargo
		int newId = idCargo.size();
		idCargo.add(newId);

		// Nome Cargo
		nomeCargo.add(_nomeCargo);
		// ID Setor
		idSetor.add(_idSetor);
		// Hierarquia
		hierarquia.add(_hierarquia);
		// Salário
		salario.add(_salario);
		// Data de Cadastro e Ultima Revisão
		data = LocalDateTime.now();
		dataCadastro.add(data);
		dataUltimaRevisao.add(data);
		//CBO 2002 e 94
		cbo2002.add(_cbo2002);
		cbo94.add(_cbo94);
		// Horas por Mês
		horaMes.add(_horaMes);
		// Grau de Instrução
		grauDeInstrucao.add(_grauDeInstrucao);
		// Experiência Mínima
		experienciaMinima.add(_experienciaMinima);
		// Atribuições do Cargo
		atribuicoes.add(_atribuicoes);
		// Bonificação
		bonificacao.add(_bonificacao);
		// Status do Cargo
		status.add(1);
	}

	/**
	 * Alterar Cargo
	 * Realiza a alteração do cargo desejado.
	 * 
	 * Este método recebe o os dados que serão alterados de um cargo e posteriormente efetua a alteração salvando os dados selecionados 
	 * novamente no seu respectivo ArrayList.
	 * 
	 * @param _id					ID do cargo
	 * @param _nomeCargo			Nome do cargo
	 * @param _idSetor				ID do setor do cargo
	 * @param _hierarquia 			Nível de hierarquia do cargo
	 * @param _salario 				Salário/mês do cargo
	 * @param _cbo2002 				CBO2002 do cargo - Vide <a href="http://www.mtecbo.gov.br/">CBO - Classificação Brasileira de Ocupações</a> 
	 * @param _cbo94 				CBO2002 do cargo - Vide <a href="http://www.mtecbo.gov.br/">CBO - Classificação Brasileira de Ocupações</a>
	 * @param _horaMes 				Horas trabalhadas por mês do cargo
	 * @param _grauDeInstrucao 		Grau de instrução necessário para o cargo
	 * @param _experienciaMinima 	Número de meses de experiência mínima para o cargo
	 * @param _atribuicoes 			Atribuições (funções, deveres) do cargo
	 * @param _bonificacao 			Bonificações do cargo
	 * @param _status				Status do Cargo Cadastrado - 1 Ativo 2 Bloqueado 3 Inativo.
	 */
	public static void alterarCargo(int _id, 
			String _nomeCargo, 
			int _idSetor, 
			String _hierarquia, 
			double _salario,
			String _cbo2002,
			String _cbo94,
			int _horaMes,
			String _grauDeInstrucao,
			String _experienciaMinima,
			String _atribuicoes,
			String _bonificacao,
			int _status) {
		
		LocalDateTime data;
		nomeCargo.set(_id, _nomeCargo);
		idSetor.set(_id, _idSetor);
		hierarquia.set(_id, _hierarquia);
		salario.set(_id, _salario);
		data = LocalDateTime.now();
		dataUltimaRevisao.set(_id, data);
		cbo2002.set(_id, _cbo2002);
		cbo94.set(_id, _cbo94);
		horaMes.set(_id, _horaMes);
		grauDeInstrucao.set(_id, _grauDeInstrucao);
		experienciaMinima.set(_id, _experienciaMinima);
		atribuicoes.set(_id, _atribuicoes);
		bonificacao.set(_id, _bonificacao);
		status.set(_id, _status);
	}

	/**
	 * Deletar Cargo
	 * Realiza a exclusão de um cargo.
	 * 
	 * Este método realiza a função de excluir o cargo selecionado no ArrayList a partir de seu id.
	 * 
	 * @param _id            ID do cargo         
	 */
	public static void deletarCargo(int _id) {
		// Remove o Cargo
		idCargo.remove(_id);
		nomeCargo.remove(_id);
		idSetor.remove(_id);
		hierarquia.remove(_id);
		salario.remove(_id);
		dataCadastro.remove(_id);
		dataUltimaRevisao.remove(_id);
		cbo2002.remove(_id);
		cbo94.remove(_id);
		horaMes.remove(_id);
		grauDeInstrucao.remove(_id);
		experienciaMinima.remove(_id);
		atribuicoes.remove(_id);
		bonificacao.remove(_id);
		status.remove(_id);

		// Percorre os todos cargos "à direita" do removido (pensando em um vetor), atualizando os seus respectivos IDS com o índice correto. 
		for (int i = 0; i < idCargo.size(); i++) {
			if ((_id - 1) < i) {
				idCargo.set(i, idCargo.get(i) - 1);
			}
		}
	}

	/**
	 * Popular Dados
	 * Popula os ArraysLists (Cargos) a partir de um arquivo de texto (src/main/java/seniorgrupo2/ExemplosDeCargo.txt).
	 *
	 * @throws IOException Erro na leitura do arquivo.
	 */
	public static void popularDados() throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("src/main/java/seniorgrupo2/ExemplosDeCargo.txt"))); // Carrega arquivo no buffer.
		try {
			
			String line;
			ArrayList<String> words = new ArrayList<>();
			String[] wordsArray;

			while ((line = br.readLine()) != null) { // Processa uma linha.
				
				wordsArray = line.split("\t"); // Quebra linha em locais com Tab.
				for (String each : wordsArray) {
					if (!"".equals(each)) {
						words.add(each); // Adiciona cada palavra no array de palavras.
					}
				}

				// Leitura dos campos em cada linha.
				idCargo.add(Integer.parseInt(words.get(0)));
				nomeCargo.add(words.get(1));
				idSetor.add(Integer.parseInt(words.get(2)));
				hierarquia.add(words.get(3));
				salario.add(Double.parseDouble(words.get(4)));
				LocalDateTime dataAtual = LocalDateTime.now();
				dataCadastro.add(dataAtual);
				dataUltimaRevisao.add(dataAtual);
				cbo2002.add(words.get(5));
				cbo94.add(words.get(6));
				horaMes.add(Integer.parseInt(words.get(7)));
				grauDeInstrucao.add(words.get(8));
				experienciaMinima.add(words.get(9));
				atribuicoes.add(words.get(10));
				bonificacao.add(words.get(11));
				status.add(Integer.parseInt(words.get(12)));
				words = new ArrayList<>(); // Limpa palavra já lidas.
			}
		} finally {
			br.close(); // Fecha o buffer.
		}
	}

}
