package trang;

import java.io.IOException;

import trang.controller.Controller;
import trang.method.GenFile;
import trang.method.GenFileExcel;
import trang.method.ReadJavaFile;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
//       GenFile genfile = new GenFile();
//       genfile.GenValue();
//       genfile.GenMethod();
//
////        ReadJavaFile readJavaFile = new ReadJavaFile();
////        readJavaFile.readJavaFile();
//
//        GenFileExcel genFileExcel = new GenFileExcel();
//        genFileExcel.genFileExcel();

        Controller controller = new Controller();
        controller.menu();
       System.out.print("Complete to gen file");
    }
}
