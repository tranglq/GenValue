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


        for (int i = 0; i < words.length; i++){
            String packagename = null;
            String classname = null;
            String methodname = null;
            List<String> type = new ArrayList<>();

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

            if (words[i].equals("public") && i < words.length-1){
                i++;
                if (words[i].equals("static") && i < words.length-1){
                    i++;
                }
                int indexSymbol1 = words[i].indexOf("(");
                int indexSymbol2 = words[i].indexOf(")");
                methodname = words[i].substring(0, indexSymbol1) + "(";
//                packageForm.setMethod(method);
                String breakString = words[i].substring(indexSymbol1+1, indexSymbol2-1);
                String[] breakStringList = breakString.split(",");

                for (int j = 0; j < breakStringList.length; j++){
                    String [] types = breakStringList[j].split("\\s");
                    type.add(types[0]);
                    methodname = methodname + types[0];
                    if (j <breakStringList.length-1) methodname = methodname + ",";
                    else   methodname = methodname + ")";
                }


                for (int j = 0; j < breakStringList.length; j++){
                    String [] types = breakStringList[j].split("\\s");
                    type.add(types[0]);
                    packageForm.setPackage(packagename);
                    packageForm.setClass(classname);
                    packageForm.setMethod(methodname);
                    packageForm.setTypeName(types[0]);
                    packageForms.add(packageForm);
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
