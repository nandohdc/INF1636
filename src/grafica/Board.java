package grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import movimento.ConjuntoDePinos;
import movimento.FacadeMovimento;
import movimento.Path;


@SuppressWarnings("serial")
public class Board extends JFrame{
	JButton RollDice;
	DrawingBoard GUI;
	MouseHandler mHandler;
	ActionHandler aHandler;
	Dice dice;
	JLabel lImageIconDado;
	FacadeMovimento fMov;
	public static int round;

	Board(){
		new ConjuntoDePinos();
		GUI = new DrawingBoard();
		mHandler = new MouseHandler();
		aHandler = new ActionHandler();
		round = 0;
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
		dice = new Dice();

		//Criando um Label para adicionar a img e chamando a funcao que cria as imagens do dado
		lImageIconDado = new JLabel();

		//Atribuindo a um container a referencia da img
		Container cDice = lImageIconDado;

		//Adicionando a image ao box
		thebox.add(cDice);

		//Criando o botao(RollDice)
		RollDice = new JButton("Roll Dice");

		//Adicionando ActionListner ao botao RollDice
		RollDice.addActionListener(aHandler);

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


	public class ActionHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){
			if(e.getSource() == RollDice){
				ImageIcon DadoImageIcon = null;

				RollDice.setEnabled(false);

				fMov = new FacadeMovimento();

				fMov.RollDice();

				GUI.addMouseListener(mHandler);



				//Montando a Imagem com o numero aletatorio gerado passado com parametro
				DadoImageIcon = dice.MakingImageDice(Dice.getInstance().getRandNum());

				//Adicionando a imagem ao label
				lImageIconDado.setIcon(DadoImageIcon);

				//Redesenhando o panel grafico
				GUI.revalidate();
				GUI.repaint();
				repaint();

			}

		}

	}

	public class MouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int cX = e.getX();
			int cY = e.getY();

			if(fMov.setClickedCoordinates(cX, cY) == true){
				RollDice.setEnabled(true);
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
