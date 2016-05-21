package grafica;

import javax.swing.*;

import regras.House;

import java.awt.*;
//import java.awt.event.MouseListener;
import java.awt.geom.*;



@SuppressWarnings("serial")
class DrawingBoard extends JComponent /* implements MouseListener */ {

	House[][] CASACARALHO = new House[15][15];
	House[] cverde = new House[59];
	House[] cvermelho = new House[59];
	House[] cazul = new House[59];
	House[] camarelo = new House[59];

	Pocket pocket = new Pocket();
	Yard yard = new Yard();

	public void paintBoard(Graphics g) {

		// Class usada para definir os formatos para serem desenhados
		Graphics2D graphSettings = (Graphics2D) g;

		// Para limpar os borroes das lines e definar regras de renderizacao
		graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Definindo a cor do plano de fundo: Branco
		setBackground(Color.WHITE);

		//Chama metodo que ira quadricular a Tela.
		GridLines(graphSettings);

		//Chama o metodo graphPocket da class Pocket para criar os triangulos centrais(casas finais)
		pocket.graphPocket(graphSettings);

		//Chama o metodo graphYard da Yard para criar os retangulos
		yard.graphYard(graphSettings);

		//Chamando o metodo Shelter que ira desenhar as casas de abrigo conforme as coordenadas passadas
		Shelter(graphSettings, 240, 40);
		Shelter(graphSettings, 40, 320);
		Shelter(graphSettings, 520, 240);
		Shelter(graphSettings, 320, 520);

		//Chamando o metodo FinalPath que ira pintar as casas finais conforme cada cor do pino passada como parametro
		for (int column = 0; column < 15; column++) {
			for (int line = 0; line < 15; line++) {
				if ((column == 6 && line == 1) || ((column == 7) && (line > 0 && line < 6))) {
					FinalPath(graphSettings, Color.GREEN, 40*line, 40*column);
				}

				// Vermelho: Pinta o caminho final de vermelho.
				else if ((line == 8 && column == 1) || ((line == 7) && (column > 0 && column < 6))) {
					FinalPath(graphSettings, Color.RED, 40*line, 40*column);
				}

				// Azul: Pinta o caminho final de Azul.
				else if ((column == 8 && line == 13) || ((column == 7) && (line > 8 && line < 14))) {
					FinalPath(graphSettings, Color.BLUE, 40*line, 40*column);
				}

				// Amarelo: Pinta o caminho final de Amarelo.
				else if ((line == 6 && column == 13) || ((line == 7) && (column > 8 && column < 14))) {
					FinalPath(graphSettings, Color.YELLOW, 40*line, 40*column);
				}
			}
		}

/*


		for(int i = 0; i < 59; i++){
			if(i < 5){
				cverde[i] = camarelo[i+13] = cazul[i+26] = cvermelho[i+39] = CASACARALHO[i+1][6];
			}
			else if(i >= 5 && i < 11){
				cverde[i] = camarelo[i+13] = cazul[i+26] = cvermelho[i+39] = CASACARALHO[6][10-i];
			}
			else if(i >= 11 && i < 13){
				cverde[i] = camarelo[i+13] = cazul[i+26] = cvermelho[i+39] = CASACARALHO[i-4][0];
			}
			else if(i >= 13 && i < 18){
				cverde[i] = camarelo[i+13] = cazul[i+26] = cvermelho[i-13] = CASACARALHO[8][i-12];
			}
			else if(i >= 18 && i < 24){
				cverde[i] = camarelo[i+13] = cazul[i+26] = cvermelho[i-13] = CASACARALHO[i-9][6];
			}
			else if(i >= 24 && i < 26){
				cverde[i] = camarelo[i+13] = cazul[i+26] = cvermelho[i-13] = CASACARALHO[14][i-17];
			}
			else if(i >= 26 && i < 31){
				cverde[i] = camarelo[i+13] = cazul[i-26] = cvermelho[i-13] = CASACARALHO[39-i][8];
			}
			else if(i >= 31 && i < 37){
				cverde[i] = camarelo[i+13] = cazul[i-26] = cvermelho[i-13] = CASACARALHO[8][i-22];
			}
			else if(i >= 37 && i < 39){
				cverde[i] = camarelo[i+13] = cazul[i-26] = cvermelho[i-13] = CASACARALHO[44-i][14];
			}
			else if(i >= 39 && i < 44){
				cverde[i] = camarelo[i-39] = cazul[i-26] = cvermelho[i-13] = CASACARALHO[6][52-i];
			}
			else if(i >= 44 && i < 50){
				cverde[i] = camarelo[i-39] = cazul[i-26] = cvermelho[i-13] = CASACARALHO[49-i][8];
			}
			else if(i >= 50 && i < 52){
				cverde[i] = camarelo[i-39] = cazul[i-26] = cvermelho[i-13] = CASACARALHO[0][57-i];
			}
			else if(i == 52){
				cverde[i] = cverde[0];
				camarelo[i] = camarelo[0];
				cazul[i] = cazul[0];
				cvermelho[i] = cvermelho[0];
			}
			else if(i >= 53 && i < 59){
				cverde[i] = CASACARALHO[i-52][7];
				camarelo[i] = CASACARALHO[7][66-i];
				cazul[i] = CASACARALHO[66-i][7];
				cvermelho[i] = CASACARALHO[7][i-52];
			}
		}





		for(int i = 1; i < 5; i++){
			new Pino(0, i, Color.green).desenhaPino(graphSettings, cverde);
			new Pino(0, i, Color.red).desenhaPino(graphSettings, cvermelho);
			new Pino(0, i, Color.yellow).desenhaPino(graphSettings, camarelo);
			new Pino(0, i, Color.blue).desenhaPino(graphSettings, cazul);
		}*/

		}

		private void GridLines(Graphics2D graphSettings){

			//Vai dividir em quadradinhos
			for (int column = 0; column < 15; column++) {
				for (int line = 0; line < 15; line++) {

					// Ira dividir o tabuleiro em varios quadradadinhos (GridLines)
					graphSettings.setPaint(Color.black);
					graphSettings.draw(new Rectangle2D.Double(40 * line, 40 * column, 40, 40));
				}
			}

		}

		public void Shelter(Graphics2D graphSettings, int x , int y){
			//Selecionando a cor do pincel como preta
			graphSettings.setPaint(Color.BLACK);

			//Preenchendo retangulos de coordenadas x e y com cor preta.
			graphSettings.fill(new Rectangle2D.Double(x, y, 40, 40));

		}

		public void FinalPath(Graphics2D graphSettings, Color color, int xCoordinate, int yCoordinate){
			//Selecionando a cor do pincel conforme a passada como parametro para o metodo
			graphSettings.setPaint(color);

			//Preenchendo um dos quadradinho do caminho final com a cor passada como parametro para o metodo
			graphSettings.fill(new Rectangle2D.Double(xCoordinate, yCoordinate, 40, 40));

			//Redefinindo a cor do pincel como preta
			graphSettings.setPaint(Color.black);

			//Redefinindo a borda do quadrado do caminho final pintado anteriormente.
			graphSettings.draw(new Rectangle2D.Double(xCoordinate, yCoordinate, 40, 40));

		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			paintBoard(g);
		}

	}
