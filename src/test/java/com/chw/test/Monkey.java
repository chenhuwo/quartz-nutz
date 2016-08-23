package com.chw.test;


public class Monkey extends AnimalModel {
	
	private String name;
	
	private Monkey(String name) {
		this.name = name;
	}
	private Monkey() {
	}
	
	public static Monkey newMonkey(String name){
		return new Monkey(name);
	}
	
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	@Override
	public void eat() {
		System.out.println("monkey eat ....");
	}

	@Override
	public void sleep() {
		System.out.println("monkey sleep ....");
	}
	
	public static void main(String[] args) {
		AnimalModel panda = new Panda();
		AnimalModel monkey = new Monkey();
		
		panda.execute();
		
		monkey.execute();
	}
}


