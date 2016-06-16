package lxy.demo.qrcode;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@RestController
public class QRCodeController {

	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	/***
	 * 指定输出类型为 图片
	 * 
	 */
	@RequestMapping(value = "/qrcode", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getQRCode(String content, int width, int height) {

		return toImageStream(content, width, height).toByteArray();
	}

	/***
	 * 指定输出类型为 图片
	 * 
	 * 如果需要二维码被当作图片现在 请在header 里注明 Content-Disposition
	 * 
	 */
	@RequestMapping(value = "/qrcodedownload", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getQRCodeDownload(String content, int width, int height, HttpServletResponse res) {
		if (width == 0 || height == 0) {
			width = 300;
			height = 300;
		}
		res.addHeader("Content-Disposition", "attachment;filename=" + "qrcode.jpg");

		byte[] byt = toImageStream(content, width, height).toByteArray();
		try {
			OutputStream os = res.getOutputStream();
			os.write(byt);
			os.flush();
			os.close();
		} catch (IOException e) {

		}

		return null;
	}

	public static BufferedImage toBufferedImage(String content, int width, int height) {

		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码

		BitMatrix bitMatrix;
		try {
			bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
				}
			}
			return image;
		} catch (WriterException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static ByteArrayOutputStream toImageStream(String content, int width, int height) {
		BufferedImage image = toBufferedImage(content, width, height);

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "jpeg", bos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bos;
	}

}
