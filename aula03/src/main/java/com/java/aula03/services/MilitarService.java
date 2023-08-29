package com.java.aula03.services;

import com.java.aula03.dto.MilitarDTO;
import com.java.aula03.entities.Militar;
import com.java.aula03.repositories.MilitarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MilitarService {

    @Autowired
    private MilitarRepository militarRepository;

    public List<MilitarDTO> listarTodos() throws Exception {

        return militarRepository.findAll().stream().map(m -> {
            return new ModelMapper().map(m, MilitarDTO.class);
        }).collect(Collectors.toList());

    }

    public MilitarDTO buscarPorId(Long id) throws Exception {
        Optional<Militar> militar = militarRepository.findById(id);
        MilitarDTO militarDTO = new ModelMapper().map(militar, MilitarDTO.class);
        return militarDTO;

    }

    public void excluir(Long id) throws Exception {
        Militar militar = militarRepository.findById(id).get();
        if (militar != null) {
            militarRepository.delete(militar);
        }
    }
    public void salvar(MilitarDTO militarDTO)throws Exception{
        Militar militar = new ModelMapper().map(militarDTO, Militar.class);
        militarRepository.save(militar);

    }

}






