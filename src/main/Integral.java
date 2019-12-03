package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class Integral extends Thread{
	
	double begin, end;
	int numberOfThreads;
	double alfa;
	static double sum;
	
	
	public Integral(double begin, double end, int numberOfThreads, double alfa){
		this.begin = begin;
		this.end = end;
		this.numberOfThreads = numberOfThreads;
		this.alfa = alfa;		
	}
	public Integral(){
		
	}
	
	
	
	
	
	
	/**@Override
	public void run(){
		calcInt(begin,end, numberOfThreads);
		
		
	}**/
	
	/**double calcInt(double a, double b, int n){
		double result = 0.0;
		double step = (double)(b - a) /(double) (n);
		
		for (int i = 1; i <= n; i++){
			result += function(a + step * (i + 0.5));			
		}
		
		sum = sum + (result * step);
		//System.out.println(result * step);	
		return result * step;
		
	}**/
	
	public static void main(String... args){
		int n = 100;
		int begin = 1 ;
		int end = 10;
		double step = (double)(end - begin) / n;
		Results results = new Results(n);
		MyThread[] arrayOfThreads = new MyThread[n];
		for (int i = 0; i < n; i++){
			arrayOfThreads[i] = new MyThread(i, results);
		}
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			System.out.println("23");
		}
		System.out.println(results.getIntegral());
		
		
		
		/**
		Integral[] integral = new Integral[n];
		Thread newThread;
		for (int i = 0; i < n; i++){
			integral[i] = new Integral(begin + i * step, begin + i * step + step, 10000, 0.2);
			//newThread = new Thread(integral[i]);
			integral[i].start();
		}
		Integral res = new Integral();		
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			System.out.println("23");
		}
		System.out.println(res.sum);
		**/
		
		
	}
}