package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.EntryDto;

import java.util.List;

public interface ReportService {

    List<EntryDto> getMonthlyReport(Long teamId);

}
