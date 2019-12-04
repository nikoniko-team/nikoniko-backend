package br.com.senac.nikoniko.services;

import br.com.senac.nikoniko.dtos.in.TagDto;
import br.com.senac.nikoniko.entities.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findAll();

    List<TagDto> findAllDto();

    TagDto findById(Long id);
}
