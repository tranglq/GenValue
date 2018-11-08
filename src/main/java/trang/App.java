package trang;

import java.io.IOException;
import trang.GenFile;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
       GenFile genfile = new GenFile();
       genfile.GenValue();
       genfile.GenMethod();
       System.out.print("Complete to gen file");
    }
}
