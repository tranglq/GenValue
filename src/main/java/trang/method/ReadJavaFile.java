package trang.method;

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

        String data = fileNameForm.readFile();
        String[] words = data.split("\\s");
        PackageForm packageForm = new PackageForm();

        String packagename = null;
        String classname = null;
        String methodname = null;
        List<String> type = new ArrayList<>();


        for (int i = 0; i < words.length; i++){

            type.clear();
            // Neu tu khoa la package thi chuoi ke tiep la ten cua package
            if (words[i].equals("package")){
                i++;
                int lengthPackName = (words[i]).length();
                packagename = words[i].substring(0, lengthPackName-1); //lay chuoi package bo di kyy tu ";" o cuoi chuoi
            }

            if (words[i].equals("class")){
                i++;
                classname = words[i];
            }

            if (classname != null && words[i].equals("public") && i < words.length-1){
                while (!words[i].contains("(")){
                    i++;
                }
                if (words[i].contains("(")){
                    int indexmethod = words[i].indexOf("(");
                    int lengthmethod = words[i].length();
                    if (words[i].contains(")")){
                        methodname = words[i].substring(0, indexmethod) + "()";
                        type.clear();

                    }
                    else {

                        if (indexmethod == lengthmethod-1 && indexmethod == 0){
                            methodname = words[i-1] + "(";
                            String a = words[i++];
                            type.add(a);
                        }
                        else if (indexmethod == lengthmethod && indexmethod != 0){
                            methodname = words[i].substring(0,indexmethod) + "(";
                            String a = words[i++];
                            type.add(a);
                        } else if (indexmethod != lengthmethod && indexmethod == 0 ){
                            methodname = words[i-1] + "(";
                            String a = words[i].substring(indexmethod + 1, lengthmethod);
                            type.add(a);
                        } else {
                            methodname = words[i].substring(0, indexmethod) + "(";
                            String a = words[i].substring(indexmethod+1, lengthmethod);
                            type.add(a);
                        }
                        i++;
                    }

                    while (!words[i].contains(")")){
                        i++;
                        if (words[i].contains(",")){
                            int index = words[i].indexOf(",");
                            int length = words[i].length();

                            if (index == length-1 && index == 0){
                                String a = words[i++];
                                type.add(a);
                            }
                            else if (index == length-1 && index != 0){
                                String a = words[i++];
                                type.add(a);
                            }
                            else if (index != length && index == 0 ){
                                String a = words[i].substring(index + 1, length);
                                type.add(a);
                            } else {
                                String a = words[i].substring(index+1, length);
                                type.add(a);
                            }
                            i++;

                        }
                        else {
                            i++;
                        }
                    }

                    if (type.isEmpty()){
                        packageForm.setPackage(packagename);
                        packageForm.setClass(classname);
                        packageForm.setMethod(methodname);
                        packageForms.add(packageForm);
                        System.out.println(packageForm.getPackage() + "\t" + packageForm.getClassname() + "\t" + packageForm.getMethod() );

                    }
                    else {
                        for (int k = 0; k < type.size(); k++){
                            methodname = methodname + type.get(k);
                            if (k == type.size()-1) {
                                methodname = methodname + ")";
                            }
                            else {
                                methodname = methodname + ", ";
                            }
                        }
                        for (int k = 0; k < type.size(); k++) {
                            packageForm.setPackage(packagename);
                            packageForm.setClass(classname);
                            packageForm.setMethod(methodname);
                            packageForm.setTypeName(type.get(k));
                            packageForms.add(packageForm);

                            System.out.println(packageForm.getPackage() + "\t" + packageForm.getClassname() + "\t" + packageForm.getMethod() + "\t" + type.get(k));
                        }

                    }

                    i++;
                }

            }
        }
        return packageForms;
    }
}
