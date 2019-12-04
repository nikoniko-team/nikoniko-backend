package br.com.senac.nikoniko.controllers;

import br.com.senac.nikoniko.dtos.EntryDto;
import br.com.senac.nikoniko.response.Response;
import br.com.senac.nikoniko.services.ReportService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Api para CRUD de humor")
@RequestMapping("/report")
@CrossOrigin(origins = "*")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/{teamId}/monthly")
    public ResponseEntity<Response<List<EntryDto>>> getMonthlyReport(@PathVariable("teamId") Long teamId) {
        var response = new Response<List<EntryDto>>();

        response.setData(reportService.getMonthlyReport(teamId));

        return ResponseEntity.ok(response);
    }

}
