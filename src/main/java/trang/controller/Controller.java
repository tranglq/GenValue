package trang.controller;

import trang.form.FileNameForm;
import trang.form.PackageForm;
import trang.method.JavaFilter;

import java.io.File;
import java.util.Scanner;

public class Controller {
    public FileNameForm fileNameForm = new FileNameForm();

    public void menu(){

    }

    public void browserFolder(String direction){

        File dir = new File(direction); 
        File[] javaFiles = dir.listFiles(new JavaFilter());
 
        for (File txtFile : javaFiles) {
            System.out.println(txtFile.getAbsolutePath());
        }
    }



}
