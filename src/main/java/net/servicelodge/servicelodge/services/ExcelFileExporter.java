package net.servicelodge.servicelodge.services;

import net.servicelodge.servicelodge.models.Reservation;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ExcelFileExporter
{
    public static ByteArrayInputStream exportUserListToExcelFile(List<Reservation> reservations)
    {
        try(Workbook workbook = new XSSFWorkbook())
        {
            Sheet sheet = workbook.createSheet("Reservation");

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            XSSFFont font = (XSSFFont) workbook.createFont();
            font.setBold(true);
            font.setFontHeight(16);
            font.setColor(IndexedColors.WHITE.getIndex());

            headerCellStyle.setFont(font);

            // Creating header cells
            Cell cell = row.createCell(0);
            cell.setCellValue("Reservation Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Drill Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("Unit Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(3);
            cell.setCellValue("First Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(4);
            cell.setCellValue("Last Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(5);
            cell.setCellValue("Hotel Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(6);
            cell.setCellValue("Hotel Address");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(7);
            cell.setCellValue("Hotel Check In Date");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(8);
            cell.setCellValue("Hotel Check Out Date");
            cell.setCellStyle(headerCellStyle);

            // Creating data row for each of user object

            int count = 0;
            for(Reservation res : reservations)
            {
                // plus one to exclude the header row
                Row dataRow = sheet.createRow(count + 1);
                dataRow.createCell(0).setCellValue(res.getResNum());
                dataRow.createCell(1).setCellValue(res.getDrill().getName());
                dataRow.createCell(2).setCellValue(res.getUser().getUnit().getUnitName());
                dataRow.createCell(3).setCellValue(res.getUser().getFirstName());
                dataRow.createCell(4).setCellValue(res.getUser().getLastName());
                dataRow.createCell(5).setCellValue(res.getHotel().getName());
                dataRow.createCell(6).setCellValue(res.getHotel().getAddress());
                String date1 = String.valueOf(res.getDrill().getDrillStartDate());
                LocalDate parsedDate1 = LocalDate.parse(date1);
                LocalDate subtractedDate = parsedDate1.minusDays(1);
                String subtractedOneDay = String.valueOf(subtractedDate);
                dataRow.createCell(7).setCellValue(subtractedOneDay);
                String date2 = String.valueOf(res.getDrill().getDrillEndDate());
                String addedOneDay = String.valueOf(date2);
                dataRow.createCell(8).setCellValue(addedOneDay);

                count++;
            }

            // Make suer the size of Excel cell auto resize to fit the data
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);
            sheet.autoSizeColumn(8);
            sheet.setHorizontallyCenter(true);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            return new ByteArrayInputStream(outputStream.toByteArray());
        }
        catch(IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}

