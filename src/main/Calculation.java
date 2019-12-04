package main;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import static java.lang.Double.*;

public class Calculation {
	/**
	* этот массив хранит результат вычисления каждого потока, номер потока соответствует номеру элемента в массиве
	**/
	
	AtomicReference<Double> results;
	
	double begin, end;
	int numberOfThreads;
	double alfa;
	double step;
	

	/**
	*конструктор
	**/
	public Calculation(double begin, double end, double alfa, int numberOfThreads){
		results = new AtomicReference<Double>(0.0);

		
		
		this.begin = begin;
		this.end = end;
		this.alfa = alfa;
		this.numberOfThreads = numberOfThreads;
		this.step = (double)(this.end - this.begin) / numberOfThreads;
		
	}
	/**
	*подинтегральная функция
	**/
	public double function(double x){
		return x*x;		
	}
	
	
	
	void setResult(double result){
		
		while(true){
			Double expect = results.get();
			
			
			if (results.compareAndSet(expect, expect + result)){
				System.out.println(results.get());
				break;
			}
			else{
				System.out.println("konflikt" + results.get());
				
			}
		}
		
	}	
	/**
	*Вычисляет интеграл на отрезке
	**/
	public double calcInt(double a, double b, int segments){

		double result = 0.0;
		double step = (double)(b - a) /(double) (segments);
		
		for (int i = 0; i < segments; i++){
			result += function(a + step * (i + 0.5));			
		}
		
			
		return result * step;
	}
	public double getIntegral(){
		
		return results.get();
	}	
}
