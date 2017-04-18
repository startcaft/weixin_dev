package com.weixin.wxmessage;

/**
 * 请求消息之视频消息 <br/>
 * 视频和小视频的数据格式一样，通过MsgType来区分
 */
public class VideoMessage extends BaseMessage {
	
	// 媒体ID
    private String MediaId;
    // 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
    public String getThumbMediaId() {
        return ThumbMediaId;
    }
    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
