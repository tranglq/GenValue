package trang.method;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import trang.form.FileNameForm;
import trang.form.PackageForm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadJavaFile {
    public List<PackageForm> readJavaFile() throws IOException{
        List<PackageForm> packageForms = new ArrayList<>();
        FileNameForm fileNameForm = new FileNameForm();
        fileNameForm.setFileDest("");
        fileNameForm.setFileName("javafile.java");

        String data = readFile(fileNameForm.get());

        String[] words = data.split("\\s");
        PackageForm packageForm = new PackageForm();
        int methodnum = 0;
        for (int i = 0; i < words.length; i++){
            String packagename = null;
            String classname = null;

            // Neu tu khoa la package thi chuoi ke tiep la ten cua package
            if (words[i].equals("package")){
                i++;
                int lengthPackName = (words[i]).length();
                packagename = words[i].substring(0, lengthPackName-1); //lay chuoi package bo di kyy tu ";" o cuoi chuoi
//                packageForm.setPackage(packagename);
                System.out.println(packageForm.getPackage());
            }

            if (words[i].equals("class")){
                i++;
                classname = words[i];
//                packageForm.setClass(words[i]);
                System.out.println(packageForm.getClassname());
            }

            if (words[i].equals("public")){
                i++;
                if (words[i].equals("static")){
                    i++;
                }

                if (methodnum != 0){
                    PackageForm packageForm1 = new PackageForm();
                    packageForm1.setPackage(packageForm.getPackage());
                    packageForm1.setClass(packageForm.getClassname());

                    int indexSymbol1 = words[i].indexOf("(");
                    int indexSymbol2 = words[i].indexOf(")");
                    String methodname = words[i].substring(0, indexSymbol1);
                    packageForm1.setMethod(methodname);
                    String values = words[i].substring(indexSymbol1+1, indexSymbol2);
                    String[] valuelist = values.split(",");
                }
                int indexSymbol1 = words[i].indexOf("(");
                int indexSymbol2 = words[i].indexOf(")");
                String methodname = words[i].substring(0, indexSymbol1);
                packageForm.setMethod(methodname);
                String values = words[i].substring(indexSymbol1+1, indexSymbol2);
                String[] valuelist = values.split(",");

                for (int j = 0; j < valuelist.length; j++){

                }
            }
        }
        return packageForms;
    }


    public String readFile(String filepathname) throws IOException {

        String data = "";
        data = new String(Files.readAllBytes(Paths.get(filepathname)));
        return data;
    }
}
