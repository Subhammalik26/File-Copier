import java.util.*;
import java.io.*;

public class FileCopier 
     {
	public static void main(String[] args) throws IOException 
        {
		Scanner f = new Scanner(System.in);
                System.out.println("Please Enter the InputPath:-");
		String inputPath=f.nextLine();
                System.out.println("Please enter the OutputPath:-");
		String outputPath=f.nextLine();
                System.out.println("Please enter File Name:-");
		String fileName=f.nextLine();
                fileCopy(inputPath, outputPath, fileName);
			
	}
        static void fileCopy(String inputPath,String outputPath,String fileName) throws FileNotFoundException, IOException
        {
            
                    File inputFile=new File(inputPath+"\\"+fileName);
                    File outputFile=new File(outputPath+"\\"+fileName);
                    File temp=null;
                    FileReader readFile=null;
                    FileWriter writeFile=null;
			
			readFile = new FileReader(inputPath+"\\"+fileName);
					
			if(inputFile.exists())
                              {
				if(outputFile.exists())
                                     {
			
					temp = new File(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy"+fileName.substring(fileName.indexOf("."),fileName.length()));
					
					if(temp.exists())
                                              {
						int i=2;
						int c;
						while(true)
                                                {
							temp = new File(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy ("+i+")"+fileName.substring(fileName.indexOf("."),fileName.length()));
							if(!temp.exists())
                                                        {
								break;
							}
							i++;
						}
						writeFile = new FileWriter(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy ("+i+")"+fileName.substring(fileName.indexOf("."),fileName.length()));
						while((c=readFile.read())!=-1)
                                                {
							writeFile.write(c);
						}
						System.out.println("File Copied Successfully.");
					}
                                         else
                                        {
						int c;
						writeFile = new FileWriter(outputPath+"\\"+fileName.substring(0,fileName.indexOf("."))+" - Copy"+fileName.substring(fileName.indexOf("."),fileName.length()));
						while((c=readFile.read())!=-1)
                                                {
							writeFile.write(c);
						}
						System.out.println("File Copied Successfully.");
					}
				}
                                else
                                {
					int c;
					writeFile = new FileWriter(outputPath+"\\"+fileName);
					while((c=readFile.read())!=-1)
                                        {
						writeFile.write(c);
					}
					System.out.println("File Copied Successfully.");
				}
			}
                        else
                        {
				System.out.println("File Not Found.");
			}
			
			readFile.close();
			writeFile.close();
		
        }
}
