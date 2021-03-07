package bio_medi;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageOperations {
	public Image Threshold(Image Originalimg,int ThresholdValue) {
		/*������Ȧ�� ������� 0~255 ������ ���� ��ȿ�մϴ�.*/
		BufferedImage img = (BufferedImage)Originalimg;
		int height = img.getHeight();		//�̹����� ���̸� ���Ѵ�.
		int width = img.getWidth();		//�̹����� ���̸� ���Ѵ�.
		BufferedImage finalThresholdImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB) ;
		//���� �̹����� RGBŸ������ ����.
		
		int red = 0;
		int green = 0;
		int blue = 0;
		
		for (int x = 0; x < width; x++) {
			try {
				for (int y = 0; y < height; y++) {
					int color = img.getRGB(x, y);		//x,y ������ RGB���� ���մϴ�.
					
					red = ImageOperations.getRed(color);		//Red�� ����
					green = ImageOperations.getGreen(color);	//Green�� ����
					blue = ImageOperations.getBlue(color);		//Blue�� ����
						if((red+green+blue)/3 < (int) (ThresholdValue)) {	//������Ȧ�� ����� ���߾� ������ �ȼ� �÷������� ���� �۴ٸ�
							finalThresholdImage.setRGB(x,y,ImageOperations.mixColor(0,0,0));	//�ȼ��� (��)
						}
						else {															//ũ�ٸ�
							finalThresholdImage.setRGB(x,y,ImageOperations.mixColor(255,255,255));		//�ȼ��� (��)
						}
				}
			} catch (Exception e) {		//���ܹ߻��� �޽��� �ޱ�
				 e.getMessage();
			}
		}
		
		return (Image)finalThresholdImage;
	}
	
	public Image BlacknWhite(Image Originalimg) {
		BufferedImage img = (BufferedImage)Originalimg;
		int height = img.getHeight();		//�̹����� ���̸� ���Ѵ�.
		int width = img.getWidth();		//�̹����� ���̸� ���Ѵ�.
		BufferedImage finalThresholdImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		
		//���� �̹����� RGBŸ������ ����.
		int red = 0;
		int green = 0;
		int blue = 0;
		
		for (int x = 0; x < width; x++) {
			try {
				for (int y = 0; y < height; y++) {
					int color = img.getRGB(x, y);		//x,y ������ RGB���� ���մϴ�.
					
					red = ImageOperations.getRed(color);		//Red�� ����
					green = ImageOperations.getGreen(color);	//Green�� ����
					blue = ImageOperations.getBlue(color);		//Blue�� ����
					int cmax = Math.max(Math.max(red,blue), green);
					int graycolor = (color & 0xFF000000) | (cmax << 16) | (cmax << 8) | cmax;
					finalThresholdImage.setRGB(x,y,graycolor);		//�ȼ��� (��)
				}
			} catch (Exception e) {		//���ܹ߻��� �޽��� �ޱ�
				 e.getMessage();
			}
		}
		
		return (Image)finalThresholdImage;
	}

	public Image inverse(Image Originalimg) {
		BufferedImage img = (BufferedImage)Originalimg;
		int height = img.getHeight();		//�̹����� ���̸� ���Ѵ�.
		int width = img.getWidth();		//�̹����� ���̸� ���Ѵ�.
		BufferedImage finalThresholdImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB) ;
		//���� �̹����� RGBŸ������ ����.
		
		int red = 0;
		int green = 0;
		int blue = 0;
		
		for (int x = 0; x < width; x++) {
			try {
				for (int y = 0; y < height; y++) {
					int color = img.getRGB(x, y);		//x,y ������ RGB���� ���մϴ�.
					
					red = ImageOperations.getRed(color);		//Red�� ����
					green = ImageOperations.getGreen(color);	//Green�� ����
					blue = ImageOperations.getBlue(color);		//Blue�� ����
					finalThresholdImage.setRGB(x,y,ImageOperations.mixColor(255-red,255-green,255-blue));		//�ȼ��� (��)
				}
			} catch (Exception e) {		//���ܹ߻��� �޽��� �ޱ�
				 e.getMessage();
			}
		}
		
		return (Image)finalThresholdImage;
	}
	
	private static int mixColor(int red, int green, int blue) {		//RGB �÷��� �ռ�
		return red<<16|green<<8|blue;
	}

	private static int getRed(int color) {		//�ȼ��� RED���� �����͸� ����
		return (color & 0x00ff0000)  >> 16;
	}
	
	private static int getGreen(int color) {	//�ȼ��� Green���� �����͸� ����
		return	(color & 0x0000ff00)  >> 8;
	}
	
	private static int getBlue(int color) {	//�ȼ��� Blue���� �����͸� ����
		return (color & 0x000000ff)  >> 0;
	}
	
}

