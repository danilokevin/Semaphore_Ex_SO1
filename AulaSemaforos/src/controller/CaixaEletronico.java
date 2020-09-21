package controller;

import java.util.concurrent.Semaphore;

public class CaixaEletronico extends Thread {
	
	private int conta;
	private int valor;
	private double saldo;
	private Semaphore semaforo1;
	private Semaphore semaforo2;
	
	public CaixaEletronico(int conta, int valor, double saldo, Semaphore semaforo1, Semaphore semaforo2) {
		super();
		this.conta = conta;
		this.valor = valor;
		this.saldo = saldo;
		this.semaforo1 = semaforo1;
		this.semaforo2 = semaforo2;
	}
	
	@Override
	public void run() {		
			if (this.conta % 2 == 0){
				try{
					semaforo1.acquire();
					sacar();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo1.release();
				}
			} else {
				try{
					semaforo2.acquire();
					depositar();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaforo2.release();
				}
			}
			
		
		//verSaldo();
	}

	

	private void depositar() {
		try {
			System.out.println("Realizando depósito...");
			this.saldo += this.valor;
			sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Depósito na conta " + this.conta + " realizado com sucesso!");
		
	}

	private void sacar() {
		try {
			System.out.println("Realizando saque...");
			this.saldo -= this.valor;
			sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Saque da conta " + this.conta + " realizado com sucesso!");
	}
	
//	private void verSaldo() {
//		System.out.println("Saldo atualizado: R$ " + this.saldo);
//	}


	


}
