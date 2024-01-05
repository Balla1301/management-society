package sn.ads.societymanagement.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EnableJpaAuditing
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nom requis !!!")
    private String nom;
    @NotBlank(message = "Prenom requis !!!")
    private String prenom;
    @NotBlank(message = "Telephone requis !!!")
    @Size(max = 12, message = "Telephone pas plus 12 caractères !!!")
    private String telephone;
    @NotBlank(message = "Email requis !!!")
    private String email;
    @JsonIgnore
    private String password;
    private boolean activo=true;
    @ManyToOne
    @JsonIgnore
    private Societe societe;
}
