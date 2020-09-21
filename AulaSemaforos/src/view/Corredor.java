package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoa;

public class Corredor {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int idPessoa = 1; idPessoa < 5; idPessoa++){
			ThreadPessoa tPessoa = new ThreadPessoa(idPessoa, semaforo);
			tPessoa.start();
		}

	}

}
