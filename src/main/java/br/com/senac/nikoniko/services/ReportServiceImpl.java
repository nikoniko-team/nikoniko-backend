package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.EntryDto;
import br.com.senac.nikoniko.repositories.MoodRepository;
import br.com.senac.nikoniko.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final MoodRepository moodRepository;

    public ReportServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public List<EntryDto> getMonthlyReport(Long teamId) {
        return moodRepository.findCurrentMonthByTeamId(teamId, DateUtils.getStartOfMonth(), DateUtils.getEndOfMonth());
    }

}
