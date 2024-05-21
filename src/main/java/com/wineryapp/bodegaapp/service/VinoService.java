package com.wineryapp.bodegaapp.service;

import com.wineryapp.bodegaapp.dto.VinoDTO;
import com.wineryapp.bodegaapp.entity.Vino;
import com.wineryapp.bodegaapp.entity.VinoTemporal;

import java.util.List;

public interface VinoService {
    List<Vino> obtenerVinosPorBodegaId(Integer idBodega);
    List<VinoDTO> obtenerVinosDTOPorIdBodega(Integer idBodega);



    //Vino crearVino(Vino vino);

    //Vino confirmarVino(Integer idVino);

    VinoTemporal crearVinoTemporal(VinoTemporal vinoTemporal);
    Vino confirmarVino(Integer idVinoTemporal);
}