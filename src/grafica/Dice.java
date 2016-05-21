package grafica;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

@SuppressWarnings("serial")
public class Dice extends JPanel{

	public Dice(){
		
	}
	
	public ImageIcon generateRandomDice(){

		Random Rand = new Random();
		BufferedImage img = null;
		int nRand = 0;
		int fDice[] = new int[5];

		for(int i = 0; i < 5; i++){
			nRand = Rand.nextInt(6)+1;
			fDice[i] = nRand;
		}

		switch(nRand){
		case 1:
			try {
				img = ImageIO.read(new File("/Users/fernandohomem/git/INF1636-LudoGame-FHMR/1211971-1213068/src/grafica/Dado1F.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 2:
			try {
				img = ImageIO.read(new File("/Users/fernandohomem/git/INF1636-LudoGame-FHMR/1211971-1213068/src/grafica/Dado2F.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 3:
			try {
				img = ImageIO.read(new File("/Users/fernandohomem/git/INF1636-LudoGame-FHMR/1211971-1213068/src/grafica/Dado3F.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 4:
			try {
				img = ImageIO.read(new File("/Users/fernandohomem/git/INF1636-LudoGame-FHMR/1211971-1213068/src/grafica/Dado4F.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 5:
			try {
				img = ImageIO.read(new File("/Users/fernandohomem/git/INF1636-LudoGame-FHMR/1211971-1213068/src/grafica/Dado5F.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 6:
			try {
				img = ImageIO.read(new File("/Users/fernandohomem/git/INF1636-LudoGame-FHMR/1211971-1213068/src/grafica/Dado6F.png"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
		
		
		return new ImageIcon(img);
	}
}
