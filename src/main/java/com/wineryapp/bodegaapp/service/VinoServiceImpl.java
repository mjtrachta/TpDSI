package com.wineryapp.bodegaapp.service;

import com.wineryapp.bodegaapp.dto.VinoDTO;
import com.wineryapp.bodegaapp.entity.Vino;
import com.wineryapp.bodegaapp.repository.VinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VinoServiceImpl implements VinoService {

    private final VinoRepository vinoRepository;
    @Autowired
    public VinoServiceImpl(VinoRepository vinoRepository) {
        this.vinoRepository = vinoRepository;
    }



    @Override
    public List<Vino> obtenerVinosPorBodegaId(Integer idBodega) {
        return vinoRepository.findVinosByBodegaId(idBodega);
    }

    @Override
    public List<VinoDTO> obtenerVinosDTOPorIdBodega(Integer idBodega) {
        return vinoRepository.findVinosDTOByBodegaId(idBodega);
    }

    @Override
    public Vino crearVino(Vino vino) {
        return vinoRepository.save(vino);
    }
}