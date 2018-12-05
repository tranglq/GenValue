package trang.controller;

import trang.form.FileNameForm;
import trang.form.PackageForm;
import trang.method.BrowserFolder;
import trang.method.GenFileExcel;
import trang.method.ReadJavaFile;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Controller {

    public void menu(){
        String folderPath;
//        String saveExcel;
//        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter java folder path: ");
//        folderPath = scanner.nextLine();
//        saveExcel = scanner.nextLine();
        folderPath = "./";
        BrowserFolder brFolder = new BrowserFolder();
        List<String> pathlist = brFolder.browserFolder(folderPath);


        for (int i =0; i <pathlist.size(); i++){
            try {
                ReadJavaFile readJavaFile = new ReadJavaFile();
                List<PackageForm> list = readJavaFile.readJavaFile(pathlist.get(i));
                GenFileExcel genFileExcel = new GenFileExcel();
                genFileExcel.genFileExcel("ExcelFile("+ i + ").xlsx", list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
