package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.EntryDto;
import br.com.senac.nikoniko.dtos.QuarterDto;
import br.com.senac.nikoniko.dtos.TagReportDto;
import br.com.senac.nikoniko.repositories.MoodRepository;
import br.com.senac.nikoniko.repositories.RecordTagRepository;
import br.com.senac.nikoniko.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final MoodRepository moodRepository;
    private final RecordTagRepository recordTagRepository;

    public ReportServiceImpl(MoodRepository moodRepository, RecordTagRepository recordTagRepository) {
        this.moodRepository = moodRepository;
        this.recordTagRepository = recordTagRepository;
    }

    @Override
    public List<EntryDto> getMonthlyReport(Long teamId) {
        return moodRepository.findPeriodByTeamId(teamId, DateUtils.getStartOfMonth(), DateUtils.getEndOfMonth());
    }

    @Override
    public List<QuarterDto> getQuarterReport(Long teamId) {
        return null;
    }

    @Override
    public List<TagReportDto> getTagCloud(Long teamId) {
        return recordTagRepository.findTagUsage(teamId);
    }

}
