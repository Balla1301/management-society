package sn.ads.societymanagement.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EnableJpaAuditing
public class Societe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nom requis !!!")
    private String nom;
    @NotBlank(message = "Registre de commerce requis !!!")
    private String rc;
    @NotBlank(message = "Ninea requis !!!")
    private String ninea;
    @Size(max = 12, message = "Telephone pas plus 12 caractères !!!")
    @NotBlank(message = "Numéro de téléphone requis !!!")
    private String telephone;
    @NotBlank(message = "Adresse email requis")
    private String email;
    private String rue;
    private String region;
    private String pays;
    //Societe Locataire, Societe Tierce, Gie
    private String statut;
    private boolean activo=true;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdDate;

    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;

    private List<Utilisateur> utilisateurs;



}
