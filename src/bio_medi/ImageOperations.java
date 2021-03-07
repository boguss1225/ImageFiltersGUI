package bio_medi;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageOperations {
	public Image Threshold(Image Originalimg,int ThresholdValue) {
		/*쓰레스홀드 밸류값은 0~255 사이의 값이 유효합니다.*/
		BufferedImage img = (BufferedImage)Originalimg;
		int height = img.getHeight();		//이미지의 높이를 구한다.
		int width = img.getWidth();		//이미지의 길이를 구한다.
		BufferedImage finalThresholdImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB) ;
		//버퍼 이미지를 RGB타입으로 생성.
		
		int red = 0;
		int green = 0;
		int blue = 0;
		
		for (int x = 0; x < width; x++) {
			try {
				for (int y = 0; y < height; y++) {
					int color = img.getRGB(x, y);		//x,y 지점의 RGB값을 구합니다.
					
					red = ImageOperations.getRed(color);		//Red값 추출
					green = ImageOperations.getGreen(color);	//Green값 추출
					blue = ImageOperations.getBlue(color);		//Blue값 추출
						if((red+green+blue)/3 < (int) (ThresholdValue)) {	//쓰레스홀드 밸류에 맞추어 추출한 픽셀 컬러값들의 합이 작다면
							finalThresholdImage.setRGB(x,y,ImageOperations.mixColor(0,0,0));	//픽셀값 (흑)
						}
						else {															//크다면
							finalThresholdImage.setRGB(x,y,ImageOperations.mixColor(255,255,255));		//픽셀값 (백)
						}
				}
			} catch (Exception e) {		//예외발생시 메시지 받기
				 e.getMessage();
			}
		}
		
		return (Image)finalThresholdImage;
	}
	
	public Image BlacknWhite(Image Originalimg) {
		BufferedImage img = (BufferedImage)Originalimg;
		int height = img.getHeight();		//이미지의 높이를 구한다.
		int width = img.getWidth();		//이미지의 길이를 구한다.
		BufferedImage finalThresholdImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		
		//버퍼 이미지를 RGB타입으로 생성.
		int red = 0;
		int green = 0;
		int blue = 0;
		
		for (int x = 0; x < width; x++) {
			try {
				for (int y = 0; y < height; y++) {
					int color = img.getRGB(x, y);		//x,y 지점의 RGB값을 구합니다.
					
					red = ImageOperations.getRed(color);		//Red값 추출
					green = ImageOperations.getGreen(color);	//Green값 추출
					blue = ImageOperations.getBlue(color);		//Blue값 추출
					int cmax = Math.max(Math.max(red,blue), green);
					int graycolor = (color & 0xFF000000) | (cmax << 16) | (cmax << 8) | cmax;
					finalThresholdImage.setRGB(x,y,graycolor);		//픽셀값 (백)
				}
			} catch (Exception e) {		//예외발생시 메시지 받기
				 e.getMessage();
			}
		}
		
		return (Image)finalThresholdImage;
	}

	public Image inverse(Image Originalimg) {
		BufferedImage img = (BufferedImage)Originalimg;
		int height = img.getHeight();		//이미지의 높이를 구한다.
		int width = img.getWidth();		//이미지의 길이를 구한다.
		BufferedImage finalThresholdImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB) ;
		//버퍼 이미지를 RGB타입으로 생성.
		
		int red = 0;
		int green = 0;
		int blue = 0;
		
		for (int x = 0; x < width; x++) {
			try {
				for (int y = 0; y < height; y++) {
					int color = img.getRGB(x, y);		//x,y 지점의 RGB값을 구합니다.
					
					red = ImageOperations.getRed(color);		//Red값 추출
					green = ImageOperations.getGreen(color);	//Green값 추출
					blue = ImageOperations.getBlue(color);		//Blue값 추출
					finalThresholdImage.setRGB(x,y,ImageOperations.mixColor(255-red,255-green,255-blue));		//픽셀값 (백)
				}
			} catch (Exception e) {		//예외발생시 메시지 받기
				 e.getMessage();
			}
		}
		
		return (Image)finalThresholdImage;
	}
	
	private static int mixColor(int red, int green, int blue) {		//RGB 컬러의 합성
		return red<<16|green<<8|blue;
	}

	private static int getRed(int color) {		//픽셀의 RED값의 데이터를 추출
		return (color & 0x00ff0000)  >> 16;
	}
	
	private static int getGreen(int color) {	//픽셀의 Green값의 데이터를 추출
		return	(color & 0x0000ff00)  >> 8;
	}
	
	private static int getBlue(int color) {	//픽셀의 Blue값의 데이터를 추출
		return (color & 0x000000ff)  >> 0;
	}
	
}

