package regras;

import grafica.Pino;

public class House {
	
	House[][] MatrizCaminho = new House[15][15];
	
	private int line; // Coordenada linha da Casa
	private int column; // Coordenada coluna da Casa
	private int qtdPinos;//Qtd de Pinos presentes na Casa
	private Pino p1;//Primeiro Pino que Ocupa a casa -- null == casa vazia
	private Pino p2;//Segundo Pino que Ocupada a casa -- null == casa vazia
	
	
	public House(){// Inicializa as variaveis para evitar atribuicoes com lixo.
		this.line = 0;
		this.column = 0;
	}

	public House(int x, int y){// Construtor Casa, atribui valores validos a casa - Caminho Possivel
		this.line = x;
		this.column = y;
	}

	public void setPino(Pino p){// Atribui um novo pino a casa, antes checando quando posicao eh valida.

		if(this.qtdPinos == 0){
			this.p1 = p;
		}
		else if(this.qtdPinos == 1){
			this.p2 = p;
		}
	}

	public Pino getPino1(){ // Retorna o pino: pode ser null ou valido, depdende de qtdPinos
		return p1;
	}

	public Pino getPino2(){ // Retorna o pino: pode ser null ou valido, depdende de qtdPinos
		return p2;
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
