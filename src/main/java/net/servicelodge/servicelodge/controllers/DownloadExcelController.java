package net.servicelodge.servicelodge.controllers;

import net.servicelodge.servicelodge.services.ExcelFileExporter;
import net.servicelodge.servicelodge.services.ReservationsService;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
public class DownloadExcelController
{
    private final ReservationsService reservationsService;

    public DownloadExcelController(ReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    @GetMapping("/download/reservation.xlsx")
    public void downloadExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment; filename=Reservation.xlsx");

        ByteArrayInputStream inputStream = ExcelFileExporter.exportUserListToExcelFile(reservationsService.getReservations());

        IOUtils.copy(inputStream, response.getOutputStream());
    }
}
