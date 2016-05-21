package regras;

import grafica.Pino;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class House {
	//ArrayList<Point> ListaCaminho = new ArrayList<Point>();
	House[] MatrizCaminhoCor = new House[59];
	
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


	private House[][] inicializaMatrizCaminho(){
		House[][] MatrizCaminho = new House[15][15];
		for(int coluna = 0; coluna < 15; coluna++){
			for(int linha = 0; linha < 15; linha++){
				MatrizCaminho[linha][coluna] = new House(40*linha, 40*coluna);
			}
		}

		return MatrizCaminho;

	}

	private House[] inicializaArrayCaminhoCor(Color color, House[][] MatrizCaminho){
		
		House[] MatrizCaminhoCor = new House[59];

		if(color == Color.green){
			for(int i = 0; i < 59; i++){
				if(i < 5){
					MatrizCaminhoCor[i] = MatrizCaminho[i+1][6];
				}
				else if(i >= 5 && i < 11){
					MatrizCaminhoCor[i] =  MatrizCaminho[6][10-i];
				}
				else if(i >= 11 && i < 13){
					MatrizCaminhoCor[i] = MatrizCaminho[i-4][0];
				}
				else if(i >= 13 && i < 18){
					MatrizCaminhoCor[i] = MatrizCaminho[8][i-12];
				}
				else if(i >= 18 && i < 24){
					MatrizCaminhoCor[i] = MatrizCaminho[i-9][6];
				}
				else if(i >= 24 && i < 26){
					MatrizCaminhoCor[i] = MatrizCaminho[14][i-17];
				}
				else if(i >= 26 && i < 31){
					MatrizCaminhoCor[i] = MatrizCaminho[39-i][8];
				}
				else if(i >= 31 && i < 37){
					MatrizCaminhoCor[i] = MatrizCaminho[8][i-22];
				}
				else if(i >= 37 && i < 39){
					MatrizCaminhoCor[i] = MatrizCaminho[44-i][14];
				}
				else if(i >= 39 && i < 44){
					MatrizCaminhoCor[i] = MatrizCaminho[6][52-i];
				}
				else if(i >= 44 && i < 50){
					MatrizCaminhoCor[i] = MatrizCaminho[49-i][8];
				}
				else if(i >= 50 && i < 52){
					MatrizCaminhoCor[i] = MatrizCaminho[0][57-i];
				}
				else if(i == 52){
					MatrizCaminhoCor[i] = MatrizCaminhoCor[0];
					
				}
				else if(i >= 53 && i < 59){
					MatrizCaminhoCor[i] = MatrizCaminho[i-52][7];
				}
			}
		}

		else if(color == Color.blue){

			for(int i = 0; i < 59; i++){
				if(i < 5){
					MatrizCaminhoCor[i+26] = MatrizCaminho[i+1][6];
				}
				else if(i >= 5 && i < 11){
					MatrizCaminhoCor[i+26] = MatrizCaminho[6][10-i];
				}
				else if(i >= 11 && i < 13){
					MatrizCaminhoCor[i+26] = MatrizCaminho[i-4][0];
				}
				else if(i >= 13 && i < 18){
					MatrizCaminhoCor[i+26] = MatrizCaminho[8][i-12];
				}
				else if(i >= 18 && i < 24){
					MatrizCaminhoCor[i+26] = MatrizCaminho[i-9][6];
				}
				else if(i >= 24 && i < 26){
					MatrizCaminhoCor[i+26] = MatrizCaminho[14][i-17];
				}
				else if(i >= 26 && i < 31){
					MatrizCaminhoCor[i-26] = MatrizCaminho[39-i][8];
				}
				else if(i >= 31 && i < 37){
					MatrizCaminhoCor[i-26] = MatrizCaminho[8][i-22];
				}
				else if(i >= 37 && i < 39){
					MatrizCaminhoCor[i-26] = MatrizCaminho[44-i][14];
				}
				else if(i >= 39 && i < 44){
					MatrizCaminhoCor[i-26] =  MatrizCaminho[6][52-i];
				}
				else if(i >= 44 && i < 50){
					MatrizCaminhoCor[i-26] = MatrizCaminho[49-i][8];
				}
				else if(i >= 50 && i < 52){
					MatrizCaminhoCor[i-26] = MatrizCaminho[0][57-i];
				}
				else if(i == 52){
					MatrizCaminhoCor[i] = cazul[0];
				}
				else if(i >= 53 && i < 59){
					MatrizCaminhoCor[i] = MatrizCaminho[66-i][7];
				}
			}
		}



		else if(color == Color.red){
			for(int i = 0; i < 59; i++){
				if(i < 5){
					MatrizCaminhoCor[i+39] = MatrizCaminho[i+1][6];
				}
				else if(i >= 5 && i < 11){
					MatrizCaminhoCor[i+39] = MatrizCaminho[6][10-i];
				}
				else if(i >= 11 && i < 13){
					MatrizCaminhoCor[i+39] = MatrizCaminho[i-4][0];
				}
				else if(i >= 13 && i < 18){
					MatrizCaminhoCor[i-13] = MatrizCaminho[8][i-12];
				}
				else if(i >= 18 && i < 24){
					MatrizCaminhoCor[i-13] = MatrizCaminho[i-9][6];
				}
				else if(i >= 24 && i < 26){
					MatrizCaminhoCor[i-13] = MatrizCaminho[14][i-17];
				}
				else if(i >= 26 && i < 31){
					MatrizCaminhoCor[i-13] = MatrizCaminho[39-i][8];
				}
				else if(i >= 31 && i < 37){
					MatrizCaminhoCor[i-13] = MatrizCaminho[8][i-22];
				}
				else if(i >= 37 && i < 39){
					MatrizCaminhoCor[i-13] = MatrizCaminho[44-i][14];
				}
				else if(i >= 39 && i < 44){
					MatrizCaminhoCor[i-13] = MatrizCaminho[6][52-i];
				}
				else if(i >= 44 && i < 50){
					MatrizCaminhoCor[i-13] = MatrizCaminho[49-i][8];
				}
				else if(i >= 50 && i < 52){
					MatrizCaminhoCor[i-13] = MatrizCaminho[0][57-i];
				}
				else if(i == 52){
					MatrizCaminhoCor[i] = MatrizCaminhoCor[0];
				}
				else if(i >= 53 && i < 59){
					MatrizCaminhoCor[i] = MatrizCaminho[7][i-52];
				}
			}

		}

		else if(color == Color.yellow){
			
			for(int i = 0; i < 59; i++){
				if(i < 5){
					MatrizCaminhoCor[i+13] = MatrizCaminho[i+1][6];
				}
				else if(i >= 5 && i < 11){
					MatrizCaminhoCor[i+13] = MatrizCaminho[6][10-i];
				}
				else if(i >= 11 && i < 13){
					MatrizCaminhoCor[i+13] = MatrizCaminho[i-4][0];
				}
				else if(i >= 13 && i < 18){
					MatrizCaminhoCor[i+13] = MatrizCaminho[8][i-12];
				}
				else if(i >= 18 && i < 24){
					MatrizCaminhoCor[i+13] = MatrizCaminho[i-9][6];
				}
				else if(i >= 24 && i < 26){
					MatrizCaminhoCor[i+13] = MatrizCaminho[14][i-17];
				}
				else if(i >= 26 && i < 31){
					MatrizCaminhoCor[i+13] = MatrizCaminho[39-i][8];
				}
				else if(i >= 31 && i < 37){
					MatrizCaminhoCor[i+13] = MatrizCaminho[8][i-22];
				}
				else if(i >= 37 && i < 39){
					MatrizCaminhoCor[i+13] = MatrizCaminho[44-i][14];
				}
				else if(i >= 39 && i < 44){
					MatrizCaminhoCor[i-39] = MatrizCaminho[6][52-i];
				}
				else if(i >= 44 && i < 50){
					MatrizCaminhoCor[i-39] = MatrizCaminho[49-i][8];
				}
				else if(i >= 50 && i < 52){
					MatrizCaminhoCor[i-39] = MatrizCaminho[0][57-i];
				}
				else if(i == 52){
					MatrizCaminhoCor[i] = MatrizCaminhoCor[0];

				}
				else if(i >= 53 && i < 59){
					MatrizCaminhoCor[i] = MatrizCaminho[7][66-i];

				}
			}

		}
		
		return MatrizCaminhoCor;
	}



	/*
	private ArrayList<Point> inicializaListaCaminho(){
		for(int coluna = 0; coluna < 15; coluna++){
			for(int linha = 0; linha < 15; linha++){
				ListaCaminho.add(new Point(40*linha, 40*coluna));
			}
		}
		return ListaCaminho;
	}

	private ArrayList<Point> inicializaListaCaminhoCor(Color color, ArrayList<Point>ListaCaminho){
		ArrayList<Point>ListaCaminhoCor = new ArrayList<Point>();

		if(color == Color.BLUE){


		}

		else if(color == Color.GREEN){


		}

		else if(color == Color.RED){


		}

		else if(color == Color.YELLOW){


		}

		return ListaCaminhoCor;
	}*/

}
