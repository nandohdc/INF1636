package movimento;

import java.awt.Color;

public class PinoEstruturado {
	int casa;
	int numero;
	Color cor;
	
	public PinoEstruturado(){
		this.casa = 0;
		this.numero = 0;
		this.cor = null;
	}
	
	public PinoEstruturado(int ca, int num, Color co){
		this.casa = ca;
		this.numero = num;
		this.cor = co;
	}
	
	public Color getColor(){
		return this.cor;
	}

	public int getCasa(){
		return this.casa;

	}

	public int getNumero(){
		return this.numero;

	}
	
	public void setCasa(int mCasa){
		this.casa = mCasa;
	}
	
}
