package regras;

import java.awt.Color;

import movimento.ConjuntoDePinos;
import movimento.PinoEstruturado;

public class RegraTiraSeis {
	private int limite6;
	
	public void RegraTiraSeis(){
		this.limite6 = 0;
	}
	
	public int RegraDoTiraSeis(int mDado, PinoEstruturado mPino){
		int aux = 0;
		if(limite6 == 3){
			return 0;
		}
		limite6++;
		for(int i = 0; i < 4; i++){
			if(mPino.getColor() == Color.red && ConjuntoDePinos.RedPino[i].getCasa() == 0){
				aux++;
			}
			else if(mPino.getColor() == Color.blue && ConjuntoDePinos.BluePino[i].getCasa() == 0){
				aux++;
			}
			else if(mPino.getColor() == Color.yellow && ConjuntoDePinos.YellowPino[i].getCasa() == 0){
				aux++;
			}
			else if(mPino.getColor() == Color.green && ConjuntoDePinos.GreenPino[i].getCasa() == 0){
				aux++;
			}
		}
		if(aux > 0){
			return 6;
		}
		else{
			return 7;
		}
	}
}
