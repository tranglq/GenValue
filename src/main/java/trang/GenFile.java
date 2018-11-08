package trang;

import java.io.*;
import java.util.List;

import trang.Objects.KeyWordInValue;
import trang.Objects.Package;


public class GenFile {
	private ObjectOutputStream writeob;

	public GenFile() {
		
	}
//	
//	public void GenMethod() throws FileNotFoundException {
//		FileDescription filedes = new FileDescription();
//		filedes.setFileDest("E:\\Project\\MVN\\GenValue\\");
//		filedes.setFileName("methodlist.txt");
//		String linkfile = filedes.getFileDest() + filedes.getFileName();
//		FileOutputStream fileos = new FileOutputStream(linkfile);
//		DataOutputStream dataos = new DataOutputStream(fileos);
//		
//		
//	}
	
	public void GenValue() throws IOException {
		FileDescription filesource = new FileDescription();
		filesource.setFileDest("C:\\Users\\Administrator\\GenValue\\");
		filesource.setFileName("Value.xlsx");
		
		ReadValue readvalue = new ReadValue();
		List<Package> packlist = readvalue.readPackage(filesource);


        KeyWordInValue keyword = new KeyWordInValue();

        int i = 0;
        int filenum = 0;
        while(i < packlist.size()) {

            FileDescription filedes = new FileDescription();
            filedes.setFileDest("");
            filedes.setFileName("values" + "("+filenum+").txt");
            String linkfile = filedes.getFileDest() + filedes.getFileName();

            FileWriter fileos = new FileWriter(new File(linkfile));
//            writeob = new ObjectOutputStream(fileos);


            //In ra các từ khóa và tên package.class khi đây là package đầu tiên
            //hoặc tên package khác tên package trc đó
            //hoặc tên class khác tên class liền trước nó
//            if (i == 0
//                    || packlist.get(i).getPackage() != packlist.get(i - 1).getPackage()
//                    || packlist.get(i).getClassname() != packlist.get(i - 1).getClassname()) {
                fileos.write(keyword.getStart() + "\n");
                fileos.write(keyword.getClassKey() + "\n");
                fileos.write(packlist.get(i).getPackage() + "." + packlist.get(i).getClassname() + "\n");
                fileos.write(keyword.getLit() + "\n");


            System.out.print(keyword.getStart() + "\n");
            System.out.print(keyword.getClassKey() + "\n");
            System.out.print(packlist.get(i).getPackage() + "." + packlist.get(i).getClassname() + "\n");
            System.out.print(keyword.getLit() + "\n");
//            }

            int j = 0;

            //Chạy vòng lặp in ra các giá trị khi:
            // value ko rỗng
            // và
            //hoặc là đây là package duyệt đầu tiên
//            //hoặc là tên class của package này giống tên class của package liền trước nó
//            while (!packlist.get(i).getValues().isEmpty()
//                    && (i == 0
//                        || (packlist.get(i).getClassname().equals(packlist.get(i - 1).getClassname())
//                            && packlist.get(i).getMethod().equals(packlist.get(i - 1).getMethod())))) {
            do{
                if (packlist.get(i).getValues().isEmpty()) break;
                while (j < packlist.get(i).getValues().size()){
                    fileos.write(packlist.get(i).getTypeName() + ":" + packlist.get(i).getValueList(j) + "\n");
                    System.out.print(packlist.get(i).getTypeName() + ":" + packlist.get(i).getValueList(j) + "\n");
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
            System.out.print(keyword.getEnd());
            //In ra từ khóa kết thúc khi
            //Hoặc đây là package cuối
            //Hoặc tên package khác tên package liền sau nó
            //Hoặc tên class khác tên package liền sau nó
//            if (i == (packlist.size()-1) ||
//                    (!packlist.get(i).getPackage().equals(packlist.get(i + 1).getPackage()) ||
//                            !packlist.get(i).getClassname().equals(packlist.get(i + 1).getClassname()))) {
//                fileos.write(keyword.getEnd());
//            }
            fileos.close();
            i++;
            filenum++;
        }


    }
}
