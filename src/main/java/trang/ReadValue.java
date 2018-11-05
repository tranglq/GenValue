package trang;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import trang.Objects.Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadValue {
	
	private XSSFWorkbook  workbook;
	private CellType celltype;
	private Package pack;

	public ReadValue() {
		
	}
	
	public boolean CheckFile(FileDescription filedes) {
		File fo = new File(filedes.getFileDest());
		
			if(fo.exists()) {
				File file = new File(filedes.getFileDest()+filedes.getFileName());
				if(file.exists()) return true;
				else return false;
			}
			else return false;
		
	}

	// đọc file .xlsx
	public List<Package> readPackage(FileDescription filedes) throws IOException {
		List<Package> packlist = new ArrayList<>();
		if(CheckFile(filedes)) {
			FileInputStream input = new FileInputStream(new File(filedes.getFileDest()+filedes.getFileName()));
			workbook = new XSSFWorkbook (input);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			Iterator<Row> rowiterator = sheet.iterator();
			
			while(rowiterator.hasNext()) {
				Row row = rowiterator.next();
				Iterator<Cell> celliterator = row.cellIterator();
				pack = new Package();
				if (row.getRowNum()==0) continue;
				
				while(celliterator.hasNext()) {
					Cell cell = celliterator.next();

					celltype = cell.getCellType();
					
					switch (celltype) {
                        case _NONE:
                            break;
                        case STRING:
                            String valuename = cell.getStringCellValue();
                            int indexcolname = cell.getColumnIndex();
                            if (indexcolname == 0) pack.setPackage(valuename);
                            else if (indexcolname==1) pack.setClass(valuename);
                            else if (indexcolname==2) pack.setMethod(valuename);
                            else if (indexcolname==3) pack.setTypeName(valuename);
                        case NUMERIC:
                            cell.setCellType(CellType.STRING);
                            String value = cell.getStringCellValue();
                            int indexcol = cell.getColumnIndex();
                            if (indexcol>=4 && indexcol <=10) pack.setValue(value);
					}
				}
				packlist.add(pack);
			}
			input.close();
		}
		
		return packlist;
	}
	
}
