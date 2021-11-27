package br.gov.sp.fatec.finances.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AccountDTO {
    private String name;
    private Double initialBalance;
    private Double currentBalance;
    private Long userID;

}
