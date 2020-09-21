package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {
	
	private int distanciaTotal = 20;
	private Semaphore semaforo;
	private int id;
	
	public ThreadPessoa(int id, Semaphore semaforo){
		this.id = id;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		pessoaAndando();
		
		try {
			semaforo.acquire();
			pessoaAtravessandoPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
	}

	private void pessoaAndando() {
		int distanciaPercorrida = 0;
		int deslocamento;
		int tempo = 1000;
		
		while (distanciaPercorrida < distanciaTotal){
			deslocamento = (int)((Math.random() * 4) + 2);
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Pessoa id#" + id + " já andou " + distanciaPercorrida + "m.");
		}
		System.out.println("Pessoa id#" + id + " chegou na porta");
	}
	
	private void pessoaAtravessandoPorta() {
		System.out.println("Pessoa id#" + id + " está abrindo a porta");
		int tempo = (int)((Math.random() * 1) + 1);
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Pessoa id#" + id + " entrou na sala");
	}

}
