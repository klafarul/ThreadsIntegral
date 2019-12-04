package main;

import java.util.concurrent.locks.ReentrantLock;



public class MyThread implements Runnable{
	
	Thread thrd;
	int number;
	Calculation res;
	ReentrantLock locker;
	
	
	public MyThread(int number, Calculation res, ReentrantLock locker){
		thrd = new Thread(this);
		this.number = number;
		this.res = res;
		this.locker = locker;
		thrd.start();
		
	}
	/**
	* Вычисляем интеграл подотрезка
	**/
	@Override
	public void run(){
		double currentResult;
		double lastResult = 0;
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
				
				locker.lock();
				res.setResult(number, lastResult);
				locker.unlock();	
			}
								
		} while (!end);
		
	}
} 