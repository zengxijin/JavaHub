package com.jack.design.pattern.adapter;

public class AudioPlayer implements MediaPlayer {

	private MediaAdapter mediaAdapter;
	private String mediaType;
	
	@Override
	public void play() {
		String mediaTypeLower = ("" + this.mediaType).toLowerCase();
		
		if("mp3".equals(mediaTypeLower)){
			System.out.println("Mp3 play...");
		}else{
			mediaAdapter = new MediaAdapter(mediaTypeLower);
			mediaAdapter.play();
		}
	}
	
	public AudioPlayer(String mediaType){
		this.mediaType = mediaType;
	}

}
