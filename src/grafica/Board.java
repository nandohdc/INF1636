package grafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import regras.*;


@SuppressWarnings("serial")
public class Board extends JFrame implements ActionListener{
	
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
		JButton RollDice = new JButton("Roll Dice");
		
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
					
					//Revalidando a imagem no local
					revalidate();
					
					//Instanciando o objeto do tipo MoveBitch
					ConjuntoDePinos cPinos = new ConjuntoDePinos();
					Path pPath = new Path();
					MoveBitch GetOutDaWay = new MoveBitch(cPinos.getBlue(1), pPath.getBlue(), nRandDice );
					GetOutDaWay.JustDoIt();
					getContentPane().revalidate();
					getContentPane().repaint();
					
				}
			}
		});
		
		//Adicionando o botao ao box
		thebox.add(RollDice);
		
		//Adicionando o box do dado para o panel
		this.add(thebox, BorderLayout.EAST);
		
		//Fazendo com que a area desenhada tome conta da parte central do frame
		this.add(new DrawingBoard(),BorderLayout.CENTER);
		
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
	
}