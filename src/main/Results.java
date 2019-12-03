package main;

import java.util.ArrayList;

public class Results {
	private ArrayList<Double> results;
	
	double begin, end;
	int numberOfThreads;
	double alfa;
	double step;
	

	
	public Results(int numberOfThreads){
		results = new ArrayList<Double>();
		for (int i = 0; i < numberOfThreads; i++){
			results.add(0.0);
		}
		this.begin = 1;
		this.end = 10;
		this.alfa = 0.5;
		this.numberOfThreads = numberOfThreads;
		this.step = (double)(this.end - this.begin) / numberOfThreads;
		
	}
	/**
	*подинтегральная функция
	**/
	public double function(double x){
		return Math.sqrt(2 + x*x);		
	}
	
	synchronized double getDelta(int threadNumber){
		double result;
		if (threadNumber != results.size() - 1){
			result = Math.abs(results.get(threadNumber) - results.get(threadNumber + 1));
		}
		else{
			result = Math.abs(results.get(threadNumber) - results.get(threadNumber - 1));
		}
		return result;
		
	}
	
	synchronized void setResult(int threadNumber, double result){
		results.set(threadNumber, result);				
	}
	


	
	
	public double calcInt(double a, double b, int segments){

		double result = 0.0;
		double step = (double)(b - a) /(double) (segments);
		
		for (int i = 1; i <= segments; i++){
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
