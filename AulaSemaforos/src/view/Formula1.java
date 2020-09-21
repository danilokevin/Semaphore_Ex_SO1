package view;


import java.util.concurrent.Semaphore;

import controller.Escuderia;

public class Formula1 extends Thread {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(5);
		Escuderia res = new Escuderia();
		
		for(int i = 1; i < 3; i++){
			Escuderia e1 = new Escuderia(i, 1, semaforo);
			Escuderia e2 = new Escuderia(i, 2, semaforo);
			Escuderia e3 = new Escuderia(i, 3, semaforo);
			Escuderia e4 = new Escuderia(i, 4, semaforo);
			Escuderia e5 = new Escuderia(i, 5, semaforo);
			Escuderia e6 = new Escuderia(i, 6, semaforo);
			Escuderia e7 = new Escuderia(i, 7, semaforo);
			e1.start();
			e2.start();
			e3.start();
			e4.start();
			e5.start();
			e6.start();
			e7.start();
		}
		
		try {
			sleep(4000);
			System.out.println("************************************************************");
			System.out.println("************** R E S U L T A D O   F I N A L *****************");
			System.out.println("************** MENORES TEMPOS DE CADA CARRO ****************");
			System.out.println("************************************************************");
			System.out.println(res.resultado());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
