package controller;

import java.util.concurrent.Semaphore;

public class Escuderia extends Thread {
	private int carro;
	private int equipe;
	private Semaphore semaforo;
	private static int tempos[] = new int[14];
	private static int competidores[] = new int[14];
	private static int equipes[] = new int[14];
	private static int i = 0;
	
	public Escuderia(int id, int equipe, Semaphore semaforo){
		this.carro = id;
		this.equipe = equipe;
		this.semaforo = semaforo;
	}
	
	public Escuderia(){}

	@Override
	public String toString() {
		return "Escuderia [id=" + carro + ", equipe=" + equipe + "]";
	}
	
	@Override
	public void run() {
		try{
			semaforo.acquire();
			largada();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
		
	}

	

	private void largada() {
		int menorTempo = 0;
		System.out.println("Carro " + carro + " da Equipe " + equipe + " na pista");
		
		
		for (int voltas = 1; voltas < 4; voltas++){
			
			int tempoVolta = (int)((Math.random() * 15) + 3);
			
			try {
				sleep(tempoVolta * 10);
				System.out.println("Carro " + carro + " da Equipe " + equipe + " TERMINOU " + voltas + "ª volta em " + tempoVolta + "s.");
				if (voltas == 1){
					menorTempo = tempoVolta;
				} else {
					if (tempoVolta < menorTempo){
						menorTempo = tempoVolta;
					}
				}	
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		tempos[i] = menorTempo;
		competidores[i] = carro;
		equipes[i] = equipe;
		i++;	
	}
	
	public static String resultado() {
		String msg = "";
		int aux;
		
		for (int i = 0; i < 14; i++){
			for (int j = 0; j < 14; j++){
				if (tempos[i] < tempos[j]){
					aux = tempos[i];
					tempos[i] = tempos[j];
					tempos[j] = aux;
					
					aux = equipes[i];
					equipes[i] = equipes[j];
					equipes[j] = aux;
					
					aux = competidores[i];
					competidores[i] = competidores[j];
					competidores[j] = aux;
				}
			}
		}
		for (int i = 0; i < 14; i++){
			msg += "Equipe " + equipes[i] + " * Carro " + competidores[i] + " * " + tempos[i] + "s. \n";
		}
		
		return msg;
		
	}
	

	
	
	
	
	


	
	

}
