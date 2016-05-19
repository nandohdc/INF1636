package grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import java.util.*;
import java.util.ArrayList;

class DrawingBoard extends JComponent /* implements MouseListener */ {
	int []xgreen = {240, 240, 300};
	int []ygreen = {360, 240, 300};
	int []xyellow = {360, 240, 300};
	int []yyellow = {360, 360, 300};
	int []xred = {240, 360, 300};
	int []yred = {240, 240, 300};
	int []xblue = {360, 360, 300};
	int []yblue = {360, 240, 300};
	
	House[][] CASACARALHO = new House[15][15];
	House[] cverde = new House[59];
	House[] cvermelho = new House[59];
	House[] cazul = new House[59];
	House[] camarelo = new House[59];

	public void paintBoard(Graphics g) {
		
		// Class usada para definir os formatos para serem desenhados
		Graphics2D graphSettings = (Graphics2D) g;

		// Para limpar os borroes das lines e definar regras de renderizacao
		graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Definindo a cor do plano de fundo: Branco
		setBackground(Color.WHITE);
		
		//Vai dividir em quadradinho e pintar os caminhos finais de cada cor.
		for (int column = 0; column < 15; column++) {
			for (int line = 0; line < 15; line++) {

				// Verde: Pinta o caminho final de verde.
				if ((column == 6 && line == 1) || ((column == 7) && (line > 0 && line < 6))) {
					graphSettings.setPaint(Color.green);
					graphSettings.fill(new Rectangle2D.Double(40 * line, 40 * column, 40, 40));

				}

				// Vermelho: Pinta o caminho final de vermelho.
				else if ((line == 8 && column == 1) || ((line == 7) && (column > 0 && column < 6))) {
					graphSettings.setPaint(Color.red);
					graphSettings.fill(new Rectangle2D.Double(40 * line, 40 * column, 40, 40));
				}

				// Azul: Pinta o caminho final de Azul.
				else if ((column == 8 && line == 13) || ((column == 7) && (line > 8 && line < 14))) {
					graphSettings.setPaint(Color.blue);
					graphSettings.fill(new Rectangle2D.Double(40 * line, 40 * column, 40, 40));
				}
				// Amarelo: Pinta o caminho final de Amarelo.
				else if ((line == 6 && column == 13) || ((line == 7) && (column > 8 && column < 14))) {
					graphSettings.setPaint(Color.yellow);
					graphSettings.fill(new Rectangle2D.Double(40 * line, 40 * column, 40, 40));
				}

				// Ira dividir o tabuleiro em varios quadradadinhos (GridLines)
				graphSettings.setPaint(Color.black);
				graphSettings.draw(new Rectangle2D.Double(40 * line, 40 * column, 40, 40));

			}
		}
		
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
		
		graphSettings.setPaint(Color.green);
		graphSettings.fill(new Rectangle2D.Double(0, 0, 240, 240));
		graphSettings.setPaint(Color.yellow);
		graphSettings.fill(new Rectangle2D.Double(0, 360, 240, 240));
		graphSettings.setPaint(Color.red);
		graphSettings.fill(new Rectangle2D.Double(360, 0, 240, 240));
		graphSettings.setPaint(Color.blue);
		graphSettings.fill(new Rectangle2D.Double(360, 360, 240, 240));
		
		graphSettings.setPaint(Color.black);
		graphSettings.draw(new Rectangle2D.Double(0, 0, 240, 240));
		graphSettings.draw(new Rectangle2D.Double(0, 360, 240, 240));
		graphSettings.draw(new Rectangle2D.Double(360, 0, 240, 240));
		graphSettings.draw(new Rectangle2D.Double(360, 360, 240, 240));

		graphSettings.fill(new Rectangle2D.Double(240, 40, 40, 40));
		graphSettings.fill(new Rectangle2D.Double(40, 320, 40, 40));
		graphSettings.fill(new Rectangle2D.Double(520, 240, 40, 40));
		graphSettings.fill(new Rectangle2D.Double(320, 520, 40, 40));

		

		graphSettings.setPaint(Color.green);
		graphSettings.fillPolygon(xgreen, ygreen, 3);
		graphSettings.setPaint(Color.yellow);
		graphSettings.fillPolygon(xyellow, yyellow, 3);
		graphSettings.setPaint(Color.red);
		graphSettings.fillPolygon(xred, yred, 3);
		graphSettings.setPaint(Color.blue);
		graphSettings.fillPolygon(xblue, yblue, 3);

		graphSettings.setPaint(Color.black);
		graphSettings.drawPolygon(xgreen, ygreen, 3);
		graphSettings.drawPolygon(xyellow, yyellow, 3);
		graphSettings.drawPolygon(xred, yred, 3);	
		graphSettings.drawPolygon(xblue, yblue, 3);
		

		
		for(int i = 0; i < 15; i++){
			for(int j = 0; j < 15; j++){
				graphSettings.setPaint(Color.white);
				if(((i == 1) || (i == 4) || (i == 10) || (i == 13)) && ((j == 1) || (j == 4) || (j == 10) || (j == 13))){
					graphSettings.fill(new Ellipse2D.Double(40*i, 40*j, 40, 40));
					graphSettings.setPaint(Color.black);
					graphSettings.draw(new Ellipse2D.Double(40*i, 40*j, 40, 40));
				}
					
			}
		}
		for(int i = 1; i < 5; i++){
			new Pino(0, i, Color.green).desenhaPino(graphSettings, cverde);
			new Pino(0, i, Color.red).desenhaPino(graphSettings, cvermelho);
			new Pino(0, i, Color.yellow).desenhaPino(graphSettings, camarelo);
			new Pino(0, i, Color.blue).desenhaPino(graphSettings, cazul);
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintBoard(g);
	}

}
