package grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import movimento.ConjuntoDePinos;
import movimento.House;
import movimento.MoveBitch;
import movimento.Path;
import regras.*;


@SuppressWarnings("serial")
public class Board extends JFrame implements ActionListener{
	int Round = 0;
	int cX;
	int cY;
	int nRandDice;
	int checkPino;
	JButton RollDice;
	MoveBitch GetOutDaWay;
	Path pPath;
	DrawingBoard GUI;

	Board(){
		GUI = new DrawingBoard();
		pPath = new Path();
		new ConjuntoDePinos();
		HandlerClass handler = new HandlerClass();

		//Definindo configuracoes defaults para o JFrame
		this.setSize(768,640);
		this.setTitle("LUDO & FRIENDS");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Centralizando a Janela com Tela do PC
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);

		//Criando Box para dividir o Frame em partes: Tabuleiro e Dado.
		Box thebox = Box.createVerticalBox();

		//Criando objeto do tipo Dice
		Dice dice = new Dice();

		//Criando um Label para adicionar a img e chamando a funcao que cria as imagens do dado
		JLabel lImageIconDado = new JLabel();

		//Atribuindo a um container a referencia da img
		Container cDice = lImageIconDado;

		//Adicionando a image ao box
		thebox.add(cDice);

		//Criando o botao(RollDice)
		RollDice = new JButton("Roll Dice");

		//Adicionando ActionListner ao botao RollDice
		RollDice.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == RollDice){
					ImageIcon DadoImageIcon;

					//Gerando o numero aleatorio de 1 a 6 
					dice.generatingRandomNumberDice();
					nRandDice = dice.getRandNum();

					//Montando a Imagem com o numero aletatorio gerado passado com parametro
					DadoImageIcon = dice.MakingImageDice(nRandDice);

					//Adicionando a imagem ao label
					lImageIconDado.setIcon(DadoImageIcon);

					RollDice.setEnabled(false);

					GUI.addMouseListener(handler);

					//Redesenhando o panel grafico
					GUI.revalidate();
					GUI.repaint();
					repaint();

				}
			}
		});

		//Adicionando o botao ao box
		thebox.add(RollDice);

		//Adicionando o box do dado para o panel
		this.add(thebox, BorderLayout.EAST);

		//Fazendo com que a area desenhada tome conta da parte central do frame
		this.add(GUI ,BorderLayout.CENTER);

		//Setting a posicao de centralizacao
		this.setLocation(xPos,yPos);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		//Mostrando a frame
		this.setVisible(true);

	}

	public House CheckCoordinates(Path Caminho, int CoordinateX ,int CoordinateY){
		House aux1 = null;
		for( int i = 0; i < 15; i++){
			for(int j = 0; j < 15 ; j++){
				if((CoordinateX >= Caminho.getCaminhoCompleto()[i][j].getline() && CoordinateX <= Caminho.getCaminhoCompleto()[i][j].getline()+40) && (CoordinateY >= Caminho.getCaminhoCompleto()[i][j].getcolumn() &&  CoordinateY <= Caminho.getCaminhoCompleto()[i][j].getcolumn()+40)){

					aux1 = Caminho.getCaminhoCompleto()[i][j];

				}
			}
		}

		return aux1;

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private class HandlerClass implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			cX = e.getX();
			cY = e.getY();

			House aux = null;


			if(Round == 4){
				Round = 0;
			}

			System.out.printf("Round: %d\n", Round);

			switch (Round){

			case 0: //Inicio de Jogo

				for(int k = 0; k < 4; k++){
					if (ConjuntoDePinos.RedPino[k].getCasa() == 0){
						if((cX >= 405 && cX <= 435) && (cY >= 45 && cY <= 75)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else if((cX >= 525 && cX <= 555) && (cY >= 45 && cY <= 75)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else if((cX >= 525 && cX <= 555) && (cY >= 165  && cY <= 195)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else if((cX >= 405 && cX <= 435) && (cY >= 165 && cY <= 195)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else{

						} 
					}

					else{
						aux = pPath.getRed()[ConjuntoDePinos.RedPino[k].getCasa() - 1];

					}

					if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
						checkPino = k + 1;
						break;
					}


				}

				if((checkPino >= 1 && checkPino <= 4) && nRandDice > 0){

					GetOutDaWay = new MoveBitch(ConjuntoDePinos.RedPino[checkPino - 1], pPath.getRed(), nRandDice);
					GetOutDaWay.JustDoIt();//Realizando a Jogada
					checkPino = 0;
					Round = Round + 1; //Incrementando ao Rodada
					nRandDice = 0;
					RollDice.setEnabled(true);

				}

				break;

			case 1:


				for(int k = 0; k < 4; k++){
					if (ConjuntoDePinos.BluePino[k].getCasa() == 0 ){
						if((cX >= 405 && cX <= 435) && (cY >= 405 && cY <= 435)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else if((cX >= 525 && cX <= 555) && (cY >= 405 && cY <= 435)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else if((cX >= 525 && cX <= 555) && (cY >= 525  && cY <= 555)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else if((cX >= 405 && cX <= 435) && (cY >= 525 && cY <= 555)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else{

						} 
					}

					else{
						aux = pPath.getBlue()[ConjuntoDePinos.BluePino[k].getCasa() - 1];

					}

					if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
						checkPino = k + 1;
						break;
					}


				}

				if((checkPino >= 1 && checkPino <= 4) && nRandDice > 0){

					GetOutDaWay = new MoveBitch(ConjuntoDePinos.BluePino[checkPino - 1], pPath.getBlue(), nRandDice);
					GetOutDaWay.JustDoIt();//Realizando a Jogada
					checkPino = 0;
					Round = Round + 1; //Incrementando ao Rodada
					System.out.printf("OK1!\n");
					nRandDice = 0;
					RollDice.setEnabled(true);
				}

				break;

			case 2:


				for(int k = 0; k < 4; k++){
					if (ConjuntoDePinos.YellowPino[k].getCasa() == 0 ){
						if((cX >= 45 && cX <= 75) && (cY >= 405 && cY <= 435)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else if((cX >= 165 && cX <= 195) && (cY >= 405 && cY <= 435)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else if((cX >= 165 && cX <= 195) && (cY >= 525  && cY <= 555)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else if((cX >= 45 && cX <= 75) && (cY >= 525 && cY <= 555)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else{

						} 
					}

					else{
						aux = pPath.getYellow()[ConjuntoDePinos.YellowPino[k].getCasa() - 1];

					}

					if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
						checkPino = k + 1;
						break;
					}



				}

				if((checkPino >= 1 && checkPino <= 4) && nRandDice > 0){
					System.out.printf("OK2!\n");
					GetOutDaWay = new MoveBitch(ConjuntoDePinos.YellowPino[checkPino - 1], pPath.getYellow(), nRandDice);
					GetOutDaWay.JustDoIt();//Realizando a Jogada
					checkPino = 0;
					Round = Round + 1; //Incrementando ao Rodada
					nRandDice = 0;
					RollDice.setEnabled(true);
				}

				break;

			case 3:


				for(int k = 0; k < 4; k++){
					if (ConjuntoDePinos.GreenPino[k].getCasa() == 0 ){
						if((cX >= 45 && cX <= 75) && (cY >= 45 && cY <= 75)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else if((cX >= 165 && cX <= 195) && (cY >= 45 && cY <= 85)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else if((cX >= 165 && cX <= 195) && (cY >= 165  && cY <= 195)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else if((cX >= 45 && cX <= 75) && (cY >= 165 && cY <= 195)){
							aux = CheckCoordinates(pPath, cX, cY);
						}
						else{

						} 
					}

					else{
						aux = pPath.getGreen()[ConjuntoDePinos.GreenPino[k].getCasa() - 1];

					}

					if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
						checkPino = k + 1;
						break;
					}



				}

				if((checkPino >= 1 && checkPino <= 4) && nRandDice > 0){

					GetOutDaWay = new MoveBitch(ConjuntoDePinos.GreenPino[checkPino - 1], pPath.getGreen(), nRandDice);
					GetOutDaWay.JustDoIt();//Realizando a Jogada
					checkPino = 0;
					Round = Round + 1; //Incrementando ao Rodada
					nRandDice = 0;
					RollDice.setEnabled(true);
				}

				break;

			}


		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			//RollDice.setText(String.format("Pressed at %d %d", e.getX(), e.getY()));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			//RollDice.setText(String.format("U RELEASED THE BUTTON", e.getX(), e.getY()));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			//RollDice.setText(String.format("SELECIONE THE FUCKING PINO", e.getX(), e.getY()));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			//RollDice.setText(String.format("BOA SORTE!", e.getX(), e.getY()));
		}

	}
}