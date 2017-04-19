package com.jack.design.pattern.adapter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class PlcMediaPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc() {
		System.out.println("Plc paly...");
	}

	@Override
	public void playMp4() {
		throw new NotImplementedException();
	}
		
}
