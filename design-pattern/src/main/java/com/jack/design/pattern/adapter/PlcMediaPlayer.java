package com.jack.design.pattern.adapter;

public class PlcMediaPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc() {
		System.out.println("Plc paly...");
	}

	@Override
	public void playMp4() {
		throw new UnsupportedOperationException();
	}
		
}
