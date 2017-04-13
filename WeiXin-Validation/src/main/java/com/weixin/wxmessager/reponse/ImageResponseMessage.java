package com.weixin.wxmessager.reponse;

/**
 * 图片消息
 */
public class ImageResponseMessage extends BaseResponseMessage {
	
	private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}
