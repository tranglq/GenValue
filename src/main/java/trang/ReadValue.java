package trang;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import trang.FileDescription;
import trang.Objects.Package;

public class ReadValue {
	
	private XSSFWorkbook  workbook;
	private CellType celltype;
	private Package pack = new Package();

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
                            if (indexcol==4) pack.setValue(value);
							else if (indexcol==5) pack.setValue(value);
							else if (indexcol==6) pack.setValue(value);
							else if (indexcol==7) pack.setValue(value);
							else if (indexcol==8) pack.setValue(value);
							else if (indexcol==9) pack.setValue(value);
							else if (indexcol== 10) pack.setValue(value);

//					case _NONE:
//						break;
//					case STRING:
//						String value = cell.getStringCellValue();
//						int indexcol = cell.getColumnIndex();
//						if (indexcol == 0) pack.setPackage(value);
//						else if (indexcol==1) pack.setClass(value);
//						else if (indexcol==2) pack.setMethod(value);
//						else if (indexcol==3) pack.setTypeName(value);
//						case NUMERIC:
//							String value = cell.getStringCellValue();
//							int indexcol = cell.getColumnIndex();
//							if (indexcol==4) pack.setValue(value);
//							else if (indexcol==5) pack.setValue(value);
//							else if (indexcol==6) pack.setValue(value);
//							else if (indexcol==7) pack.setValue(value);
//							else if (indexcol==8) pack.setValue(value);
//							else if (indexcol==9) pack.setValue(value);
//							else if (indexcol== 10) pack.setValue(value);
					}
						


				}
				packlist.add(pack);
			}
			input.close();
		}
		
		return packlist;
	}
	
}
