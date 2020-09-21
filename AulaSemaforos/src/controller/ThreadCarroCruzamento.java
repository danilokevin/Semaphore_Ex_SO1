package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarroCruzamento extends Thread {
	
	private String direcao;
	Semaphore semaforo;
	
	public ThreadCarroCruzamento(int id, Semaphore semaforo){
		switch (id){
		case 1:
			this.direcao = "Sul";
			break;
		case 2:
			this.direcao = "Oeste";
			break;
		case 3:
			this.direcao = "Norte";
			break;
		case 4: 
			this.direcao = "Leste";
			break;
		}
		
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		System.out.println("Carros andando em direção ao cruzamento....");
		
		carroAndando();
		
		try {
			semaforo.acquire();
			carroCruzandoVia();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}


	private void carroAndando() {
		int tempoAndando = 5000;
		
		try {
			sleep(tempoAndando);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Carro em direção " + direcao + " chegou no cruzamento");
	}

	private void carroCruzandoVia() {
		System.out.println("Carro em direção " + direcao + " está passando no cruzamento no momento");
		
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Carro em direção " + direcao + " terminou o cruzamento");
		
	}

}
