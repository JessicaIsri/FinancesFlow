package br.gov.sp.fatec.finances.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class MovementsDTO {
    private String type;
    private Double value;
    private String flow;
    private Long accountId;

}
