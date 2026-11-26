package esprit.tn.projetsi.dto;

import lombok.Data;

@Data
public class ClientResponseDto {

    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
}