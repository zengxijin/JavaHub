package com.jack.design.pattern.adapter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MediaAdapter implements MediaPlayer {
	
	AdvancedMediaPlayer advancedMediaPlayer;

	@Override
	public void play() {
		if(advancedMediaPlayer instanceof Mp4MediaPlayer){
			advancedMediaPlayer.playMp4();
		}else if(advancedMediaPlayer instanceof PlcMediaPlayer){
			advancedMediaPlayer.playVlc();
		}else{
			throw new NotImplementedException();
		}
	}
	
	public MediaAdapter(String mediaType){
		String mediaTypeLower = ("" + mediaType).toLowerCase();
		
		if( "mp4".equals(mediaTypeLower) ){
			advancedMediaPlayer = new Mp4MediaPlayer();
		}else if("plc".equals(mediaTypeLower)){
			advancedMediaPlayer = new PlcMediaPlayer();
		}
	}

}
