package grafica;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import regras.*;

@SuppressWarnings("serial")
public class Pino extends JComponent{
	
	House[] Caminhooo = new House[59];
	int casa;
	int numero;
	Color cor;
	
	public Pino(House[] CaminhoColorido, PinoEstruturado pino){
		this.Caminhooo = CaminhoColorido;
		this.casa = pino.getCasa();
		this.numero = pino.getNumero();
		this.cor = pino.getColor();
	}
	
	public void paintPino(Graphics g){
		Graphics2D yeah = (Graphics2D) g;
		Ellipse2D pin = new Ellipse2D.Double();
		if(this.casa == 0){
			if(this.cor == Color.green){
				yeah.setPaint(Color.green);
				if(this.numero == 1){
					pin.setFrame(new Rectangle(45, 45, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
				else if(this.numero == 2){
					pin.setFrame(new Rectangle(165, 45, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
				else if(this.numero == 3){
					pin.setFrame(new Rectangle(45, 165, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
				else if(this.numero == 4){
					pin.setFrame(new Rectangle(165, 165, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
			}
			else if(this.cor == Color.red){
				yeah.setPaint(Color.red);
				if(this.numero == 1){
					pin.setFrame(new Rectangle(405, 45, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
				else if(this.numero == 2){
					pin.setFrame(new Rectangle(525, 45, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
				else if(this.numero == 3){
					pin.setFrame(new Rectangle(405, 165, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
				else if(this.numero == 4){
					pin.setFrame(new Rectangle(525, 165, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
			}
			else if(this.cor == Color.yellow){
				yeah.setPaint(Color.yellow);
				if(this.numero == 1){
					pin.setFrame(new Rectangle(45, 405, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
				else if(this.numero == 2){
					pin.setFrame(new Rectangle(165, 405, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
				else if(this.numero == 3){
					pin.setFrame(new Rectangle(45, 525, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
				else if(this.numero == 4){
					pin.setFrame(new Rectangle(165, 525, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
			}
			else if(this.cor == Color.blue){
				yeah.setPaint(Color.blue);
				if(this.numero == 1){
					pin.setFrame(new Rectangle(405, 405, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
				else if(this.numero == 2){
					pin.setFrame(new Rectangle(525, 405, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
				else if(this.numero == 3){
					pin.setFrame(new Rectangle(405, 525, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
				else if(this.numero == 4){
					pin.setFrame(new Rectangle(525, 525, 30, 30));
					yeah.fill(pin);
					yeah.setColor(Color.black);
					yeah.draw(pin);
				}
			}
		}
		else{
			yeah.setPaint(cor);
			pin.setFrame(new Rectangle(this.Caminhooo[casa-1].getline() + 5, this.Caminhooo[casa-1].getcolumn() + 5, 30, 30));
			yeah.fill(pin);
			yeah.setColor(Color.black);
			yeah.draw(pin);
		}
	}

}
