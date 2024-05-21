package com.wineryapp.bodegaapp.service;

import com.wineryapp.bodegaapp.dto.VinoDTO;
import com.wineryapp.bodegaapp.entity.Vino;
import com.wineryapp.bodegaapp.entity.VinoTemporal;
import com.wineryapp.bodegaapp.repository.VinoRepository;
import com.wineryapp.bodegaapp.repository.VinoTemporalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VinoServiceImpl implements VinoService {


    private final VinoRepository vinoRepository;
    private final VinoTemporalRepository vinoTemporalRepository;

    @Autowired
    public VinoServiceImpl(VinoRepository vinoRepository, VinoTemporalRepository vinoTemporalRepository) {
        this.vinoRepository = vinoRepository;
        this.vinoTemporalRepository = vinoTemporalRepository;
    }



    @Override
    public List<Vino> obtenerVinosPorBodegaId(Integer idBodega) {

        return vinoRepository.findVinosByBodegaId(idBodega);
    }

    @Override
    public List<VinoDTO> obtenerVinosDTOPorIdBodega(Integer idBodega) {
        return vinoRepository.findVinosDTOByBodegaId(idBodega);
    }

  /*  @Override
    public Vino crearVino(Vino vino) {
        return vinoRepository.save(vino);
    }*/


    @Override
    public VinoTemporal crearVinoTemporal(VinoTemporal vinoTemporal) {
        return vinoTemporalRepository.save(vinoTemporal);
    }

    @Override
    public Vino confirmarVino(Integer idVinoTemporal) {
        VinoTemporal vinoTemporal = vinoTemporalRepository.findById(idVinoTemporal)
                .orElseThrow(() -> new RuntimeException("Vino temporal no encontrado"));
        Vino vino = new Vino();
        vino.setAnio(vinoTemporal.getAnio());
        vino.setNombre(vinoTemporal.getNombre());
        vino.setNota_de_cata_bodega(vinoTemporal.getNota_de_cata_bodega());
        vino.setPrecio_ars(vinoTemporal.getPrecio_ars());
        vino.setBodega(vinoTemporal.getBodega());
        vino.setVarietal(vinoTemporal.getVarietal());
        vinoTemporalRepository.delete(vinoTemporal);
        return vinoRepository.save(vino);
    }
}