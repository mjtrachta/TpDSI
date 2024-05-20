package com.wineryapp.bodegaapp.config;

import com.wineryapp.bodegaapp.entity.Vino;
import com.wineryapp.bodegaapp.service.VinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    private VinoService vinoService;

    @KafkaListener(topics = "vino-topic", groupId = "vino-group")
    public void consume(Vino vino) {
        // Lógica para procesar y confirmar el vino en el sistema principal
        vinoService.crearVino(vino);
    }
}