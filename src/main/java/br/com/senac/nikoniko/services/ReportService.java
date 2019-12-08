package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.EntryDto;
import br.com.senac.nikoniko.dtos.QuarterDto;
import br.com.senac.nikoniko.dtos.TagReportDto;

import java.util.List;

public interface ReportService {

    List<EntryDto> getMonthlyReport(Long teamId);

    List<QuarterDto> getQuarterReport(Long teamId);

    List<TagReportDto> getTagCloud();
}
