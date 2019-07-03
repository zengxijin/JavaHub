package com.jack.design.pattern.adapter;

public class Mp4MediaPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void playMp4() {
		System.out.println("MP4 play...");
	}

}
