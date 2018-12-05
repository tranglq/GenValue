package trang.method;

import trang.form.FileNameForm;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrowserFolder extends IOException {

    public List<String> javalist = new ArrayList<>();
//    public final File path;

    public List<String> browserFolder(String pathfolder){
//        List<String> javalist = new ArrayList<>();
        File path = new File(pathfolder);

        File[] files = path.listFiles();

        if (files == null) System.out.println("No exist file in folder");
        else{
            for (int i =0; i < files.length;i++){
                if (files[i].isDirectory()){
                    return browserFolder(files[i].getAbsolutePath());
                }
                else if (files[i].getAbsolutePath().endsWith(".java")){
                    String javafilename = new String(files[i].getAbsolutePath());
                    javalist.add(javafilename);
                }
            }

        }
        return  javalist;
    }
//
//    public List<String> browser(File file) {
//        if (file.isDirectory()) {
//            File path = new File(file.getAbsolutePath());
//            File[] files = path.listFiles();
//
//            if (files == null) System.out.println("No exist file in folder");
//            else {
//                for (int i = 0; i < files.length; i++) {
//                    if (files[i].isDirectory()) return browserFolder(files[i].getAbsolutePath());
//                    else if (files[i].getAbsolutePath().endsWith(".java")) {
//                        String javafilename = new String(files[i].getAbsolutePath());
//                        javalist.add(javafilename);
//                    }
//                }
//            }
//        }
//
//        return javalist
//    }
}
