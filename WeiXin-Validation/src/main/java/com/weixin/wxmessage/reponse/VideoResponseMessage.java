package com.weixin.wxmessage.reponse;

/**
 * 视频消息
 */
public class VideoResponseMessage extends BaseResponseMessage {
	
	// 视频
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}
