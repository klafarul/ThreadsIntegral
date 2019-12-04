package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MyThread implements Runnable{
	
	public Thread thrd;
	public int number;
	public Calculation res;
	private double lastResult;
	
	
	public MyThread(int number, Calculation res){
		thrd = new Thread(this);
		this.number = number;
		this.res = res;
		lastResult = 0;	
	}
	public double getLastResult(){
		return lastResult;
	}
	/**
	* Вычисляем интеграл подотрезка
	**/
	@Override
	public void run(){
		double currentResult;
		
		int n = 10;
		boolean end = false;
		do{
			currentResult = res.calcInt(res.begin + number * res.step, res.begin + number * res.step + res.step, n);
			if (Math.abs(currentResult - lastResult) >= res.alfa){
				lastResult = currentResult;
				n +=10;
			}
			else{
				lastResult = currentResult;
				end = true;				
			}
									
		} while (!end);
	}
} 