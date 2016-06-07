package movimento;

import java.awt.Color;

import grafica.Board;
import regras.*;

public class MoveBitch {

	PinoEstruturado mPino;
	House[] mCaminho = new House[59];
	int mDado;

	public MoveBitch(){
		this.mPino = null;
		this.mCaminho = null;
		this.mDado = 0;
	}

	public MoveBitch(int cX, int cY, int Dado){
		this.mPino = CoordToPino(cX, cY);
		if(this.mPino != null){
			this.mCaminho = PinoToArrayHouse(this.mPino.getColor());
		}
		this.mDado = Dado;
	}

	private House CheckCoordinates(Path Caminho, int CoordinateX ,int CoordinateY){
		House aux1 = null;
		for( int i = 0; i < 15; i++){
			for(int j = 0; j < 15 ; j++){
				if((CoordinateX >= Caminho.getCaminhoCompleto()[i][j].getline() && CoordinateX <= Caminho.getCaminhoCompleto()[i][j].getline()+40) && (CoordinateY >= Caminho.getCaminhoCompleto()[i][j].getcolumn() &&  CoordinateY <= Caminho.getCaminhoCompleto()[i][j].getcolumn()+40)){

					aux1 = Caminho.getCaminhoCompleto()[i][j];

				}
			}
		}

		return aux1;

	}

	private PinoEstruturado CoordToPino(int cX, int cY){
		Path pPath = new Path();
		PinoEstruturado PinoRetorno = null;
		House aux = null;

		if(Board.round == 4){
			Board.round = 0;
		}

		switch (Board.round){

		case 0: //Rodada do Vermelho

			for(int k = 0; k < 4; k++){
				if (ConjuntoDePinos.RedPino[k].getCasa() == 0){
					if((cX >= 405 && cX <= 435) && (cY >= 45 && cY <= 75)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else if((cX >= 525 && cX <= 555) && (cY >= 45 && cY <= 75)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else if((cX >= 525 && cX <= 555) && (cY >= 165  && cY <= 195)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else if((cX >= 405 && cX <= 435) && (cY >= 165 && cY <= 195)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else{

					} 
				}

				else{
					aux = pPath.getRed()[ConjuntoDePinos.RedPino[k].getCasa() - 1];

				}

				if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
					PinoRetorno = ConjuntoDePinos.RedPino[k];
					break;
				}


			}

			break;

		case 1: //Rodada do Azul


			for(int k = 0; k < 4; k++){
				if (ConjuntoDePinos.BluePino[k].getCasa() == 0 ){
					if((cX >= 405 && cX <= 435) && (cY >= 405 && cY <= 435)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else if((cX >= 525 && cX <= 555) && (cY >= 405 && cY <= 435)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else if((cX >= 525 && cX <= 555) && (cY >= 525  && cY <= 555)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else if((cX >= 405 && cX <= 435) && (cY >= 525 && cY <= 555)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else{

					} 
				}

				else{
					aux = pPath.getBlue()[ConjuntoDePinos.BluePino[k].getCasa() - 1];

				}

				if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
					PinoRetorno = ConjuntoDePinos.BluePino[k];
					break;
				}


			}
			break;

		case 2: //Rodada do Amarelo


			for(int k = 0; k < 4; k++){
				if (ConjuntoDePinos.YellowPino[k].getCasa() == 0 ){
					if((cX >= 45 && cX <= 75) && (cY >= 405 && cY <= 435)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else if((cX >= 165 && cX <= 195) && (cY >= 405 && cY <= 435)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else if((cX >= 165 && cX <= 195) && (cY >= 525  && cY <= 555)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else if((cX >= 45 && cX <= 75) && (cY >= 525 && cY <= 555)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else{

					} 
				}

				else{
					aux = pPath.getYellow()[ConjuntoDePinos.YellowPino[k].getCasa() - 1];

				}

				if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
					PinoRetorno = ConjuntoDePinos.YellowPino[k];
					break;
				}



			}
			break;

		case 3: //Rodada do Verde


			for(int k = 0; k < 4; k++){
				if (ConjuntoDePinos.GreenPino[k].getCasa() == 0 ){
					if((cX >= 45 && cX <= 75) && (cY >= 45 && cY <= 75)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else if((cX >= 165 && cX <= 195) && (cY >= 45 && cY <= 85)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else if((cX >= 165 && cX <= 195) && (cY >= 165  && cY <= 195)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else if((cX >= 45 && cX <= 75) && (cY >= 165 && cY <= 195)){
						aux = CheckCoordinates(pPath, cX, cY);
					}
					else{

					} 
				}

				else{
					aux = pPath.getGreen()[ConjuntoDePinos.GreenPino[k].getCasa() - 1];

				}

				if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
					PinoRetorno = ConjuntoDePinos.GreenPino[k];
					break;
				}

			}

			break;

		}
		return PinoRetorno;
	}

	private House[] PinoToArrayHouse(Color cor){
		Path pPath = new Path();
		if(cor == Color.red)
			return pPath.getRed();
		else if(cor == Color.blue)
			return pPath.getBlue();
		else if(cor == Color.yellow)
			return pPath.getYellow();
		else if(cor == Color.green)
			return pPath.getGreen();
		else{
			return null;
		}
	}

	public void JustDoIt(){
		int setCasa = -1;

		if(this.mPino != null){
			if(this.mPino.getCasa() == 0){
				if(RegraDoTiraCinco(this.mDado, this.mPino) == true){
					setCasa = 1;
				}
			}
			else{
				if(RegraDoMovimentoFinal(this.mDado, this.mPino) == true){
					setCasa = this.mPino.getCasa() + this.mDado;
				}
				else{
					setCasa = this.mPino.getCasa();
				}
			}
			if(RegraDaCaptura(this.mPino) != null){
				RegraDaCaptura(this.mPino).setCasa(0);
			}
			if(setCasa >= 0){
				this.mPino.setCasa(setCasa);
				Board.round++;
			}

		}

	}

	private boolean RegraDoTiraCinco(int nDado, PinoEstruturado mPino){
		System.out.printf("OK1!\n");
		if(nDado == 5){
			return true;
		}

		else{
			return false;
		}
	}

	private boolean RegraDoMovimentoFinal(int nDado, PinoEstruturado mPino){

		if((mPino.getCasa()+mDado) > 59){
			System.out.printf("OK2!\n");
			return false;
		}
		else{

			return true;
		}

	}

	public PinoEstruturado RegraDaCaptura(PinoEstruturado mPino){
		Path pPath = new Path();

		for(int i = 0; i < 4; i++){
			if(mPino.getColor() != Color.red){

				if(mPino.getColor() == Color.blue){

					for(int j = 0 ; j < 52; j++){

						if((pPath.getBlue()[mPino.getCasa()].getline() == pPath.getRed()[j].getline()) && (pPath.getBlue()[mPino.getCasa()].getcolumn() == pPath.getRed()[j].getcolumn())){
							for(int k = 0; k < 4; k++){
								if(ConjuntoDePinos.RedPino[k].getCasa() == (j+1)){
									return ConjuntoDePinos.RedPino[k];
								}
							}
						}

					}

				}

				else if(mPino.getColor() == Color.yellow){

					for(int j = 0 ; j < 52; j++){

						if((pPath.getYellow()[mPino.getCasa()].getline() == pPath.getRed()[j].getline()) && (pPath.getYellow()[mPino.getCasa()].getcolumn() == pPath.getRed()[j].getcolumn())){
							for(int k = 0; k < 4; k++){
								if(ConjuntoDePinos.RedPino[k].getCasa() == (j+1)){
									return ConjuntoDePinos.RedPino[k];
								}
							}
						}

					}

				}

				else{// cor do pino a ser comido: verde

					for(int j = 0 ; j < 52; j++){

						if((pPath.getGreen()[mPino.getCasa()].getline() == pPath.getRed()[j].getline()) && (pPath.getGreen()[mPino.getCasa()].getcolumn() == pPath.getRed()[j].getcolumn())){
							for(int k = 0; k < 4; k++){
								if(ConjuntoDePinos.RedPino[k].getCasa() == (j+1)){
									return ConjuntoDePinos.RedPino[k];
								}
							}
						}

					}

				}

			}

			if(mPino.getColor() != Color.blue){

				if(mPino.getColor() == Color.yellow){

					for(int j = 0 ; j < 52; j++){

						if((pPath.getYellow()[mPino.getCasa()].getline() == pPath.getBlue()[j].getline()) && (pPath.getYellow()[mPino.getCasa()].getcolumn() == pPath.getBlue()[j].getcolumn())){
							for(int k = 0; k < 4; k++){
								if(ConjuntoDePinos.BluePino[k].getCasa() == (j+1)){
									return ConjuntoDePinos.BluePino[k];
								}
							}
						}

					}

				}

				else if(mPino.getColor() == Color.green){

					for(int j = 0 ; j < 52; j++){

						if((pPath.getGreen()[mPino.getCasa()].getline() == pPath.getBlue()[j].getline()) && (pPath.getGreen()[mPino.getCasa()].getcolumn() == pPath.getBlue()[j].getcolumn())){
							for(int k = 0; k < 4; k++){
								if(ConjuntoDePinos.BluePino[k].getCasa() == (j+1)){
									return ConjuntoDePinos.BluePino[k];
								}
							}
						}

					}

				}

				else{// cor do pino a ser comido: vermelho

					for(int j = 0 ; j < 52; j++){

						if((pPath.getRed()[mPino.getCasa()].getline() == pPath.getBlue()[j].getline()) && (pPath.getRed()[mPino.getCasa()].getcolumn() == pPath.getBlue()[j].getcolumn())){
							for(int k = 0; k < 4; k++){
								if(ConjuntoDePinos.BluePino[k].getCasa() == (j+1)){
									return ConjuntoDePinos.BluePino[k];
								}
							}
						}

					}

				}

			}

			if(mPino.getColor() != Color.yellow){

				if(mPino.getColor() == Color.green){

					for(int j = 0 ; j < 52; j++){

						if((pPath.getGreen()[mPino.getCasa()].getline() == pPath.getYellow()[j].getline()) && (pPath.getGreen()[mPino.getCasa()].getcolumn() == pPath.getYellow()[j].getcolumn())){
							for(int k = 0; k < 4; k++){
								if(ConjuntoDePinos.YellowPino[k].getCasa() == (j+1)){
									return ConjuntoDePinos.YellowPino[k];
								}
							}
						}

					}

				}

				else if(mPino.getColor() == Color.red){

					for(int j = 0 ; j < 52; j++){

						if((pPath.getRed()[mPino.getCasa()].getline() == pPath.getYellow()[j].getline()) && (pPath.getRed()[mPino.getCasa()].getcolumn() == pPath.getYellow()[j].getcolumn())){
							for(int k = 0; k < 4; k++){
								if(ConjuntoDePinos.YellowPino[k].getCasa() == (j+1)){
									return ConjuntoDePinos.YellowPino[k];
								}
							}
						}

					}

				}

				else{// cor do pino a ser comido: azul

					for(int j = 0 ; j < 52; j++){

						if((pPath.getBlue()[mPino.getCasa()].getline() == pPath.getYellow()[j].getline()) && (pPath.getBlue()[mPino.getCasa()].getcolumn() == pPath.getYellow()[j].getcolumn())){
							for(int k = 0; k < 4; k++){
								if(ConjuntoDePinos.YellowPino[k].getCasa() == (j+1)){
									return ConjuntoDePinos.YellowPino[k];
								}
							}
						}

					}

				}

			}

			if(mPino.getColor() != Color.green){

				if(mPino.getColor() == Color.red){

					for(int j = 0 ; j < 52; j++){

						if((pPath.getRed()[mPino.getCasa()].getline() == pPath.getGreen()[j].getline()) && (pPath.getRed()[mPino.getCasa()].getcolumn() == pPath.getGreen()[j].getcolumn())){
							for(int k = 0; k < 4; k++){
								if(ConjuntoDePinos.GreenPino[k].getCasa() == (j+1)){
									return ConjuntoDePinos.GreenPino[k];
								}
							}
						}

					}

				}

				else if (mPino.getColor() == Color.blue){

					for(int j = 0 ; j < 52; j++){

						if((pPath.getBlue()[mPino.getCasa()].getline() == pPath.getGreen()[j].getline()) && (pPath.getBlue()[mPino.getCasa()].getcolumn() == pPath.getGreen()[j].getcolumn())){
							for(int k = 0; k < 4; k++){
								if(ConjuntoDePinos.GreenPino[k].getCasa() == (j+1)){
									return ConjuntoDePinos.GreenPino[k];
								}
							}
						}

					}

				}

				else{// cor do pino a ser comido: amarelo

					for(int j = 0 ; j < 52; j++){

						if((pPath.getYellow()[mPino.getCasa()].getline() == pPath.getGreen()[j].getline()) && (pPath.getYellow()[mPino.getCasa()].getcolumn() == pPath.getGreen()[j].getcolumn())){
							for(int k = 0; k < 4; k++){
								if(ConjuntoDePinos.GreenPino[k].getCasa() == (j+1)){
									return ConjuntoDePinos.GreenPino[k];
								}
							}
						}

					}

				}

			}
		}
		return null;
	}

}
