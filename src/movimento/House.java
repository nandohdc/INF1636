package movimento;

public class House {
	
	House[][] MatrizCaminho = new House[15][15];
	
	private int line; // Coordenada linha da Casa
	private int column; // Coordenada coluna da Casa
	private int qtdPinos;//Qtd de Pinos presentes na Casa
	
	
	public House(){// Inicializa as variaveis para evitar atribuicoes com lixo.
		this.line = 0;
		this.column = 0;
	}

	public House(int x, int y){// Construtor Casa, atribui valores validos a casa - Caminho Possivel
		this.line = x;
		this.column = y;
	}

	public int getQtd(){ // Retorna o quantidade de Pinos presentes na casa.
		return qtdPinos;
	}

	public int getline(){// Retorna a linha em que a casa esta posicionada.
		return this.line;
	}

	public int getcolumn(){// Retorna a coluna em que a casa esta posicionada.
		return this.column;
	}

}
