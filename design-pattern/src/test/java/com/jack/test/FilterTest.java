package com.jack.test;

import java.util.ArrayList;
import java.util.List;

import com.jack.design.pattern.filter.Filter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FilterTest extends TestCase{
	
	public FilterTest(String testName){
		super(testName);
	}
	
	public static Test suite(){
		return new TestSuite(FilterTest.class);
	}
	
	public void testApp(){
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car("red",1100));
		cars.add(new Car("red",1200));
		cars.add(new Car("green",1300));
		cars.add(new Car("black",1200));
		
		//lambda expression need to jdk1.8 jre above to support
		List<Car> redColor = Filter.filter(cars, (Car car)->"red".equals(car.getColor()) );
		System.out.println(redColor);
		
		List<Car> price1200 = Filter.filter(cars, (Car car)->car.getPrice() == 1200);
		System.out.println(price1200);
		
		cars.stream().filter((Car car)->{return (car.getPrice()>1100);}).forEach(System.out::println);
		
	}
	
	class Car{
		private String color;
		private int price;
		
		public Car(String color,int price){
			this.color = color;
			this.price = price;
		}
		
		public String toString(){
			return (this.color + " " + this.price);
		}
		
		@Override
		public int hashCode(){
			return (this.color.hashCode() + this.price);
		}
		
		@Override
		public boolean equals(Object o){
			if(this == o)
				return true;
			
			if(o instanceof Car){
				Car tmp = (Car)o;
				if(this.color!=null && this.color.equals(tmp.getColor()) 
						&& this.price == tmp.getPrice()){
					return true;
				}else if(this.color == null && tmp.color == null 
						&& this.price == tmp.getPrice()){
					return true;
				}
			}
			
			return false;
		}
		
		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
	}
	
}
