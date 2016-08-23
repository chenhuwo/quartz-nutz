package com.chw.test;

import org.nutz.lang.Tasks;

import sun.applet.Main;

public class Panda extends AnimalModel {

	@Override
	public void eat() {
		System.out.println("panda eat....");
	}

	@Override
	public void sleep() {
		System.out.println("panda sleep....");
	}
	
	
	public static void main(String[] args) {
		String name = "sadfd";
		Monkey m = Monkey.newMonkey(name);
		System.out.println(m.getName());
	}

}
