package main;

import java.util.ArrayList;

public class Calculation {
	
	
	double begin, end;
	int numberOfThreads;
	double alfa;
	double step;
	

	/**
	*конструктор
	**/
	public Calculation(double begin, double end, double alfa, int numberOfThreads){
		
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
	
	

}
