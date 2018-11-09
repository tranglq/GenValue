package trang;

import java.io.IOException;
import trang.method.GenFile;
import trang.method.ReadJavaFile;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
       GenFile genfile = new GenFile();
       genfile.GenValue();
       genfile.GenMethod();

        ReadJavaFile readJavaFile = new ReadJavaFile();
        readJavaFile.readJavaFile();
       System.out.print("Complete to gen file");
    }
}
