package utility;

import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader extends E2ELogger{

    static FileInputStream file = null;

    public FileInputStream getFileInputStream(){

        String filePath = System.getProperty("user.dir")+"/src/test/resources/userData.xlsx";
        File srcFile = new File(filePath);

        try {
            file = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error Message For File Not Found: " +e.getMessage());
            System.exit(0);
        }
        return file;
    }

    public Object [] [] getExcelData() throws IOException {
        file = getFileInputStream();
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int TotalNumberOfRows = (sheet.getLastRowNum()+1);
        int TotalNumberOfColumns = 2;

        String [] [] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfColumns];

        for (int i = 0; i < TotalNumberOfRows; i++)
        {
            for (int j = 0; j < TotalNumberOfColumns; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();


            }
        }

        workbook.close();
        return arrayExcelData;
    }
}
