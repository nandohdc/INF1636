package grafica;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

@SuppressWarnings("serial")
public class Dice extends JPanel{
	int nRand = 0;
	
	private static Dice dfirstInstance = null;
	
	public static Dice getInstancce(){
		if(dfirstInstance == null){
			
			dfirstInstance = new Dice();
		}
		
		return dfirstInstance;
	}
	
	public Dice(){
		this.nRand = 0;
	}

	public void generatingRandomNumberDice(){

		Random Rand = new Random();
		this.nRand = Rand.nextInt(6)+1;
	}


	public ImageIcon MakingImageDice(int nRand){

		BufferedImage img = null;

		switch(nRand){
		case 1:
			try {
				img = ImageIO.read(new File("src/ImageDice/Dado1F.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 2:
			try {
				img = ImageIO.read(new File("src/ImageDice/Dado2F.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 3:
			try {
				img = ImageIO.read(new File("src/ImageDice/Dado3F.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 4:
			try {
				img = ImageIO.read(new File("src/ImageDice/Dado4F.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 5:
			try {
				img = ImageIO.read(new File("src/ImageDice/Dado5F.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 6:
			try {
				img = ImageIO.read(new File("src/ImageDice/Dado6F.png"));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}



		return new ImageIcon(img);
	}
	
	public int getRandNum(){
		return this.nRand;
	}
}
