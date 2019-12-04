package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class Integral extends Thread{
	
	public static void main(String... args){
		int numOfThreads = 100;// количество потоков
		double begin = 0;
		double end = 1;
		double alfa = 0.0000000005;
		double sum = 0;
		
		Calculation results = new Calculation(begin, end, alfa, numOfThreads);
		MyThread[] arrayOfThreads = new MyThread[numOfThreads];
		for (int i = 0; i < numOfThreads; i++){
			arrayOfThreads[i] = new MyThread(i, results);
			arrayOfThreads[i].thrd.start();
		}
		try {
			Thread.sleep(2500);
			System.out.println(".....");
		}
		catch(InterruptedException e) {
			System.out.println("23");
		}
		for (int i = 0; i < numOfThreads; i++){
			sum += arrayOfThreads[i].getLastResult();
		}
		System.out.println(sum);
	}
}