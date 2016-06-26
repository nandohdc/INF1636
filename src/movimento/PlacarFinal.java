package movimento;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PlacarFinal extends JFrame{

	JButton closePlacar;
	ActionHandler aHandler;
	JLabel ScoreRed;
	JLabel ScoreBlue;
	JLabel ScoreYellow;
	JLabel ScoreGreen;

	public PlacarFinal(){
		closePlacar = new JButton("OK");
		
		//Criando Box para dividir o Frame em partes:Score e Botao.
		Box thebox = Box.createVerticalBox();
		Box theboxH = Box.createHorizontalBox();
		
		//Definindo configuracoes defaults para o JFrame
		this.setSize(200,150);
		this.setTitle("LUDO & FRIENDS - SCORE - PLACAR FINAL");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		aHandler = new ActionHandler();

		//Adicionando ActionListner ao botao RollDice
		closePlacar.addActionListener(aHandler);
		
		//Criando os Labels do score
		ScoreRed = new JLabel();
		ScoreRed.setText("Red: " + Integer.toString(Score.getInstancce().getScoreRed()));
		ScoreBlue = new JLabel();
		ScoreBlue.setText("Blue: " + Integer.toString(Score.getInstancce().getScoreBlue()));
		ScoreYellow = new JLabel();
		ScoreYellow.setText("Yellow: " + Integer.toString(Score.getInstancce().getScoreYellow()));
		ScoreGreen = new JLabel();
		ScoreGreen.setText("Green: " + Integer.toString(Score.getInstancce().getScoreGreen()));
		
		//Adicionando os Labels do score ao box
		thebox.add(ScoreRed);
		thebox.add(ScoreBlue);
		thebox.add(ScoreYellow);
		thebox.add(ScoreGreen);
		
		//Adicionando o box do Save ao box
		theboxH.add(closePlacar);
		
		//Adicionando o box do dado para o panel
		this.add(thebox, BorderLayout.NORTH);
		this.add(theboxH, BorderLayout.CENTER);
		
		//Centralizando a Janela com Tela do PC
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);

		//Setting a posicao de centralizacao
		this.setLocation(xPos,yPos);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		//Mostrando a frame
		this.setVisible(true);
	}

	private class ActionHandler implements ActionListener{

		public void actionPerformed(ActionEvent e){
			if(e.getSource() == closePlacar){
				
				System.exit(0);

			}
		}
	}
}
