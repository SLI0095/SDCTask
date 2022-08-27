package com.example.SDCTask;

import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.google.common.math.IntMath.isPrime;

public final class PrimeFinder {


    public static void printPrimesFromFile(String filePath){
        try {
            //open file and create workbook from the file
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(file);

            //get first sheet from the file
            Sheet sheet = workbook.getSheetAt(0);
            for(Row r : sheet){
                //data are always in second column
                Cell cell = r.getCell(1);
                if(cell.getCellType() == CellType.STRING){
                    processString(cell.getStringCellValue());
                }
            }
            workbook.close();
            file.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (NotOfficeXmlFileException e) {
            System.out.println("File not Office XML!");
        } catch (IOException e) {
            System.out.println("Unable to read file!");
        }

    }

    private static void processString(String data){
        try {
            int number = Integer.parseUnsignedInt(data);
            if(isPrime(number)){
                //print number on console
                System.out.println(number);
            }
        } catch (NumberFormatException ignored) { //ignoring strings other than unsigned integers
        }
    }
}
