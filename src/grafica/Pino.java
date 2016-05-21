package grafica;

import java.awt.*;
import java.awt.geom.*;
import regras.House;

public class Pino {
	

	void desenhaPino(Graphics2D g, House[] CaminhoColorido, int casa, int numero, Color cor){

		Ellipse2D pin = new Ellipse2D.Double();
		if(casa == 0){
			if(cor == Color.green){
				g.setPaint(Color.green);
				if(numero == 1){
					pin.setFrame(new Rectangle(45, 45, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
				else if(numero == 2){
					pin.setFrame(new Rectangle(165, 45, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
				else if(numero == 3){
					pin.setFrame(new Rectangle(45, 165, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
				else if(numero == 4){
					pin.setFrame(new Rectangle(165, 165, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
			}
			else if(cor == Color.red){
				g.setPaint(Color.red);
				if(numero == 1){
					pin.setFrame(new Rectangle(405, 45, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
				else if(numero == 2){
					pin.setFrame(new Rectangle(525, 45, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
				else if(numero == 3){
					pin.setFrame(new Rectangle(405, 165, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
				else if(numero == 4){
					pin.setFrame(new Rectangle(525, 165, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
			}
			else if(cor == Color.yellow){
				g.setPaint(Color.yellow);
				if(numero == 1){
					pin.setFrame(new Rectangle(45, 405, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
				else if(numero == 2){
					pin.setFrame(new Rectangle(165, 405, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
				else if(numero == 3){
					pin.setFrame(new Rectangle(45, 525, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
				else if(numero == 4){
					pin.setFrame(new Rectangle(165, 525, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
			}
			else if(cor == Color.blue){
				g.setPaint(Color.blue);
				if(numero == 1){
					pin.setFrame(new Rectangle(405, 405, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
				else if(numero == 2){
					pin.setFrame(new Rectangle(525, 405, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
				else if(numero == 3){
					pin.setFrame(new Rectangle(405, 525, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
				else if(numero == 4){
					pin.setFrame(new Rectangle(525, 525, 30, 30));
					g.fill(pin);
					g.setColor(Color.black);
					g.draw(pin);
				}
			}
		}
		else{
			g.setPaint(cor);
			pin.setFrame(new Rectangle(CaminhoColorido[casa-1].getline() + 5, CaminhoColorido[casa-1].getcolumn() + 5, 30, 30));
			g.fill(pin);
			g.setColor(Color.black);
			g.draw(pin);
		}
	}


}
