package grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import regras.*;


@SuppressWarnings("serial")
public class Board extends JFrame implements ActionListener{
	int Round = 0;
	int cX;
	int cY;
	public boolean checkPino = false;
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
					int nRandDice;


					//Gerando o numero aleatorio de 1 a 6 
					dice.generatingRandomNumberDice();
					nRandDice = dice.getRandNum();

					//Montando a Imagem com o numero aletatorio gerado passado com parametro
					DadoImageIcon = dice.MakingImageDice(nRandDice);

					//Adicionando a imagem ao label
					lImageIconDado.setIcon(DadoImageIcon);

					if(Round == 4){
						Round = 0;
					}

					GUI.addMouseListener(handler);

					System.out.printf("Round: %d\n", Round);
					switch (Round){

					case 0: //Inicio de Jogo
						
						

						if( checkPino == true ){

							GetOutDaWay = new MoveBitch(ConjuntoDePinos.RedPino[0], pPath.getRed(), nRandDice);
							GetOutDaWay.JustDoIt();//Realizando a Jogada
						}
						/*
						for (int i = 0; i < 60; i++){

							if(pPath.getRed()[i].getline() == cX && pPath.getRed()[i].getcolumn() == cY){
								GetOutDaWay = new MoveBitch(ConjuntoDePinos.RedPino[0], pPath.getRed(), nRandDice);
							}
						}*/
						break;

					case 1:

						if( checkPino == true ){

							GetOutDaWay = new MoveBitch(ConjuntoDePinos.RedPino[0], pPath.getRed(), nRandDice);
							GetOutDaWay.JustDoIt();//Realizando a Jogada
						}

						/*for (int i = 0; i < 60; i++){

							if(pPath.getGreen()[i].getline() == cX && pPath.getGreen()[i].getcolumn() == cY){
								GetOutDaWay = new MoveBitch(ConjuntoDePinos.GreenPino[0], pPath.getGreen(), nRandDice);
							}
						}*/
						break;

					case 2:

						if( checkPino == true ){

							GetOutDaWay = new MoveBitch(ConjuntoDePinos.RedPino[0], pPath.getRed(), nRandDice);
							GetOutDaWay.JustDoIt();//Realizando a Jogada
						}

						/*
							for (int i = 0; i < 60; i++){
								if(pPath.getYellow()[i].getline() == cX && pPath.getYellow()[i].getcolumn() == cY){
									GetOutDaWay = new MoveBitch(ConjuntoDePinos.YellowPino[0], pPath.getYellow(), nRandDice);
								}
							}*/
						break;

					case 3:

						if( checkPino == true ){

							GetOutDaWay = new MoveBitch(ConjuntoDePinos.RedPino[0], pPath.getRed(), nRandDice);
							GetOutDaWay.JustDoIt();//Realizando a Jogada
						}

						/*
							for (int i = 0; i < 60; i++){
								if(pPath.getBlue()[i].getline() == cX && pPath.getBlue()[i].getcolumn() == cY){
									GetOutDaWay = new MoveBitch(ConjuntoDePinos.BluePino[0], pPath.getBlue(), nRandDice);
								}
							}*/
						break;

					}

					
					Round = Round + 1; //Incrementando ao Rodada

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

	public boolean CheckCoordinates(Path CaminhoColorido, int CoordinateX ,int CoordinateY){
		System.out.printf("X: %d--------Y: %d\n", CoordinateX,CoordinateY);
		
		for( int i = 1; i < 58; i++){
			System.out.printf("Line: %d ----- Line+1: %d --------Coluna: %d -----Coluna+1: %d\n", CaminhoColorido.getRed()[i].getline(),CaminhoColorido.getRed()[i+1].getline(),CaminhoColorido.getRed()[i].getcolumn(),CaminhoColorido.getRed()[i+1].getcolumn());
			if((CoordinateX >= CaminhoColorido.getRed()[i].getline() && CoordinateX <= CaminhoColorido.getRed()[i+1].getline()) && (CoordinateY >= CaminhoColorido.getRed()[i].getcolumn() &&  CoordinateY <= CaminhoColorido.getRed()[i+1].getcolumn())){
				System.out.printf("YES!\n");
				return true;
			}
		}
		System.out.printf("NO!\n");
		return false;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private class HandlerClass implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.printf("X: %d--------Y: %d\n", cX,cY);
			cX = e.getX();
			cY = e.getY();
			System.out.printf("X: %d--------Y: %d\n", cX,cY);
			
			if(CheckCoordinates(pPath, cX, cY) == true ){
				checkPino = true; //setting flag on
				System.out.printf("YES!\n");
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