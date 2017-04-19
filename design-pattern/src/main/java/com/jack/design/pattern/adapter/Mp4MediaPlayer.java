package com.jack.design.pattern.adapter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Mp4MediaPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc() {
		throw new NotImplementedException();
	}

	@Override
	public void playMp4() {
		System.out.println("MP4 play...");
	}

}
