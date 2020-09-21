package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarroCruzamento;

public class Cruzamento {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for (int i = 1; i < 5; i++){
			ThreadCarroCruzamento tCarro = new ThreadCarroCruzamento(i, semaforo);
			tCarro.start();
		}

	}

}
