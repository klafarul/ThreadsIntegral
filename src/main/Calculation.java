package main;

import java.util.ArrayList;

public class Calculation {
	/**
	* этот массив хранит результат вычисления каждого потока, номер потока соответствует номеру элемента в массиве
	**/
	private ArrayList<Double> results;
	
	double begin, end;
	int numberOfThreads;
	double alfa;
	double step;
	

	/**
	*конструктор
	**/
	public Calculation(double begin, double end, double alfa, int numberOfThreads){
		results = new ArrayList<Double>();
		for (int i = 0; i < numberOfThreads; i++){
			results.add(0.0);
		}
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
	
	
	
	synchronized void setResult(int threadNumber, double result){
		results.set(threadNumber, result);	
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
		double result = 0.0;
		for (int i = 0; i < results.size(); i++){
			result += results.get(i);
		}
		return result;
	}	
}
