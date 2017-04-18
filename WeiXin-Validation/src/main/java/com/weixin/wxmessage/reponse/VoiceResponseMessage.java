package com.weixin.wxmessage.reponse;

public class VoiceResponseMessage extends BaseResponseMessage {
	
	// 语音
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}