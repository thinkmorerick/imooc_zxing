package com.imooc.zxing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.security.spec.EncodedKeySpec;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

//生成二维码
public class CreateQRCode {

	public static void main(String[] args) {
		
		int width = 300;
		int height = 300;
		String format = "png";
		String contents = "www.imooc.com";
		
		//定义二维码参数
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		
		//生成二维码
		try {
			BitMatrix matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
			Path file = new File("/Users/zhufeng/code/img.png").toPath();
			MatrixToImageWriter.writeToPath(matrix, format, file);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
