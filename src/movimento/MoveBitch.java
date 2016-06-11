package movimento;

import java.awt.Color;
import grafica.Board;

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
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.RedPino[k];
							break;
						}
					}
					else if((cX >= 525 && cX <= 555) && (cY >= 45 && cY <= 75)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.RedPino[k];
							break;
						}
					}
					else if((cX >= 525 && cX <= 555) && (cY >= 165  && cY <= 195)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.RedPino[k];
							break;
						}
					}
					else if((cX >= 405 && cX <= 435) && (cY >= 165 && cY <= 195)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.RedPino[k];
							break;
						}
					}
					/*
					else{
						System.out.println("Else - 0: CoordToPino!\n");
					} */
				}

				else{
					aux = pPath.getRed()[ConjuntoDePinos.RedPino[k].getCasa() - 1];
					if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
						PinoRetorno = ConjuntoDePinos.RedPino[k];
						break;
					}

				}

			}

			break;

		case 1: //Rodada do Azul


			for(int k = 0; k < 4; k++){
				if (ConjuntoDePinos.BluePino[k].getCasa() == 0 ){
					if((cX >= 405 && cX <= 435) && (cY >= 405 && cY <= 435)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.BluePino[k];
							break;
						}
					}
					else if((cX >= 525 && cX <= 555) && (cY >= 405 && cY <= 435)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.BluePino[k];
							break;
						}
					}
					else if((cX >= 525 && cX <= 555) && (cY >= 525  && cY <= 555)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.BluePino[k];
							break;
						}
					}
					else if((cX >= 405 && cX <= 435) && (cY >= 525 && cY <= 555)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.BluePino[k];
							break;
						}
					}
					/*
					else{
						System.out.println("Else - 1: CoordToPino!\n");
					} */
				}

				else{
					aux = pPath.getBlue()[ConjuntoDePinos.BluePino[k].getCasa() - 1];
					if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
						PinoRetorno = ConjuntoDePinos.BluePino[k];
						break;
					}

				}

			}
			break;

		case 2: //Rodada do Amarelo


			for(int k = 0; k < 4; k++){
				if (ConjuntoDePinos.YellowPino[k].getCasa() == 0 ){
					if((cX >= 45 && cX <= 75) && (cY >= 405 && cY <= 435)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.YellowPino[k];
							break;
						}
					}
					else if((cX >= 165 && cX <= 195) && (cY >= 405 && cY <= 435)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.YellowPino[k];
							break;
						}
					}
					else if((cX >= 165 && cX <= 195) && (cY >= 525  && cY <= 555)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.YellowPino[k];
							break;
						}
					}
					else if((cX >= 45 && cX <= 75) && (cY >= 525 && cY <= 555)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.YellowPino[k];
							break;
						}
					}/*
					else{
						System.out.println("Else - 2: CoordToPino!\n");
					} */
				}

				else{
					aux = pPath.getYellow()[ConjuntoDePinos.YellowPino[k].getCasa() - 1];
					if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
						PinoRetorno = ConjuntoDePinos.YellowPino[k];
						break;
					}

				}

			}
			break;

		case 3: //Rodada do Verde


			for(int k = 0; k < 4; k++){
				if (ConjuntoDePinos.GreenPino[k].getCasa() == 0 ){
					if((cX >= 45 && cX <= 75) && (cY >= 45 && cY <= 75)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.GreenPino[k];
							break;
						}
					}
					else if((cX >= 165 && cX <= 195) && (cY >= 45 && cY <= 85)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.GreenPino[k];
							break;
						}
					}
					else if((cX >= 165 && cX <= 195) && (cY >= 165  && cY <= 195)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.GreenPino[k];
							break;
						}
					}
					else if((cX >= 45 && cX <= 75) && (cY >= 165 && cY <= 195)){
						aux = CheckCoordinates(pPath, cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.GreenPino[k];
							break;
						}
					}/*
					else{
						System.out.println("Else - 3: CoordToPino!\n");
					} */
				}

				else{
					aux = pPath.getGreen()[ConjuntoDePinos.GreenPino[k].getCasa() - 1];
					if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
						PinoRetorno = ConjuntoDePinos.GreenPino[k];
						break;
					}

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

	public boolean JustDoIt(){
		int setCasa = -1;

		if(this.mPino != null){
			if(this.mPino.getCasa() == 0){
				if(RegraDoTiraCinco(this.mDado, this.mPino) == true){
					//setCasa = 1;
					RegraDaCapturaSaida(this.mPino);
					Board.round++;
					return true;
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
			if(RegraDaCaptura(this.mDado-1,this.mPino) != null){
				RegraDaCaptura(this.mDado-1,this.mPino).setCasa(0);
			}
			if(setCasa >= 0){
				this.mPino.setCasa(setCasa);
				Board.round++;
				return true;
			}

		}

		return false;
		/*

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
			if(RegraDaBarreira(this.mPino,this.mDado) == false){
				if(this.mPino.getCasa() != 0){
					setCasa = this.mPino.getCasa() + this.mDado;
				}
			}
			else{
				if(RegraDaCaptura(this.mPino) != null){
					RegraDaCaptura(this.mPino).setCasa(0);
				}
				setCasa = this.mPino.getCasa();
			}
			if(setCasa >= 0){
				this.mPino.setCasa(setCasa);
				Board.round++;
				return true;
			}
		}

		return false;
		 */
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

	private void RegraDaCapturaSaida(PinoEstruturado mPino){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if(mPino.getColor() != Color.red){
					if(mPino.getColor() == Color.blue){
						if(ConjuntoDePinos.RedPino[j].getCasa() == 14){
							ConjuntoDePinos.RedPino[j].setCasa(0);
						}
					}
					else if(mPino.getColor() == Color.yellow){
						if(ConjuntoDePinos.RedPino[j].getCasa() == 27){
							ConjuntoDePinos.RedPino[j].setCasa(0);
						}
					}
					else if(mPino.getColor() == Color.green){
						if(ConjuntoDePinos.RedPino[j].getCasa() == 40){
							ConjuntoDePinos.RedPino[j].setCasa(0);
						}
					}
				}
				if(mPino.getColor() != Color.blue){
					if(mPino.getColor() == Color.yellow){
						if(ConjuntoDePinos.BluePino[j].getCasa() == 14){
							ConjuntoDePinos.BluePino[j].setCasa(0);
						}
					}
					else if(mPino.getColor() == Color.green){
						if(ConjuntoDePinos.BluePino[j].getCasa() == 27){
							ConjuntoDePinos.BluePino[j].setCasa(0);
						}
					}
					else if(mPino.getColor() == Color.red){
						if(ConjuntoDePinos.BluePino[j].getCasa() == 40){
							ConjuntoDePinos.BluePino[j].setCasa(0);
						}
					}
				}
				if(mPino.getColor() != Color.yellow){
					if(mPino.getColor() == Color.green){
						if(ConjuntoDePinos.YellowPino[j].getCasa() == 14){
							ConjuntoDePinos.YellowPino[j].setCasa(0);
						}
					}
					else if(mPino.getColor() == Color.red){
						if(ConjuntoDePinos.YellowPino[j].getCasa() == 27){
							ConjuntoDePinos.YellowPino[j].setCasa(0);
						}
					}
					else if(mPino.getColor() == Color.blue){
						if(ConjuntoDePinos.YellowPino[j].getCasa() == 40){
							ConjuntoDePinos.YellowPino[j].setCasa(0);
						}
					}
				}
				if(mPino.getColor() != Color.green){
					if(mPino.getColor() == Color.red){
						if(ConjuntoDePinos.GreenPino[j].getCasa() == 14){
							ConjuntoDePinos.GreenPino[j].setCasa(0);
						}
					}
					else if(mPino.getColor() == Color.blue){
						if(ConjuntoDePinos.GreenPino[j].getCasa() == 27){
							ConjuntoDePinos.GreenPino[j].setCasa(0);
						}
					}
					else if(mPino.getColor() == Color.yellow){
						if(ConjuntoDePinos.GreenPino[j].getCasa() == 40){
							ConjuntoDePinos.GreenPino[j].setCasa(0);
						}
					}
				}
			}
			mPino.setCasa(1);
		}
	}
	
	private PinoEstruturado RegraDaCaptura(int nDado, PinoEstruturado mPino){
		Path pPath = new Path();

		for(int i = 0; i < 4; i++){
			if(mPino.getColor() != Color.red){

				if(mPino.getColor() == Color.blue){

					for(int j = 0 ; j < 52; j++){
						if((pPath.getBlue()[mPino.getCasa() + nDado].getline() == pPath.getRed()[j].getline()) && (pPath.getBlue()[mPino.getCasa() + nDado].getcolumn() == pPath.getRed()[j].getcolumn())){
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
						if((pPath.getYellow()[mPino.getCasa() + nDado].getline() == pPath.getRed()[j].getline()) && (pPath.getYellow()[mPino.getCasa() + nDado].getcolumn() == pPath.getRed()[j].getcolumn())){
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
						if((pPath.getGreen()[mPino.getCasa() + nDado].getline() == pPath.getRed()[j].getline()) && (pPath.getGreen()[mPino.getCasa() + nDado].getcolumn() == pPath.getRed()[j].getcolumn())){
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
						if((pPath.getYellow()[mPino.getCasa() + nDado].getline() == pPath.getBlue()[j].getline()) && (pPath.getYellow()[mPino.getCasa() + nDado].getcolumn() == pPath.getBlue()[j].getcolumn())){
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
						if((pPath.getGreen()[mPino.getCasa() + nDado].getline() == pPath.getBlue()[j].getline()) && (pPath.getGreen()[mPino.getCasa() + nDado].getcolumn() == pPath.getBlue()[j].getcolumn())){
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
						if((pPath.getRed()[mPino.getCasa() + nDado].getline() == pPath.getBlue()[j].getline()) && (pPath.getRed()[mPino.getCasa() + nDado].getcolumn() == pPath.getBlue()[j].getcolumn())){
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
						if((pPath.getGreen()[mPino.getCasa() + nDado].getline() == pPath.getYellow()[j].getline()) && (pPath.getGreen()[mPino.getCasa() + nDado].getcolumn() == pPath.getYellow()[j].getcolumn())){
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
						if((pPath.getRed()[mPino.getCasa() + nDado].getline() == pPath.getYellow()[j].getline()) && (pPath.getRed()[mPino.getCasa() + nDado].getcolumn() == pPath.getYellow()[j].getcolumn())){
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
						if((pPath.getBlue()[mPino.getCasa() + nDado].getline() == pPath.getYellow()[j].getline()) && (pPath.getBlue()[mPino.getCasa() + nDado].getcolumn() == pPath.getYellow()[j].getcolumn())){
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
						if((pPath.getRed()[mPino.getCasa() + nDado].getline() == pPath.getGreen()[j].getline()) && (pPath.getRed()[mPino.getCasa() + nDado].getcolumn() == pPath.getGreen()[j].getcolumn())){
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
						if((pPath.getBlue()[mPino.getCasa() + nDado].getline() == pPath.getGreen()[j].getline()) && (pPath.getBlue()[mPino.getCasa() + nDado].getcolumn() == pPath.getGreen()[j].getcolumn())){
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
						if((pPath.getYellow()[mPino.getCasa() + nDado].getline() == pPath.getGreen()[j].getline()) && (pPath.getYellow()[mPino.getCasa() + nDado].getcolumn() == pPath.getGreen()[j].getcolumn())){
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

	private boolean RegraDaBarreira(PinoEstruturado mPino , int nDado){
		Path pPath = new Path();

		for(int i = 1; i < nDado; i++){

			if(mPino.getColor() == Color.red){
				for(int j = 0 ; j < 4; j++){
					if((pPath.getRed()[(mPino.getCasa() + i)].getline() == pPath.getRed()[ConjuntoDePinos.RedPino[j].getCasa()].getline()) && (pPath.getRed()[(mPino.getCasa() + i)].getcolumn() == pPath.getRed()[ConjuntoDePinos.RedPino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.RedPino[j]);

					}
					else if((pPath.getRed()[(mPino.getCasa() + i)].getline() == pPath.getBlue()[ConjuntoDePinos.BluePino[j].getCasa()].getline()) && (pPath.getRed()[(mPino.getCasa() + i)].getcolumn() == pPath.getBlue()[ConjuntoDePinos.BluePino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.BluePino[j]);

					}
					else if((pPath.getRed()[(mPino.getCasa() + i)].getline() == pPath.getYellow()[ConjuntoDePinos.YellowPino[j].getCasa()].getline()) && (pPath.getRed()[(mPino.getCasa() + i)].getcolumn() == pPath.getYellow()[ConjuntoDePinos.YellowPino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.YellowPino[j]);

					}
					else if((pPath.getRed()[(mPino.getCasa() + i)].getline() == pPath.getGreen()[ConjuntoDePinos.GreenPino[j].getCasa()].getline()) && (pPath.getRed()[(mPino.getCasa() + i)].getcolumn() == pPath.getGreen()[ConjuntoDePinos.GreenPino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.GreenPino[j]);

					}

				}

			}

			else if(mPino.getColor() == Color.blue){

				for(int j = 0 ; j < 4; j++){
					if((pPath.getBlue()[(mPino.getCasa() + i)].getline() == pPath.getRed()[ConjuntoDePinos.RedPino[j].getCasa()].getline()) && (pPath.getBlue()[(mPino.getCasa() + i)].getcolumn() == pPath.getRed()[ConjuntoDePinos.RedPino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.RedPino[j]);

					}
					else if((pPath.getBlue()[(mPino.getCasa() + i)].getline() == pPath.getBlue()[ConjuntoDePinos.BluePino[j].getCasa()].getline()) && (pPath.getBlue()[(mPino.getCasa() + i)].getcolumn() == pPath.getBlue()[ConjuntoDePinos.BluePino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.BluePino[j]);

					}
					else if((pPath.getBlue()[(mPino.getCasa() + i)].getline() == pPath.getYellow()[ConjuntoDePinos.YellowPino[j].getCasa()].getline()) && (pPath.getBlue()[(mPino.getCasa() + i)].getcolumn() == pPath.getYellow()[ConjuntoDePinos.YellowPino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.YellowPino[j]);

					}
					else if((pPath.getBlue()[(mPino.getCasa() + i)].getline() == pPath.getGreen()[ConjuntoDePinos.GreenPino[j].getCasa()].getline()) && (pPath.getBlue()[(mPino.getCasa() + i)].getcolumn() == pPath.getGreen()[ConjuntoDePinos.GreenPino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.GreenPino[j]);

					}

				}

			}

			else if(mPino.getColor() == Color.yellow){

				for(int j = 0 ; j < 4; j++){
					if((pPath.getYellow()[(mPino.getCasa() + i)].getline() == pPath.getRed()[ConjuntoDePinos.RedPino[j].getCasa()].getline()) && (pPath.getYellow()[(mPino.getCasa() + i)].getcolumn() == pPath.getRed()[ConjuntoDePinos.RedPino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.RedPino[j]);

					}
					else if((pPath.getYellow()[(mPino.getCasa() + i)].getline() == pPath.getBlue()[ConjuntoDePinos.BluePino[j].getCasa()].getline()) && (pPath.getYellow()[(mPino.getCasa() + i)].getcolumn() == pPath.getBlue()[ConjuntoDePinos.BluePino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.BluePino[j]);

					}
					else if((pPath.getYellow()[(mPino.getCasa() + i)].getline() == pPath.getYellow()[ConjuntoDePinos.YellowPino[j].getCasa()].getline()) && (pPath.getYellow()[(mPino.getCasa() + i)].getcolumn() == pPath.getYellow()[ConjuntoDePinos.YellowPino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.YellowPino[j]);

					}
					else if((pPath.getYellow()[(mPino.getCasa() + i)].getline() == pPath.getGreen()[ConjuntoDePinos.GreenPino[j].getCasa()].getline()) && (pPath.getYellow()[(mPino.getCasa() + i)].getcolumn() == pPath.getGreen()[ConjuntoDePinos.GreenPino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.GreenPino[j]);

					}


				}

			}

			else{ //Caso da cor do pino ser verde

				for(int j = 0 ; j < 4; j++){
					if((pPath.getGreen()[(mPino.getCasa() + i)].getline() == pPath.getRed()[ConjuntoDePinos.RedPino[j].getCasa()].getline()) && (pPath.getGreen()[(mPino.getCasa() + i)].getcolumn() == pPath.getRed()[ConjuntoDePinos.RedPino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.RedPino[j]);

					}
					else if((pPath.getGreen()[(mPino.getCasa() + i)].getline() == pPath.getBlue()[ConjuntoDePinos.BluePino[j].getCasa()].getline()) && (pPath.getGreen()[(mPino.getCasa() + i)].getcolumn() == pPath.getBlue()[ConjuntoDePinos.BluePino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.BluePino[j]);

					}
					else if((pPath.getGreen()[(mPino.getCasa() + i)].getline() == pPath.getYellow()[ConjuntoDePinos.YellowPino[j].getCasa()].getline()) && (pPath.getGreen()[(mPino.getCasa() + i)].getcolumn() == pPath.getYellow()[ConjuntoDePinos.YellowPino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.YellowPino[j]);

					}
					else if((pPath.getGreen()[(mPino.getCasa() + i)].getline() == pPath.getGreen()[ConjuntoDePinos.GreenPino[j].getCasa()].getline()) && (pPath.getGreen()[(mPino.getCasa() + i)].getcolumn() == pPath.getGreen()[ConjuntoDePinos.GreenPino[j].getCasa()].getcolumn())){

						return CheckBarrier(ConjuntoDePinos.GreenPino[j]);

					}
				}
			}
		}
		return false;

	}

	private boolean CheckBarrier(PinoEstruturado mPino){
		int OContador = 0;


		for(int i = 0; i < 4 ; i++){
			if(mPino.getColor() == Color.red){
				if(mPino.getCasa() == ConjuntoDePinos.RedPino[i].getCasa()){
					OContador++;
				}
			}
			else if(mPino.getColor() == Color.blue){
				if(mPino.getCasa() == ConjuntoDePinos.BluePino[i].getCasa()){
					OContador++;
				}
			}

			else if(mPino.getColor() == Color.yellow){
				if(mPino.getCasa() == ConjuntoDePinos.YellowPino[i].getCasa()){
					OContador++;
				}
			}

			else if(mPino.getColor() == Color.green){
				if(mPino.getCasa() == ConjuntoDePinos.GreenPino[i].getCasa()){
					OContador++;
				}
			}

			else{
				//Cor nao encontrada
			}

		}

		if(OContador > 1){

			return false;

		}

		return true;
	}

}
