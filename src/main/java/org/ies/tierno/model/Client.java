package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    private String nif;
    private String name;
    private String surname;
}
