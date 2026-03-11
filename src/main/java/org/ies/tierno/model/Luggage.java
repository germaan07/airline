package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Log4j
@Data
@AllArgsConstructor
public class Luggage {
    private String id;
    private String description;

    public void showInfo(){
        log.info("PRENDA");
        log.info("  - ID: " + id);
        log.info("  - Descripción: " + description);
    }
}
