package grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

@SuppressWarnings("serial")
class DrawingBoard extends JComponent /* implements MouseListener */ {

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
		paintPino();
	}

}
