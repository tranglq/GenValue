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

        String data = readFile(fileNameForm.get());
        String[] words = data.split("\\s");
        PackageForm packageForm = new PackageForm();

        String packagename = null;
        String classname = null;
        String methodname = null;
        List<String> type = new ArrayList<>();


        for (int i = 0; i < words.length; i++){


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

            if (classname != null && words[i].equals("public") && i < words.length-1){
                while (!words[i].contains("(")){
                    i++;
                }
                if (words[i].contains("(")){
                    int indexmethod = words[i].indexOf("(");
                    int lengthmethod = words[i].length();
                    if (indexmethod == lengthmethod-1 && indexmethod == 0){
                        methodname = words[i-1] + "(";
                        type.set(0, words[i++]);
                    }
                    else if (indexmethod == lengthmethod && indexmethod != 0){
                            methodname = words[i].substring(0,indexmethod-1) + "(";
                            type.set(0, words[i++]);
                    } else if (indexmethod != lengthmethod && indexmethod == 0 ){
                            methodname = words[i-1] + "(";
                            type.set(0, words[i].substring(indexmethod + 1, lengthmethod - 1));
                    } else {
                            methodname = words[i].substring(0, indexmethod);
                            type.set(0, words[i].substring(indexmethod+1, lengthmethod-1));
                    }




                    int j = 0;
                    while (!words[i].contains(")")){
                        j++;
                        i++;
                        if (words[i].contains(",")){
                            int index = words[i].indexOf(",");
                            int length = words[i].length();
                            if (index == length-1) i++;
                            else {
                                type.set(j, words[i].substring(index + 1, length - 1));
                                j++;
                                i++;
                            }
                        }

                    }
                    for (int k = 0; k < type.size(); k++){
                        methodname = methodname + type.get(k);
                        if (k == type.size()-1) {
                            methodname = methodname + ")";
                        }
                        else {
                            methodname = methodname + ", ";
                        }
                    }

                    for (int k = 0; k < type.size(); k++){
                        packageForm.setPackage(packagename);
                        packageForm.setClass(classname);
                        packageForm.setMethod(methodname);
                        packageForm.setTypeName(type.get(k));
                        packageForms.add(packageForm);

                        System.out.println(packageForm.getPackage() + "\t" + packageForm.getClassname() + "\t" + packageForm.getMethod() + "\t" + packageForm.getValueList(packageForm.getValues().size()));

                        packageForms.add(packageForm);

                    }
                    i++;
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
