package testing;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;

public class Xls_File {

	public static void main(String[] args)throws Exception
	{
		//open .xls file for reading
		File f=new File("Book1.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);// 0 means 1 sheet
		int nour=rsh.getRows();
		//open same excel file writing
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh=wwb.getSheet(0);//0 means sheet 1
		//data driven from 2nd row/index is 1
		// 1st row (index is 0) have names of columns
		for(int i=1;i<nour;i++)
		{
			int x=Integer.parseInt(rsh.getCell(0, i).getContents());
			int y=Integer.parseInt(rsh.getCell(1,i).getContents());
			int z=x+y;
			Number n=new Number(2,i,z);
			wsh.addCell(n);
		}
		// save excel file
		wwb.write();
		rwb.close();
		wwb.close();
		
	}

}
