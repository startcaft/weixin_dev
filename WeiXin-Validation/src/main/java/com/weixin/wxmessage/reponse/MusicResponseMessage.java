package com.weixin.wxmessage.reponse;

/**
 * 音乐消息
 */
public class MusicResponseMessage extends BaseResponseMessage {
	
	 // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
