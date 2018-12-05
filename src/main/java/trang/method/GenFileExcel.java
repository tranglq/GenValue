package trang.method;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import trang.form.FileNameForm;
import trang.form.PackageForm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class GenFileExcel {

    public void genFileExcel(List<String> pathlist) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Value");

        int rownum = 0;
        Cell cell;
        Row row;
        row = sheet.createRow(rownum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Package");

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Class");

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Method");

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Type");

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Value");

        for (int j =0; j <pathlist.size(); j++) {
            try {
                ReadJavaFile readJavaFile = new ReadJavaFile();
                List<PackageForm> list = readJavaFile.readJavaFile(pathlist.get(j));
                // Data
                if (!list.isEmpty()) {

                    for (int i = 0; i < list.size(); i++) {
                        rownum++;
                        row = sheet.createRow(rownum);

                        // Package(A)
                        cell = row.createCell(0, CellType.STRING);
                        cell.setCellValue(list.get(i).getPackage());
                        // Class (B)
                        cell = row.createCell(1, CellType.STRING);
                        cell.setCellValue(list.get(i).getClassname());
                        // method (C)
                        cell = row.createCell(2, CellType.STRING);
                        cell.setCellValue(list.get(i).getMethod());
                        // type (D)
                        cell = row.createCell(3, CellType.STRING);
                        cell.setCellValue(list.get(i).getTypeName());

                    }
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileNameForm fileNameForm = new FileNameForm();
        fileNameForm.setFileDest("");
        fileNameForm.setFileName("Excel.xlsx");
        File file = new File(fileNameForm.get());

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());

    }

}
