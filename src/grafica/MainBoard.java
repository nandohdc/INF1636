package grafica;

import javax.swing.SwingUtilities;

public class MainBoard {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Board();
			}
		});

    }

}
