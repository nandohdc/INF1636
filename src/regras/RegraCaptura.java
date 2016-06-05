package regras;

import java.awt.*;

import movimento.ConjuntoDePinos;
import movimento.Path;
import movimento.PinoEstruturado;

public class RegraCaptura {
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
