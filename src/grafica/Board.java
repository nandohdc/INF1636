package grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import regras.*;


@SuppressWarnings("serial")
public class Board extends JFrame /*implements ActionListener*/{
	
	Board(){
		
		//Definindo configuracoes defaults para o JFrame
		this.setSize(768,640);
		this.setTitle("LUDO & FRIENDS");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Centralizando a Janela com Tela do PC
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);
		
		//Fazendo com que a area desenhada tome conta da parte central do frame
		this.add(new DrawingBoard(),BorderLayout.CENTER);
		
		//Setting a posicao de centralizacao
		this.setLocation(xPos,yPos);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//Mostrando a frame
		this.setVisible(true);
		
	}
	
}