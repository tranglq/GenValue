package trang.controller;

import trang.form.FileNameForm;
import trang.form.PackageForm;
import trang.method.BrowserFolder;
import trang.method.GenFile;
import trang.method.GenFileExcel;
import trang.method.ReadJavaFile;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Controller {

    public void menu() throws IOException {
        int value;
        System.out.println("0.Gen XLS file;     1.Gen TXT file;     2-n.Exit");
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextInt();
        while (value!=2){
            if(value==0) GenFileXLS();
            else if (value==1) GenFileTxt();
            System.out.println("0.Gen XLS file;     1.Gen TXT file;     2-n.Exit");
            scanner = new Scanner(System.in);
            value = scanner.nextInt();
        }

    }

    public void GenFileXLS() throws IOException {
        String folderPath;

        folderPath = "./genfile/";
        BrowserFolder brFolder = new BrowserFolder();
        List<String> pathlist = brFolder.browserFolder(folderPath);


        for (int i =0; i <pathlist.size(); i++){
            try {
                GenFileExcel genFileExcel = new GenFileExcel();
                genFileExcel.genFileExcel(pathlist);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        GenFile genfile = new GenFile();
        genfile.GenValue();
        genfile.GenMethod();
        genfile.GenClass();
    }

    public void GenFileTxt() throws IOException {
        GenFile genfile = new GenFile();
        genfile.GenValue();
        genfile.GenMethod();
        genfile.GenClass();
    }


}
