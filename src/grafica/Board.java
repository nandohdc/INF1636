package grafica;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
import movimento.ConjuntoDePinos;
import movimento.FacadeMovimento;
import movimento.Path;
import movimento.PinoEstruturado;

@SuppressWarnings("serial")
public class Board extends JFrame{
	// Variaveis de Classe
	JButton RollDice;
	JButton Save;
	MouseHandler mHandler;
	ActionHandler aHandler;
	JLabel lImageIconDado;
	public static int round;
	JFileChooser explorer = new JFileChooser();
	
	private static Board bdfirstInstance = null;
	
	public static Board getInstancce(){
		if(bdfirstInstance == null){

			bdfirstInstance = new Board();
		}

		return bdfirstInstance;
	}
	
	Board(){
		
		PinoEstruturado pPino = new PinoEstruturado();
		
		//Criando Objeto do tipo DrawingBoard--  Singleton
		//GUI = 
		new DrawingBoard(pPino);
		
		//Criando objeto do tipo ConjuntoDePinos -- Singleton
		new ConjuntoDePinos();
		
		//Criando objeto do tipo Dice -- Singleton
		new Dice();
		
		//Criando objeto do tipo Path -- Singleton
		new Path();
		
		//Criando Objeto do tipo FacadeMovimento --  Singleton
		new FacadeMovimento();
		
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

		//Criando um Label para adicionar a img e chamando a funcao que cria as imagens do dado
		lImageIconDado = new JLabel();

		//Atribuindo a um container a referencia da img
		Container cDice = lImageIconDado;

		//Adicionando a image ao box
		thebox.add(cDice);

		//Criando o botao(RollDice)
		RollDice = new JButton("Roll Dice");
		
		//Criando o botao (Save)
		Save = new JButton("Save");
		
		//Adicionando ActionListner ao botao RollDice
		RollDice.addActionListener(aHandler);
		
		//Adicionando ActionListner ao botao Save
		Save.addActionListener(aHandler);
		
		//Adicionando o botao RollDice ao box
		thebox.add(RollDice);
		
		//Adicionando o box do Save ao box
		thebox.add(Save);
		
		//Adicionando o box do dado para o panel
		this.add(thebox, BorderLayout.EAST);
		
		//Fazendo com que a area desenhada tome conta da parte central do frame
		this.add(DrawingBoard.getInstancce() ,BorderLayout.CENTER);

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
				
				if ( round == 4){
					round = 0;
				}
				
				switch(round){
				case 0:
					RollDice.setBackground(Color.red);
					break;
					
				case 1:
					RollDice.setBackground(Color.blue);
					break;
					
				case 2:
					RollDice.setBackground(Color.yellow);
					break;
					
				case 3:
					RollDice.setBackground(Color.green);
					break;
			}
				
				RollDice.setOpaque(true);

				RollDice.setEnabled(false);

				FacadeMovimento.getInstance().RollDice();

				DrawingBoard.getInstancce().addMouseListener(mHandler);

				//Montando a Imagem com o numero aletatorio gerado passado com parametro
				DadoImageIcon = Dice.getInstance().MakingImageDice(Dice.getInstance().getRandNum());

				//Adicionando a imagem ao label
				lImageIconDado.setIcon(DadoImageIcon);

				//Redesenhando o panel grafico
				//DrawingBoard.getInstancce().revalidate();
				//DrawingBoard.getInstancce().repaint();
				//repaint();

			}
			
			else if(e.getSource() == Save){
				int value = explorer.showOpenDialog(Save);
				if (value == JFileChooser.APPROVE_OPTION) {
					File file = explorer.getSelectedFile();
					// load from file
					System.out.println("Save as file: " + file.getAbsolutePath());
				}
				
			}

		}

	}

	public class MouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int cX = e.getX();
			int cY = e.getY();

			if(FacadeMovimento.getInstance().setClickedCoordinates(cX, cY) == true){
				if ( round == 4){
					round = 0;
				}
				
				switch(round){
				case 0:
					RollDice.setBackground(Color.red);
					break;
					
				case 1:
					RollDice.setBackground(Color.blue);
					break;
					
				case 2:
					RollDice.setBackground(Color.yellow);
					break;
					
				case 3:
					RollDice.setBackground(Color.green);
					break;
			}
				
				RollDice.setOpaque(true);
				
				
				
				RollDice.setEnabled(true);
				if(Dice.getInstance().getRandNum() == 20 || Dice.getInstance().getRandNum() == 10){
					RollDice.setEnabled(false);
				}
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
