package view;

import java.util.concurrent.Semaphore;

import controller.CaixaEletronico;

public class Banco {

	public static void main(String[] args) {
		
		int permissao = 1;
		Semaphore semaforo1 = new Semaphore(permissao);
		Semaphore semaforo2 = new Semaphore(permissao);
		
		for (int i = 0; i < 20; i++){
			int conta = (int)((Math.random() * 500) + 1);
			double saldo = ((Math.random() * 50) + 0.1);
			int valor = (int)((Math.random() * saldo) + 20);
				
			CaixaEletronico opSaque = new CaixaEletronico(conta, valor, saldo, semaforo1, semaforo2);
			opSaque.start();
		}
		

	}

}
