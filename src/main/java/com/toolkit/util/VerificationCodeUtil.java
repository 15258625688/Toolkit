package com.toolkit.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

import com.madgag.gif.fmsware.AnimatedGifEncoder;
import com.toolkit.entity.VerificationCode;

/**
 * 创建验证码
 * 
 * @author 张豪浩 zhanghaohao0820@gmail.com
 *
 */
public class VerificationCodeUtil {

    private final static char[] CS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
	    'E', 'F', 'G', 'H', 'I', 'G', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
	    'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'g', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
	    'u', 'v', 'w', 'x', 'y', 'z' };

    private final static Color[] COLORS = new Color[] { Color.BLUE, Color.RED, Color.GREEN, Color.BLACK };

    private static Font font;
    static {
	try {
	    font = Font.createFont(Font.TRUETYPE_FONT,
		    VerificationCodeUtil.class.getClassLoader().getResourceAsStream("fonts/f3.ttf"));
	    font = font.deriveFont(Font.BOLD, 25);
	} catch (Exception e) {
	    font = new Font("Algerian", Font.BOLD, 25);
	}
    }

    /**
     * 验证码位数
     * 
     */
    private final static int CODE_LENTH = 4;

    private static BufferedImage createBufferedImage(int width, int height) {
	ColorModel cm = ColorModel.getRGBdefault();
	WritableRaster wr = cm.createCompatibleWritableRaster(width, height);
	BufferedImage bufferedImage = new BufferedImage(cm, wr, cm.isAlphaPremultiplied(), null);
	return bufferedImage;
    }

    public static VerificationCode newVerificationCode() throws IOException {
	StringBuilder code = new StringBuilder();
	Random random = new Random();
	BufferedImage image = createBufferedImage(20 * CODE_LENTH, 30);
	Graphics2D g = image.createGraphics();
	for (int n = 0; n < CODE_LENTH; n++) {
	    g.setColor(COLORS[random.nextInt(COLORS.length)]);
	    char c = CS[random.nextInt(CS.length)];
	    AffineTransform t = font.getTransform();
	    if (n == 0) {
		// 第一位
		t.rotate(Math.toRadians(random.nextInt(50)));
	    } else if (n == CODE_LENTH - 1) {
		// 最后一位
		t.rotate(Math.toRadians(-random.nextInt(50)));
	    } else {
		// 字体旋转角度为-50到50之间
		t.rotate(Math.toRadians(50 - random.nextInt(100)));
	    }
	    g.setFont(font.deriveFont(t));
	    // 每个字体宽度20
	    g.drawString(String.valueOf(c), n * 20, 20);
	    code.append(c);
	}
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	ImageIO.write(image, "png", out);
	g.dispose();
	byte[] bs = Base64.encodeBase64(out.toByteArray());
	String base64Img = Base64Util.PNG + new String(bs);
	VerificationCode vc = new VerificationCode();
	vc.setCode(code.toString());
	vc.setBase64Img(base64Img);
	return vc;
    }

    public static VerificationCode newVerificationCode_Gif() throws IOException {
	char[] cs = new char[CODE_LENTH];
	Random random = new Random();
	for (int n = 0; n < CODE_LENTH; n++)
	    cs[n] = CS[random.nextInt(CS.length)];
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	AnimatedGifEncoder e = new AnimatedGifEncoder();
	// 对应颜色改为透明
	e.setTransparent(Color.WHITE);
	// 背景改为透明
	e.setBackground(new Color(0, 0xff, 0xff, 0xff));
	e.setRepeat(0);
	e.start(out);
	e.setDelay(1000);
	for (int n = 0; n < 10; n++) {
	    BufferedImage image = createBufferedImage(20 * CODE_LENTH, 30);
	    Graphics2D g = image.createGraphics();
	    int length = cs.length;
	    for (int index = 0; index < length; index++) {
		char c = cs[index];
		g.setColor(COLORS[random.nextInt(COLORS.length)]);
		AffineTransform t = font.getTransform();
		// 字体旋转角度为-50到50之间
		if (index == 0) {
		    // 第一位
		    t.rotate(Math.toRadians(random.nextInt(50)));
		} else if (index == length - 1) {
		    // 最后一位
		    t.rotate(Math.toRadians(-random.nextInt(50)));
		} else {
		    // 字体旋转角度为-50到50之间
		    t.rotate(Math.toRadians(50 - random.nextInt(100)));
		}
		g.setFont(font.deriveFont(t));
		// 每个字体宽度20
		g.drawString(String.valueOf(c), index * 20, 20);
	    }
	    e.addFrame(image);
	    e.setDelay(1000);
	}
	e.finish();
	byte[] bs = Base64.encodeBase64(out.toByteArray());
	String base64Img = Base64Util.GIF + new String(bs);
	VerificationCode vc = new VerificationCode();
	vc.setCode(String.valueOf(cs));
	vc.setBase64Img(base64Img);
	return vc;
    }
}