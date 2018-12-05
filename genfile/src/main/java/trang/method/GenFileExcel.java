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

    public void genFileExcel(String excelfilename, List<PackageForm> list) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Value");

        int rownum = 0;
        Cell cell;
        Row row;
        //
//        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        // EmpNo
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Package");
//        cell.setCellStyle(style);
        // EmpName
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Class");
//        cell.setCellStyle(style);
        // Salary
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Method");
//        cell.setCellStyle(style);
        // Grade
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Type");
//        cell.setCellStyle(style);
        // Bonus
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Value");
//        cell.setCellStyle(style);

        // Data
        if (!list.isEmpty())
        {

            for (int i = 0; i< list.size(); i++) {
                rownum++;
                row = sheet.createRow(rownum);

                // EmpNo (A)
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(list.get(i).getPackage());
                // EmpName (B)
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(list.get(i).getClassname());
                // Salary (C)
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(list.get(i).getMethod());
                // Grade (D)
//                if (!list.get(i).getTypeName().isEmpty()) {
                    cell = row.createCell(3, CellType.STRING);
                    cell.setCellValue(list.get(i).getTypeName());
//                }
            }
        }

        FileNameForm fileNameForm = new FileNameForm();        fileNameForm.setFileDest("");
        fileNameForm.setFileName(excelfilename);
        File file = new File(fileNameForm.get());
//        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());

    }

//    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
//        HSSFFont font = workbook.createFont();
//        font.setBold(true);
//        HSSFCellStyle style = workbook.createCellStyle();
//        style.setFont(font);
//        return style;
//    }
}
