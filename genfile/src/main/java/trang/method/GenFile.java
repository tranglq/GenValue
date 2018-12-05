package trang.method;

import java.io.*;
import java.util.List;

import trang.form.FileNameForm;
import trang.form.KeyWordInValueForm;
import trang.form.PackageForm;


public class GenFile {

    public GenFile() {
		
	}

	public void GenMethod() throws IOException {
		List<PackageForm> packages = ReadFile();

//        int i = 0;
//        int filenum = 0;
//        while(i < packages.size()) {
//
//            FileNameForm filedes = new FileNameForm();
//            filedes.setFileDest("");
//            filedes.setFileName("values" + "(" + filenum + ").txt");
//            String linkfile = filedes.getFileDest() + filedes.getFileName();
//
//            FileWriter fileos = new FileWriter(new File(linkfile));
//
//
//        }

        FileNameForm filedes = new FileNameForm();
        filedes.setFileDest("");
        filedes.setFileName("method.txt");
        String linkfile = filedes.getFileDest() + filedes.getFileName();
        FileWriter fileos = new FileWriter(new File(linkfile));
        for (int i = 0; i <packages.size(); i++){

            fileos.write(packages.get(i).writeMethod() + "\n");
        }

        fileos.close();
	}
	
	public void GenValue() throws IOException {

		List<PackageForm> packlist = ReadFile();


        KeyWordInValueForm keyword = new KeyWordInValueForm();

        int i = 0;
        int filenum = 0;
        while(i < packlist.size()) {

            FileNameForm filedes = new FileNameForm();
            filedes.setFileDest("");
            filedes.setFileName("values" + "("+filenum+").txt");
            String linkfile = filedes.getFileDest() + filedes.getFileName();

            FileWriter fileos = new FileWriter(new File(linkfile));

            //In ra các từ khóa và tên package.class khi đây là package đầu tiên
            //hoặc tên package khác tên package trc đó
            //hoặc tên class khác tên class liền trước nó
            fileos.write(keyword.getStart() + "\n");
            fileos.write(keyword.getClassKey() + "\n");
            fileos.write(packlist.get(i).getPackage() + "." + packlist.get(i).getClassname() + "\n");
            fileos.write(keyword.getLit() + "\n");
//
//
//            System.out.print(keyword.getStart() + "\n");
//            System.out.print(keyword.getClassKey() + "\n");
//            System.out.print(packlist.get(i).getPackage() + "." + packlist.get(i).getClassname() + "\n");
//            System.out.print(keyword.getLit() + "\n");


            int j = 0;

            //Chạy vòng lặp in ra các giá trị khi:
            // value ko rỗng
            // và
            //hoặc là đây là package duyệt đầu tiên
//            //hoặc là tên class của package này giống tên class của package liền trước nó

            do{
                if (packlist.get(i).getValues().isEmpty()) break;
                while (j < packlist.get(i).getValues().size()){
                    fileos.write(packlist.get(i).getTypeName() + ":" + packlist.get(i).getValueList(j) + "\n");
//                    System.out.print(packlist.get(i).getTypeName() + ":" + packlist.get(i).getValueList(j) + "\n");
                    j++;
                }
                if (i == packlist.size()-1) break;
                else {
                    if (packlist.get(i).getClassname().equals(packlist.get(i + 1).getClassname())
                            && packlist.get(i).getMethod().equals(packlist.get(i + 1).getMethod())){
                        i++;
                        j=0;
                        continue;
                    }
                    else break;
                }
            }  while (i == 0
                    || (packlist.get(i).getClassname().equals(packlist.get(i - 1).getClassname())
                    && packlist.get(i).getMethod().equals(packlist.get(i - 1).getMethod())));
            fileos.write(keyword.getEnd());
//            System.out.print(keyword.getEnd());
            //In ra từ khóa kết thúc khi
            //Hoặc đây là package cuối
            //Hoặc tên package khác tên package liền sau nó
            //Hoặc tên class khác tên package liền sau nó

            fileos.close();
            i++;
            filenum++;
        }
    }

    public static List<PackageForm> ReadFile() throws IOException {
        FileNameForm filesource = new FileNameForm();
        filesource.setFileDest("C:\\Users\\Administrator\\GenValue\\");
        filesource.setFileName("Value.xlsx");
        ReadValue readvalue = new ReadValue();
        return readvalue.readPackage(filesource);

    }
}
