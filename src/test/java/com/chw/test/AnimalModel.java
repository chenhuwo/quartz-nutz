package com.chw.test;
/**
 * 模板模式
 * @author Deyunse
 *	
 */
public abstract class AnimalModel {
	
	public abstract void eat();
	
	public abstract void sleep();
	

	public void execute(){
		this.eat();
		this.sleep();
	}
	

}
