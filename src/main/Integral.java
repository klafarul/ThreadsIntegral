package main;

import java.util.concurrent.locks.ReentrantLock;


public class Integral extends Thread{
	
	public static void main(String... args){
		int numOfThreads = 2;// количество потоков
		double begin = 0;
		double end = 1;
		double alfa = 0.00000005;
		
		Calculation results = new Calculation(begin, end, alfa, numOfThreads);
		ReentrantLock locker = new ReentrantLock();//LOCKER
		
		MyThread[] arrayOfThreads = new MyThread[numOfThreads];
		
		for (int i = 0; i < numOfThreads; i++){
			arrayOfThreads[i] = new MyThread(i, results, locker);
		}
		try {
			Thread.sleep(1500);
			System.out.println(".....");
		}
		catch(InterruptedException e) {
			System.out.println("23");
		}
		System.out.println(results.getIntegral());
	}
}