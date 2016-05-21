package menu;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

import grafica.MainBoard;

@SuppressWarnings("serial")
public class MainScreen extends JFrame implements ActionListener{
	JButton iniciar = new JButton("INICIAR");
	JButton carregar = new JButton("CARREGAR");
	JButton sair = new JButton("SAIR");
	JPanel central = new JPanel();
	JFrame frame = new JFrame();
	JFileChooser explorer = new JFileChooser();
	
	public static void main(String[] args) {
		new MainScreen();
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == sair){
			System.exit(0);
		}
		else if(e.getSource() == iniciar){
			frame.setVisible(false); //Esconde a Tela Principal
			MainBoard.main(null);// Chama a main do Principal.
		}

		else if(e.getSource() == carregar){
			int value = explorer.showOpenDialog(carregar);
			if (value == JFileChooser.APPROVE_OPTION) {
				File LoadFile = explorer.getSelectedFile();
				// load from file
			}
		}
	}

	public MainScreen() {
		super("LUDO & FRIENDS");

		iniciar.addActionListener(this);
		carregar.addActionListener(this);
		sair.addActionListener(this);
		JLabel image = new JLabel(makeImage());

		Toolkit tk = Toolkit.getDefaultToolkit();

		Dimension dim = tk.getScreenSize();

		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);

		central.setOpaque(false);
		central.setLocation(512, 250);
		central.setSize(300, 300);
		central.setLayout(new GridLayout(0,1,0,20));
		central.add(iniciar);
		central.add(carregar);
		central.add(sair);

		
		Container c = image;

		frame.getContentPane().add(central);
		frame.getContentPane().add(c);
		frame.pack();

		frame.setLocation(xPos,yPos);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	// For the demo, the image is pretty simple but
	// practice it could be anything, e.g. an intricate
	// Java2D drawing or loaded from a file.
	private ImageIcon makeImage() {

		BufferedImage result = null;
		try {
			result = ImageIO.read(new File("/Users/fernandohomem/git/INF1636-LudoGame-FHMR/1211971-1213068/src/menu/LudoGameFinal.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ImageIcon(result);
	}

}
