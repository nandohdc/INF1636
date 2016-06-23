package movimento;

import java.awt.Color;
import grafica.Board;
import grafica.Dice;

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
		//Path pPath = new Path();
		PinoEstruturado PinoRetorno = null;
		House aux = null;

		if(Board.round == 4){
			Board.round = 0;
		}

		switch (Board.round){

		case 0: //Rodada do Vermelho

			for(int k = 1; k < 5; k++){
				if (ConjuntoDePinos.getInstancce().getRed(k).getCasa() == 0){
					if((cX >= 405 && cX <= 435) && (cY >= 45 && cY <= 75)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getRed(k);
							break;
						}
					}
					else if((cX >= 525 && cX <= 555) && (cY >= 45 && cY <= 75)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getRed(k);
							break;
						}
					}
					else if((cX >= 525 && cX <= 555) && (cY >= 165  && cY <= 195)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getRed(k);
							break;
						}
					}
					else if((cX >= 405 && cX <= 435) && (cY >= 165 && cY <= 195)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getRed(k);
							break;
						}
					}
					/*
					else{
						System.out.println("Else - 0: CoordToPino!\n");
					} */
				}

				else{
					aux = Path.getInstance().getRed()[ConjuntoDePinos.getInstancce().getRed(k).getCasa() - 1];
					if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
						PinoRetorno = ConjuntoDePinos.getInstancce().getRed(k);
						break;
					}

				}

			}

			break;

		case 1: //Rodada do Azul


			for(int k = 1; k < 5; k++){
				if (ConjuntoDePinos.getInstancce().getBlue(k).getCasa() == 0 ){
					if((cX >= 405 && cX <= 435) && (cY >= 405 && cY <= 435)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getBlue(k);
							break;
						}
					}
					else if((cX >= 525 && cX <= 555) && (cY >= 405 && cY <= 435)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getBlue(k);
							break;
						}
					}
					else if((cX >= 525 && cX <= 555) && (cY >= 525  && cY <= 555)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getBlue(k);
							break;
						}
					}
					else if((cX >= 405 && cX <= 435) && (cY >= 525 && cY <= 555)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getBlue(k);
							break;
						}
					}
					/*
					else{
						System.out.println("Else - 1: CoordToPino!\n");
					} */
				}

				else{
					aux = Path.getInstance().getBlue()[ConjuntoDePinos.getInstancce().getBlue(k).getCasa() - 1];
					if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
						PinoRetorno = ConjuntoDePinos.getInstancce().getBlue(k);
						break;
					}

				}

			}
			break;

		case 2: //Rodada do Amarelo


			for(int k = 1; k < 5; k++){
				if (ConjuntoDePinos.getInstancce().getYellow(k).getCasa() == 0 ){
					if((cX >= 45 && cX <= 75) && (cY >= 405 && cY <= 435)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getYellow(k);
							break;
						}
					}
					else if((cX >= 165 && cX <= 195) && (cY >= 405 && cY <= 435)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getYellow(k);
							break;
						}
					}
					else if((cX >= 165 && cX <= 195) && (cY >= 525  && cY <= 555)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getYellow(k);
							break;
						}
					}
					else if((cX >= 45 && cX <= 75) && (cY >= 525 && cY <= 555)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getYellow(k);
							break;
						}
					}/*
					else{
						System.out.println("Else - 2: CoordToPino!\n");
					} */
				}

				else{
					aux = Path.getInstance().getYellow()[ConjuntoDePinos.getInstancce().getYellow(k).getCasa() - 1];
					if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
						PinoRetorno = ConjuntoDePinos.getInstancce().getYellow(k);
						break;
					}

				}

			}
			break;

		case 3: //Rodada do Verde


			for(int k = 1; k < 5; k++){
				if (ConjuntoDePinos.getInstancce().getGreen(k).getCasa() == 0 ){
					if((cX >= 45 && cX <= 75) && (cY >= 45 && cY <= 75)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getGreen(k);
							break;
						}
					}
					else if((cX >= 165 && cX <= 195) && (cY >= 45 && cY <= 85)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getGreen(k);
							break;
						}
					}
					else if((cX >= 165 && cX <= 195) && (cY >= 165  && cY <= 195)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getGreen(k);
							break;
						}
					}
					else if((cX >= 45 && cX <= 75) && (cY >= 165 && cY <= 195)){
						aux = CheckCoordinates(Path.getInstance(), cX, cY);
						if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
							PinoRetorno = ConjuntoDePinos.getInstancce().getGreen(k);
							break;
						}
					}/*
					else{
						System.out.println("Else - 3: CoordToPino!\n");
					} */
				}

				else{
					aux = Path.getInstance().getGreen()[ConjuntoDePinos.getInstancce().getGreen(k).getCasa() - 1];
					if((cX >= aux.getline() && cX<= aux.getline()+40) && (cY >= aux.getcolumn() && cY <= aux.getcolumn()+40)){
						PinoRetorno = ConjuntoDePinos.getInstancce().getGreen(k);
						break;
					}

				}

			}

			break;

		}
		return PinoRetorno;
	}

	private House[] PinoToArrayHouse(Color cor){
		;
		if(cor == Color.red)
			return Path.getInstance().getRed();
		else if(cor == Color.blue)
			return Path.getInstance().getBlue();
		else if(cor == Color.yellow)
			return Path.getInstance().getYellow();
		else if(cor == Color.green)
			return Path.getInstance().getGreen();
		else{
			return null;
		}
	}

	public boolean JustDoIt(){
		int setCasa = -1;

		if(this.mDado == 0){
			return false;
		}

		if(CheckJogadaPossivel(this.mPino, this.mDado) == false){
			Board.round++;
			return true;
		}
		else{
			if(this.mDado != 6){
				ConjuntoDePinos.amarelo6 = 0;
				ConjuntoDePinos.azul6 = 0;
				ConjuntoDePinos.verde6 = 0;
				ConjuntoDePinos.vermelho6 = 0;
			}
			if(this.mPino != null){
				if(this.mPino.getCasa() == 0){
					if(RegraDoTiraCinco(this.mDado) == true){
						RegraDaCapturaSaida(this.mPino);
						Board.round++;
						Dice.getInstance().setRandNum(0);
						return true;
					}
				}
				else{

					if(RegraDoMovimentoFinal(this.mDado, this.mPino) == true){
						setCasa = this.mPino.getCasa() + this.mDado;
						if(setCasa == 59){
							this.mPino.setCasa(setCasa);
							Dice.getInstance().setRandNum(10);					//setar dado igual a 10
							return true;
						}
					}

					else{
						setCasa = this.mPino.getCasa();

					}

					if(this.mDado == 6){
						if(RegraDoTiraSeis(this.mDado, this.mPino) != 0){

							if(ConjuntoDePinos.vermelho6 < 2 && ConjuntoDePinos.azul6 < 2 && ConjuntoDePinos.amarelo6 < 2 && ConjuntoDePinos.verde6 < 2){

								this.mPino.setCasa(this.mPino.getCasa() + RegraDoTiraSeis(this.mDado, this.mPino));

								if(this.mPino.getColor() == Color.red){
									ConjuntoDePinos.vermelho6++;
								}

								else if(this.mPino.getColor() == Color.blue){
									ConjuntoDePinos.azul6++;
								}

								else if(this.mPino.getColor() == Color.yellow){
									ConjuntoDePinos.amarelo6++;
								}

								else { //if(this.mPino.getColor() == Color.green)
									ConjuntoDePinos.verde6++;
								}

								/*if(RegraDaBarreira(this.mPino, this.mDado) == false){
									return false;
								}

								else{*/

								if(RegraDoShelter(this.mPino, this.mDado-1) == true){
									setCasa = this.mPino.getCasa() + this.mDado;
								}

								else{ 

									if(RegraDaCaptura(this.mDado-1,this.mPino) != null){
										RegraDaCaptura(this.mDado-1,this.mPino).setCasa(0);
										this.mPino.setCasa(setCasa);
										Dice.getInstance().setRandNum(20);					//setar dado igual a 20
										return true;
									}
								}
								//}
								Dice.getInstance().setRandNum(0);
								return true;
							}
							else{

								System.out.println("tamo ai sim caralho");
								this.mPino.setCasa(0);
								if(this.mPino.getColor() == Color.red){
									ConjuntoDePinos.vermelho6 = 0;
								}

								else if(this.mPino.getColor() == Color.blue){
									ConjuntoDePinos.azul6 = 0;
								}

								else if(this.mPino.getColor() == Color.yellow){
									ConjuntoDePinos.amarelo6 = 0;
								}

								else{ // if(this.mPino.getColor() == Color.green)
									ConjuntoDePinos.verde6 = 0;
								}

								Board.round++;
								Dice.getInstance().setRandNum(0);
								return true;
							}
						}
						else{
							System.out.println("nem to aqui");
							this.mPino.setCasa(0);

							if(this.mPino.getColor() == Color.red){
								ConjuntoDePinos.vermelho6 = 0;
							}

							else if(this.mPino.getColor() == Color.blue){
								ConjuntoDePinos.azul6 = 0;
							}

							else if(this.mPino.getColor() == Color.yellow){
								ConjuntoDePinos.amarelo6 = 0;
							}

							else{ // if(this.mPino.getColor() == Color.green)
								ConjuntoDePinos.verde6 = 0;
							}

							Board.round++;
							Dice.getInstance().setRandNum(0);
							return true;
						}

					}
				}
				/*if(RegraDaBarreira(this.mPino, this.mDado) == false){
					return false;
				}

				else{*/

				if(RegraDoShelter(this.mPino, this.mDado-1) == true){
					setCasa = this.mPino.getCasa() + this.mDado;
				}

				else{ 

					if(RegraDaCaptura(this.mDado-1,this.mPino) != null){
						RegraDaCaptura(this.mDado-1,this.mPino).setCasa(0);
						this.mPino.setCasa(setCasa);
						Dice.getInstance().setRandNum(20);					//setar dado igual a 20
						return true;
					}
				}
				//}
				if(setCasa >= 0){
					this.mPino.setCasa(setCasa);
					Board.round++;
					Dice.getInstance().setRandNum(0);
					return true;
				}

			}
		}
		return false;

	}

	private boolean RegraDoTiraCinco(int nDado){
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
			for(int j = 1; j < 5; j++){
				if(mPino.getColor() != Color.red){
					if(mPino.getColor() == Color.blue){
						if(ConjuntoDePinos.getInstancce().getRed(j).getCasa() == 14){
							ConjuntoDePinos.getInstancce().getRed(j).setCasa(0);
							Dice.getInstance().setRandNum(20);
						}
					}
					else if(mPino.getColor() == Color.yellow){
						if(ConjuntoDePinos.getInstancce().getRed(j).getCasa() == 27){
							ConjuntoDePinos.getInstancce().getRed(j).setCasa(0);
							Dice.getInstance().setRandNum(20);
						}
					}
					else if(mPino.getColor() == Color.green){
						if(ConjuntoDePinos.getInstancce().getRed(j).getCasa() == 40){
							ConjuntoDePinos.getInstancce().getRed(j).setCasa(0);
							Dice.getInstance().setRandNum(20);
						}
					}
				}
				if(mPino.getColor() != Color.blue){
					if(mPino.getColor() == Color.yellow){
						if(ConjuntoDePinos.getInstancce().getBlue(j).getCasa() == 14){
							ConjuntoDePinos.getInstancce().getBlue(j).setCasa(0);
							Dice.getInstance().setRandNum(20);
						}
					}
					else if(mPino.getColor() == Color.green){
						if(ConjuntoDePinos.getInstancce().getBlue(j).getCasa() == 27){
							ConjuntoDePinos.getInstancce().getBlue(j).setCasa(0);
							Dice.getInstance().setRandNum(20);
						}
					}
					else if(mPino.getColor() == Color.red){
						if(ConjuntoDePinos.getInstancce().getBlue(j).getCasa() == 40){
							ConjuntoDePinos.getInstancce().getBlue(j).setCasa(0);
							Dice.getInstance().setRandNum(20);
						}
					}
				}
				if(mPino.getColor() != Color.yellow){
					if(mPino.getColor() == Color.green){
						if(ConjuntoDePinos.getInstancce().getYellow(j).getCasa() == 14){
							ConjuntoDePinos.getInstancce().getYellow(j).setCasa(0);
							Dice.getInstance().setRandNum(20);
						}
					}
					else if(mPino.getColor() == Color.red){
						if(ConjuntoDePinos.getInstancce().getYellow(j).getCasa() == 27){
							ConjuntoDePinos.getInstancce().getYellow(j).setCasa(0);
							Dice.getInstance().setRandNum(20);
						}
					}
					else if(mPino.getColor() == Color.blue){
						if(ConjuntoDePinos.getInstancce().getYellow(j).getCasa() == 40){
							ConjuntoDePinos.getInstancce().getYellow(j).setCasa(0);
							Dice.getInstance().setRandNum(20);
						}
					}
				}
				if(mPino.getColor() != Color.green){
					if(mPino.getColor() == Color.red){
						if(ConjuntoDePinos.getInstancce().getGreen(j).getCasa() == 14){
							ConjuntoDePinos.getInstancce().getGreen(j).setCasa(0);
							Dice.getInstance().setRandNum(20);
						}
					}
					else if(mPino.getColor() == Color.blue){
						if(ConjuntoDePinos.getInstancce().getGreen(j).getCasa() == 27){
							ConjuntoDePinos.getInstancce().getGreen(j).setCasa(0);
							Dice.getInstance().setRandNum(20);
						}
					}
					else if(mPino.getColor() == Color.yellow){
						if(ConjuntoDePinos.getInstancce().getGreen(j).getCasa() == 40){
							ConjuntoDePinos.getInstancce().getGreen(j).setCasa(0);
							Dice.getInstance().setRandNum(20);
						}
					}
				}
			}
			mPino.setCasa(1);
		}
	}

	private PinoEstruturado RegraDaCaptura(int nDado, PinoEstruturado mPino){

		for(int i = 0; i < 4; i++){
			if(mPino.getColor() != Color.red){

				if(mPino.getColor() == Color.blue){

					for(int j = 0 ; j < 52; j++){
						if((Path.getInstance().getBlue()[mPino.getCasa() + nDado].getline() == Path.getInstance().getRed()[j].getline()) && (Path.getInstance().getBlue()[mPino.getCasa() + nDado].getcolumn() == Path.getInstance().getRed()[j].getcolumn())){
							for(int k = 1; k < 5; k++){
								if(ConjuntoDePinos.getInstancce().getRed(k).getCasa() == (j+1)){
									return ConjuntoDePinos.getInstancce().getRed(k);
								}
							}
						}

					}

				}

				else if(mPino.getColor() == Color.yellow){

					for(int j = 0 ; j < 52; j++){
						if((Path.getInstance().getYellow()[mPino.getCasa() + nDado].getline() == Path.getInstance().getRed()[j].getline()) && (Path.getInstance().getYellow()[mPino.getCasa() + nDado].getcolumn() == Path.getInstance().getRed()[j].getcolumn())){
							for(int k = 1; k < 5; k++){
								if(ConjuntoDePinos.getInstancce().getRed(k).getCasa() == (j+1)){
									return ConjuntoDePinos.getInstancce().getRed(k);
								}
							}
						}

					}

				}

				else{// cor do pino a ser comido: verde

					for(int j = 0 ; j < 52; j++){
						if((Path.getInstance().getGreen()[mPino.getCasa() + nDado].getline() == Path.getInstance().getRed()[j].getline()) && (Path.getInstance().getGreen()[mPino.getCasa() + nDado].getcolumn() == Path.getInstance().getRed()[j].getcolumn())){
							for(int k = 1; k < 5; k++){
								if(ConjuntoDePinos.getInstancce().getRed(k).getCasa() == (j+1)){
									return ConjuntoDePinos.getInstancce().getRed(k);
								}
							}
						}

					}

				}

			}

			if(mPino.getColor() != Color.blue){

				if(mPino.getColor() == Color.yellow){

					for(int j = 0 ; j < 52; j++){
						if((Path.getInstance().getYellow()[mPino.getCasa() + nDado].getline() == Path.getInstance().getBlue()[j].getline()) && (Path.getInstance().getYellow()[mPino.getCasa() + nDado].getcolumn() == Path.getInstance().getBlue()[j].getcolumn())){
							for(int k = 1; k < 5; k++){
								if(ConjuntoDePinos.getInstancce().getBlue(k).getCasa() == (j+1)){
									return ConjuntoDePinos.getInstancce().getBlue(k);
								}
							}
						}

					}

				}

				else if(mPino.getColor() == Color.green){

					for(int j = 0 ; j < 52; j++){
						if((Path.getInstance().getGreen()[mPino.getCasa() + nDado].getline() == Path.getInstance().getBlue()[j].getline()) && (Path.getInstance().getGreen()[mPino.getCasa() + nDado].getcolumn() == Path.getInstance().getBlue()[j].getcolumn())){
							for(int k = 1; k < 5; k++){
								if(ConjuntoDePinos.getInstancce().getBlue(k).getCasa() == (j+1)){
									return ConjuntoDePinos.getInstancce().getBlue(k);
								}
							}
						}

					}

				}

				else{// cor do pino a ser comido: vermelho

					for(int j = 0 ; j < 52; j++){
						if((Path.getInstance().getRed()[mPino.getCasa() + nDado].getline() == Path.getInstance().getBlue()[j].getline()) && (Path.getInstance().getRed()[mPino.getCasa() + nDado].getcolumn() == Path.getInstance().getBlue()[j].getcolumn())){
							for(int k = 1; k < 5; k++){
								if(ConjuntoDePinos.getInstancce().getBlue(k).getCasa() == (j+1)){
									return ConjuntoDePinos.getInstancce().getBlue(k);
								}
							}
						}

					}

				}

			}

			if(mPino.getColor() != Color.yellow){

				if(mPino.getColor() == Color.green){

					for(int j = 0 ; j < 52; j++){
						if((Path.getInstance().getGreen()[mPino.getCasa() + nDado].getline() == Path.getInstance().getYellow()[j].getline()) && (Path.getInstance().getGreen()[mPino.getCasa() + nDado].getcolumn() == Path.getInstance().getYellow()[j].getcolumn())){
							for(int k = 1; k < 5; k++){
								if(ConjuntoDePinos.getInstancce().getYellow(k).getCasa() == (j+1)){
									return ConjuntoDePinos.getInstancce().getYellow(k);
								}
							}
						}

					}

				}

				else if(mPino.getColor() == Color.red){

					for(int j = 0 ; j < 52; j++){
						if((Path.getInstance().getRed()[mPino.getCasa() + nDado].getline() == Path.getInstance().getYellow()[j].getline()) && (Path.getInstance().getRed()[mPino.getCasa() + nDado].getcolumn() == Path.getInstance().getYellow()[j].getcolumn())){
							for(int k = 1; k < 5; k++){
								if(ConjuntoDePinos.getInstancce().getYellow(k).getCasa() == (j+1)){
									return ConjuntoDePinos.getInstancce().getYellow(k);
								}
							}
						}

					}

				}

				else{// cor do pino a ser comido: azul

					for(int j = 0 ; j < 52; j++){
						if((Path.getInstance().getBlue()[mPino.getCasa() + nDado].getline() == Path.getInstance().getYellow()[j].getline()) && (Path.getInstance().getBlue()[mPino.getCasa() + nDado].getcolumn() == Path.getInstance().getYellow()[j].getcolumn())){
							for(int k = 1; k < 5; k++){
								if(ConjuntoDePinos.getInstancce().getYellow(k).getCasa() == (j+1)){
									return ConjuntoDePinos.getInstancce().getYellow(k);
								}
							}
						}

					}

				}

			}

			if(mPino.getColor() != Color.green){

				if(mPino.getColor() == Color.red){

					for(int j = 0 ; j < 52; j++){
						if((Path.getInstance().getRed()[mPino.getCasa() + nDado].getline() == Path.getInstance().getGreen()[j].getline()) && (Path.getInstance().getRed()[mPino.getCasa() + nDado].getcolumn() == Path.getInstance().getGreen()[j].getcolumn())){
							for(int k = 1; k < 5; k++){
								if(ConjuntoDePinos.getInstancce().getGreen(k).getCasa() == (j+1)){
									return ConjuntoDePinos.getInstancce().getGreen(k);
								}
							}
						}

					}

				}

				else if (mPino.getColor() == Color.blue){

					for(int j = 0 ; j < 52; j++){
						if((Path.getInstance().getBlue()[mPino.getCasa() + nDado].getline() == Path.getInstance().getGreen()[j].getline()) && (Path.getInstance().getBlue()[mPino.getCasa() + nDado].getcolumn() == Path.getInstance().getGreen()[j].getcolumn())){
							for(int k = 1; k < 5; k++){
								if(ConjuntoDePinos.getInstancce().getGreen(k).getCasa() == (j+1)){
									return ConjuntoDePinos.getInstancce().getGreen(k);
								}
							}
						}

					}

				}

				else{// cor do pino a ser comido: amarelo

					for(int j = 0 ; j < 52; j++){
						if((Path.getInstance().getYellow()[mPino.getCasa() + nDado].getline() == Path.getInstance().getGreen()[j].getline()) && (Path.getInstance().getYellow()[mPino.getCasa() + nDado].getcolumn() == Path.getInstance().getGreen()[j].getcolumn())){
							for(int k = 1; k < 5; k++){
								if(ConjuntoDePinos.getInstancce().getGreen(k).getCasa() == (j+1)){
									return ConjuntoDePinos.getInstancce().getGreen(k);
								}
							}
						}

					}

				}

			}
		}
		return null;
	}

	private boolean CheckBarrier(PinoEstruturado mPino){
		int OContador = 0;


		for(int i = 1; i < 5 ; i++){
			if(mPino.getColor() == Color.red){
				if(mPino.getCasa() == ConjuntoDePinos.getInstancce().getRed(i).getCasa()){
					OContador++;
				}
			}
			else if(mPino.getColor() == Color.blue){
				if(mPino.getCasa() == ConjuntoDePinos.getInstancce().getBlue(i).getCasa()){
					OContador++;
				}
			}

			else if(mPino.getColor() == Color.yellow){
				if(mPino.getCasa() == ConjuntoDePinos.getInstancce().getYellow(i).getCasa()){
					OContador++;
				}
			}

			else{ // if(mPino.getColor() == Color.green)
				if(mPino.getCasa() == ConjuntoDePinos.getInstancce().getGreen(i).getCasa()){
					OContador++;
				}
			}

		}

		if(OContador > 1){

			return false;

		}

		return true;
	}

	private boolean RegraDaBarreira(PinoEstruturado mPino , int nDado){
		Path pPath = new Path();

		for(int i = 1; i < nDado; i++){

			if(mPino.getColor() == Color.red){
				for(int j = 1; j < 5; j++){
					if((pPath.getRed()[(mPino.getCasa() + i)].getline() == pPath.getRed()[ConjuntoDePinos.getInstancce().getRed(j).getCasa()].getline()) && (pPath.getRed()[(mPino.getCasa() + i)].getcolumn() == pPath.getRed()[ConjuntoDePinos.getInstancce().getRed(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getRed(j)) == false){
							return false;
						}
						else{

						}

					}
					else if((pPath.getRed()[(mPino.getCasa() + i)].getline() == pPath.getBlue()[ConjuntoDePinos.getInstancce().getBlue(j).getCasa()].getline()) && (pPath.getRed()[(mPino.getCasa() + i)].getcolumn() == pPath.getBlue()[ConjuntoDePinos.getInstancce().getBlue(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getBlue(j)) == false){
							return false;
						}
						else{

						}

					}
					else if((pPath.getRed()[(mPino.getCasa() + i)].getline() == pPath.getYellow()[ConjuntoDePinos.getInstancce().getYellow(j).getCasa()].getline()) && (pPath.getRed()[(mPino.getCasa() + i)].getcolumn() == pPath.getYellow()[ConjuntoDePinos.getInstancce().getYellow(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getYellow(j)) == false){
							return false;
						}

						else{

						}

					}
					else if((pPath.getRed()[(mPino.getCasa() + i)].getline() == pPath.getGreen()[ConjuntoDePinos.getInstancce().getGreen(j).getCasa()].getline()) && (pPath.getRed()[(mPino.getCasa() + i)].getcolumn() == pPath.getGreen()[ConjuntoDePinos.getInstancce().getGreen(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getGreen(j)) == false){
							return false;
						}

						else{

						}

					}

				}

			}

			else if(mPino.getColor() == Color.blue){

				for(int j = 1 ; j < 5; j++){
					if((pPath.getBlue()[(mPino.getCasa() + i)].getline() == pPath.getRed()[ConjuntoDePinos.getInstancce().getRed(j).getCasa()].getline()) && (pPath.getBlue()[(mPino.getCasa() + i)].getcolumn() == pPath.getRed()[ConjuntoDePinos.getInstancce().getRed(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getRed(j)) == false){
							return false;
						}
						else{

						}

					}
					else if((pPath.getBlue()[(mPino.getCasa() + i)].getline() == pPath.getBlue()[ConjuntoDePinos.getInstancce().getBlue(j).getCasa()].getline()) && (pPath.getBlue()[(mPino.getCasa() + i)].getcolumn() == pPath.getBlue()[ConjuntoDePinos.getInstancce().getBlue(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getBlue(j)) == false){
							return false;
						}
						else{

						}

					}
					else if((pPath.getBlue()[(mPino.getCasa() + i)].getline() == pPath.getYellow()[ConjuntoDePinos.getInstancce().getYellow(j).getCasa()].getline()) && (pPath.getBlue()[(mPino.getCasa() + i)].getcolumn() == pPath.getYellow()[ConjuntoDePinos.getInstancce().getYellow(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getYellow(j)) == false){
							return false;
						}

						else{

						}
					}
					else if((pPath.getBlue()[(mPino.getCasa() + i)].getline() == pPath.getGreen()[ConjuntoDePinos.getInstancce().getGreen(j).getCasa()].getline()) && (pPath.getBlue()[(mPino.getCasa() + i)].getcolumn() == pPath.getGreen()[ConjuntoDePinos.getInstancce().getGreen(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getGreen(j)) == false){
							return false;
						}

						else{

						}

					}

				}

			}

			else if(mPino.getColor() == Color.yellow){

				for(int j = 1 ; j < 5; j++){
					if((pPath.getYellow()[(mPino.getCasa() + i)].getline() == pPath.getRed()[ConjuntoDePinos.getInstancce().getRed(j).getCasa()].getline()) && (pPath.getYellow()[(mPino.getCasa() + i)].getcolumn() == pPath.getRed()[ConjuntoDePinos.getInstancce().getRed(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getRed(j)) == false){
							return false;
						}
						else{

						}

					}
					else if((pPath.getYellow()[(mPino.getCasa() + i)].getline() == pPath.getBlue()[ConjuntoDePinos.getInstancce().getBlue(j).getCasa()].getline()) && (pPath.getYellow()[(mPino.getCasa() + i)].getcolumn() == pPath.getBlue()[ConjuntoDePinos.getInstancce().getBlue(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getBlue(j)) == false){
							return false;
						}
						else{

						}

					}
					else if((pPath.getYellow()[(mPino.getCasa() + i)].getline() == pPath.getYellow()[ConjuntoDePinos.getInstancce().getYellow(j).getCasa()].getline()) && (pPath.getYellow()[(mPino.getCasa() + i)].getcolumn() == pPath.getYellow()[ConjuntoDePinos.getInstancce().getYellow(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getYellow(j)) == false){
							return false;
						}

						else{

						}

					}
					else if((pPath.getYellow()[(mPino.getCasa() + i)].getline() == pPath.getGreen()[ConjuntoDePinos.getInstancce().getGreen(j).getCasa()].getline()) && (pPath.getYellow()[(mPino.getCasa() + i)].getcolumn() == pPath.getGreen()[ConjuntoDePinos.getInstancce().getGreen(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getGreen(j)) == false){
							return false;
						}

						else{

						}

					}


				}

			}

			else{ //Caso da cor do pino ser verde

				for(int j = 1 ; j < 5; j++){
					if((pPath.getGreen()[(mPino.getCasa() + i)].getline() == pPath.getRed()[ConjuntoDePinos.getInstancce().getRed(j).getCasa()].getline()) && (pPath.getGreen()[(mPino.getCasa() + i)].getcolumn() == pPath.getRed()[ConjuntoDePinos.getInstancce().getRed(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getRed(j)) == false){
							return false;
						}
						else{

						}

					}
					else if((pPath.getGreen()[(mPino.getCasa() + i)].getline() == pPath.getBlue()[ConjuntoDePinos.getInstancce().getBlue(j).getCasa()].getline()) && (pPath.getGreen()[(mPino.getCasa() + i)].getcolumn() == pPath.getBlue()[ConjuntoDePinos.getInstancce().getBlue(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getBlue(j)) == false){
							return false;
						}
						else{

						}

					}
					else if((pPath.getGreen()[(mPino.getCasa() + i)].getline() == pPath.getYellow()[ConjuntoDePinos.getInstancce().getYellow(j).getCasa()].getline()) && (pPath.getGreen()[(mPino.getCasa() + i)].getcolumn() == pPath.getYellow()[ConjuntoDePinos.getInstancce().getYellow(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getYellow(j)) == false){
							return false;
						}

						else{

						}

					}
					else if((pPath.getGreen()[(mPino.getCasa() + i)].getline() == pPath.getGreen()[ConjuntoDePinos.getInstancce().getGreen(j).getCasa()].getline()) && (pPath.getGreen()[(mPino.getCasa() + i)].getcolumn() == pPath.getGreen()[ConjuntoDePinos.getInstancce().getGreen(j).getCasa()].getcolumn())){

						if (CheckBarrier(ConjuntoDePinos.getInstancce().getGreen(j)) == false){
							return false;
						}

						else{

						}

					}
				}
			}
		}
		return true;

	}

	private int RegraDoTiraSeis(int mDado, PinoEstruturado mPino){
		int aux = 0;

		for(int i = 1; i < 5; i++){
			if(mPino.getColor() == Color.red && ConjuntoDePinos.getInstancce().getRed(i).getCasa() == 0){
				aux++;
			}
			else if(mPino.getColor() == Color.blue && ConjuntoDePinos.getInstancce().getBlue(i).getCasa() == 0){
				aux++;
			}
			else if(mPino.getColor() == Color.yellow && ConjuntoDePinos.getInstancce().getYellow(i).getCasa() == 0){
				aux++;
			}
			else if(mPino.getColor() == Color.green && ConjuntoDePinos.getInstancce().getGreen(i).getCasa() == 0){
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

	private boolean RegraDoShelter(PinoEstruturado mPino, int mDado){
		House[] ArrayShelter = new House[8];
		ArrayShelter[0] = new House(240, 40);
		ArrayShelter[1] = new House(520, 240);
		ArrayShelter[2] = new House(320, 520);
		ArrayShelter[3] = new House(40, 320);
		ArrayShelter[4] = new House(320, 40); // Casa inicial Vermelho
		ArrayShelter[5] = new House(520, 320); // Casa inicial Azul
		ArrayShelter[6] = new House(240, 520); // Casa inicial Amarelo
		ArrayShelter[7] = new House(40, 240); // Casa inicial Verde

		for(int i  = 0; i < 8 ; i++){
			if(mPino.getColor() == Color.red){
				if((Path.getInstance().getRed()[mPino.getCasa() + mDado].getline() == ArrayShelter[i].getline()) && (Path.getInstance().getRed()[mPino.getCasa() + mDado].getcolumn() == ArrayShelter[i].getcolumn())){
					return true;
				}

			}

			else if(mPino.getColor() == Color.blue){
				if((Path.getInstance().getBlue()[mPino.getCasa() + mDado].getline() == ArrayShelter[i].getline()) && (Path.getInstance().getBlue()[mPino.getCasa() + mDado].getcolumn() == ArrayShelter[i].getcolumn())){
					return true;
				}

			}

			else if(mPino.getColor() == Color.yellow){
				if((Path.getInstance().getYellow()[mPino.getCasa() + mDado].getline() == ArrayShelter[i].getline()) && (Path.getInstance().getYellow()[mPino.getCasa() + mDado].getcolumn() == ArrayShelter[i].getcolumn())){
					return true;
				}

			}

			else{//mPino.getColor() == Color.green
				if((Path.getInstance().getGreen()[mPino.getCasa() + mDado].getline() == ArrayShelter[i].getline()) && (Path.getInstance().getGreen()[mPino.getCasa() + mDado].getcolumn() == ArrayShelter[i].getcolumn())){
					return true;
				}

			}
		}
		return false;


	}

	private boolean CheckJogadaPossivel(PinoEstruturado mPino, int nDado){
		int OContador = 0;


		for(int i = 1 ; i < 5 ; i++){
			if(Board.round == 0){

				if(ConjuntoDePinos.getInstancce().getRed(i).getCasa() == 0){
					OContador++;
				}
			}

			else if(Board.round == 1){

				if(ConjuntoDePinos.getInstancce().getBlue(i).getCasa() == 0){
					OContador++;
				}
			}

			else if(Board.round == 2){

				if(ConjuntoDePinos.getInstancce().getYellow(i).getCasa() == 0){
					OContador++;
				}
			}

			else{

				if(ConjuntoDePinos.getInstancce().getGreen(i).getCasa() == 0){
					OContador++;
				}
			}
		}

		if(OContador == 4 && nDado != 5){
			System.out.println("MATEUS TA NO WHATSAPP!");
			return false;
		}


		return true;
	}
}

