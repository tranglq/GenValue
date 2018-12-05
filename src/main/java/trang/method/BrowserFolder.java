package trang.method;

import trang.form.FileNameForm;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrowserFolder extends IOException {

    public List<String> javalist = new ArrayList<>();
    public List<String> folderlist = new ArrayList<>();
    public int i=0;
    public File path;

    public List<String> browserFolder(String pathfolder){
//        List<String> javalist = new ArrayList<>();
        path = new File(pathfolder);

        File[] files = path.listFiles();

        if (files == null) System.out.println("No exist file in folder");
        else{
            for (int i =0; i < files.length;i++){
                if (files[i].isDirectory()){
                    folderlist.add(files[i].getAbsolutePath());

                }
                else if (files[i].getAbsolutePath().endsWith(".java")){
                    String javafilename = files[i].getAbsolutePath();
                    javalist.add(javafilename);
                }
            }

        }
        if (!folderlist.isEmpty()) {
            String p = folderlist.get(0);
            folderlist.remove(0);
            return browserFolder(p);
        }
        else return  javalist;
    }
}
