package grafica;

import java.awt.*;
import javax.swing.*;


public class Board extends JFrame {
	JButton bDado1, bDado2,bDado3,bDado4,bDado5, bDado6;
	
	
	
	public static void main(String arg[]){
		new Board();
	}
	
	public Board(){
		//Definindo configuracoes defaults para o JFrame
		this.setSize(768,640);
		this.setTitle("LUDO & FRIENDS");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Centralizando a Janela com Tela do PC
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);
		
		//Criando Panel que vai conter o dado e botoes
		JPanel dbPanel = new JPanel();
	
		//Criando Box para dividir o Frame em partes: Tabuleiro e Dado.
		Box thebox = Box.createHorizontalBox();
		
		//Chamar a funcao que ira montar as imagens do dado e etc
		//bDado1 = makeMeButtons("null");
		
		//Adicionando o box do dado para o panel
		dbPanel.add(thebox);
		
		//Posicionando os botoes no lado direito do frame
		this.add(dbPanel,BorderLayout.EAST);
		
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