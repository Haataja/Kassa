package fi.haataja.kassa;


import com.badlogic.gdx.Gdx;
import fi.haataja.kassa.Products.Product;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {
    public ExcelWriter(){

    }

    public void write(Product product) throws InvalidFormatException, IOException {
        Workbook workbook = WorkbookFactory.create(new File("excel/existing-spreadsheet.xlsx"));
        Sheet sheet = workbook.getSheetAt(product.CATEGORY);

        boolean goingThoughCellsOnRows = true;
        int rowNumber = 0;
        while(goingThoughCellsOnRows){
            if(sheet.getRow(rowNumber) == null){
                sheet.createRow(rowNumber);
            }
            Row row = sheet.getRow(rowNumber);
            if(row.getCell(0) == null){

                row.createCell(0);
                row.getCell(0).setCellType(CellType.STRING);
                row.getCell(0).setCellValue(product.getTime());
                row.createCell(1);
                row.getCell(1).setCellType(CellType.STRING);
                row.getCell(1).setCellValue(product.getName());
                row.createCell(2);
                row.getCell(2).setCellType(CellType.NUMERIC);
                row.getCell(2).setCellValue(product.getPrice());
                goingThoughCellsOnRows = false;
                Gdx.app.log("EXCEL", "I wrote " + product.toString());
            }
            rowNumber++;
        }
        FileOutputStream fileOut = new FileOutputStream("excel/new.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
}
