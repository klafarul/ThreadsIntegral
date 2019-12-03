package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MyThread implements Runnable{
	
	Thread thrd;
	int number;
	Results res;
	
	public MyThread(int i, Results res){
		thrd = new Thread(this);
		this.number = i;
		this.res = res;
		thrd.start();
		
	}
	
	
	@Override
	public void run(){
		double result;
		int n = 10;
		do{
			result = res.calcInt(res.begin + number * res.step, res.begin + number * res.step + res.step, n);
			res.setResult(number, result);
			n+=100;			
		} while (res.getDelta(number) >= res.alfa);
	}
} 