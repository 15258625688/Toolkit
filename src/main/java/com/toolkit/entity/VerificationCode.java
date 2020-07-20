package com.toolkit.entity;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

public class VerificationCode {
    private String code;
    private String base64Img;
    private OutputStream out;
    private BufferedImage image;

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getBase64Img() {
	return base64Img;
    }

    public void setBase64Img(String base64Img) {
	this.base64Img = base64Img;
    }

    public OutputStream getOut() {
	return out;
    }

    public void setOut(OutputStream out) {
	this.out = out;
    }

    public BufferedImage getImage() {
	return image;
    }

    public void setImage(BufferedImage image) {
	this.image = image;
    }

}
