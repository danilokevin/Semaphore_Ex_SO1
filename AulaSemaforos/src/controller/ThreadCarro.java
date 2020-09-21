package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	
	private int idCarro;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	
	public ThreadCarro(int idCarro, Semaphore semaforo){
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		carroAndando();
//		---------- In�cio Se��o Cr�tica -----------------
		try {
			semaforo.acquire();
			carroEstacionando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
//			------------ Fim Se��o Cr�tica -----------------
			carroSaindo();
		}
		
		
//		
	}
	
	private void carroAndando() {
//		gerando n�mero aleat�rio entre 1000 e 2000 para demonstrar a distancia percorrida dos carros
//		Math.random() < 0 at� 0.999999 >
		int distanciaTotal = (int)((Math.random() * 1001) + 1000);
		int distanciaPercorrida = 0;
		
		int deslocamento = 100;
		int tempo = 1000;
		
		while (distanciaPercorrida < distanciaTotal){
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("#" + idCarro + "j� andou " + distanciaPercorrida + "m.");
		}
		posChegada++;
		System.out.println("#" + idCarro + " foi o " + posChegada + "� a chegar");
	}

	
	private void carroEstacionando() {
		System.out.println("#" + idCarro + " estacionou");
		int tempo = (int)((Math.random() * 2001) + 1000);
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void carroSaindo() {
		posSaida++;
		System.out.println("#" + idCarro + " foi o " + posSaida + "� a sair");
	}

	

	

}
