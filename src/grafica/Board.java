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
	JButton RollDice;
	MoveBitch GetOutDaWay;
	DrawingBoard GUI;

	Board(){
		GUI = new DrawingBoard();
		Path pPath = new Path();
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


					switch (Round){

					case 0: //Inicio de Jogo
						for (int i = 0; i < 60; i++){
							if(pPath.getRed()[i].getline() == cX && pPath.getRed()[i].getcolumn() == cY){
								GetOutDaWay = new MoveBitch(ConjuntoDePinos.RedPino[0], pPath.getRed(), nRandDice);
							}
						}
						break;

					case 1:
						for (int i = 0; i < 60; i++){
							if(pPath.getGreen()[i].getline() == cX && pPath.getGreen()[i].getcolumn() == cY){
								GetOutDaWay = new MoveBitch(ConjuntoDePinos.GreenPino[0], pPath.getGreen(), nRandDice);
							}
						}
						break;

					case 2:
						for (int i = 0; i < 60; i++){
							if(pPath.getYellow()[i].getline() == cX && pPath.getYellow()[i].getcolumn() == cY){
								GetOutDaWay = new MoveBitch(ConjuntoDePinos.YellowPino[0], pPath.getYellow(), nRandDice);
							}
						}
						break;

					case 3:
						for (int i = 0; i < 60; i++){
							if(pPath.getBlue()[i].getline() == cX && pPath.getBlue()[i].getcolumn() == cY){
								GetOutDaWay = new MoveBitch(ConjuntoDePinos.BluePino[0], pPath.getBlue(), nRandDice);
							}
						}
						break;

					}

					GetOutDaWay.JustDoIt();//Realizando a Jogada
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


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private class HandlerClass implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			cX = e.getX();
			cY = e.getY();
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