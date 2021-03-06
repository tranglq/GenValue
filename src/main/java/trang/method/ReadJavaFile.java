package trang.method;

import trang.form.FileNameForm;
import trang.form.PackageForm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadJavaFile {
    public List<PackageForm> readJavaFile(String pathfile) throws IOException{
        List<PackageForm> packageForms = new ArrayList<>();
        FileNameForm fileNameForm = new FileNameForm();

        String data = fileNameForm.readFile(pathfile);
        String[] words = data.split("\\s");


        String packagename = null;
        String classname = null;
        String methodname = null;
        List<String> type = new ArrayList<>();


        for (int i = 0; i < words.length; i++){

            // Neu tu khoa la package thi chuoi ke tiep la ten cua package
            if (words[i].equals("package")){
                i++;
                int lengthPackName = (words[i]).length();

                if (lengthPackName<1) packagename = null;
                else packagename = words[i].substring(0, lengthPackName-1); //lay chuoi package bo di kyy tu ";" o cuoi chuoi
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
                        PackageForm packageForm = new PackageForm();
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
                            PackageForm packageForm = new PackageForm();
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
