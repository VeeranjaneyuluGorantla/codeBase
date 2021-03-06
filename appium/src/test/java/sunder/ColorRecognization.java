package sunder;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class ColorRecognization {

	public static void main(String[] args) throws Exception
	{
		//Color ec=Color.blue; 
		Color ec=new Color(0,0,255);
		File f=new File("D:\\w2sms.PNG");
		BufferedImage bif=ImageIO.read(f);
		int w=bif.getWidth();
		int h=bif.getHeight();
		int count=0;
		for(int i=0;i<w;i++)
		{
			for(int j=0;j<h;j++)
			{
				Color ac=new Color(bif.getRGB(i,j));
		//		System.out.println(i);
			//	System.out.println(j);
				if(ac.getRed()==ec.getRed() &&
					ac.getBlue()==ec.getBlue() &&
					ac.getGreen()==ec.getGreen())
				{
					count=count+1;
				}
			}
		}
		System.out.println("total pixels are:"+(w*h));
		System.out.println("pixels with expected color:"+count);
		double percentage=count*100.0/(w*h);
		System.out.println(percentage);
	}
}
