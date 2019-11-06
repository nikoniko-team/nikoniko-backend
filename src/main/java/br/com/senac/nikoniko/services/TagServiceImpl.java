package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.in.TagDto;
import br.com.senac.nikoniko.entities.Tag;
import br.com.senac.nikoniko.repositories.TagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;
    private ModelMapper modelMapper;

    public TagServiceImpl(TagRepository tagRepository, ModelMapper modelMapper) {
        this.tagRepository = tagRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public List<TagDto> findAllDto() {
        return findAll().stream().map(tag -> modelMapper.map(tag, TagDto.class)).collect(Collectors.toList());
    }
}
