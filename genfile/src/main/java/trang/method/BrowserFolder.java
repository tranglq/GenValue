package trang.method;

import trang.form.FileNameForm;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrowserFolder extends IOException {
    public List<String> browserFolder(String pathfolder){
        List<String> javalist = new ArrayList<>();
        File path = new File(pathfolder);

        File[] files = path.listFiles();

        if (files == null) System.out.println("No exist file in folder");
        else{
            for (File checkfile: files){
                if (checkfile.isDirectory()) return browserFolder(checkfile.getAbsolutePath());
                else if (checkfile.getAbsolutePath().endsWith(".java")){
                    String javaname = checkfile.getAbsolutePath();
                    javalist.add(javaname);
                }
            }
        }


//        File[] folderfile = path.listFiles(new FolderFile());
//        if (folderfile == null){
//            System.out.println("Not exist file in folder!");
//        }
//        else {
//            for (File isfolderfile : folderfile) {
//                if (isfolderfile.isDirectory()) return browserFolder(isfolderfile.getAbsolutePath());
//            }
//        }
//
//        File[] isjavafile = path.listFiles(new JavaFileFilter());
//        if (isjavafile == null){
//            System.out.println("Not exist java file in folder!");
//        }
//        else {
//            for (File javafile : isjavafile) {
//                javalist.add(javafile.getAbsolutePath());
//                System.out.println(javafile.getAbsolutePath());
//            }
//        }

        return  javalist;
    }


}
