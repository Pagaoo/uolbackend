package gabriel.dev.uolbackend.enities;

import gabriel.dev.uolbackend.dto.HeroDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "heroes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private String phoneNumber;
    private String codiname;
    private HeroGroup heroGroup;

    public Hero(HeroDto heroDto) {
        this.name = heroDto.name();
        this.email = heroDto.email();
        this.phoneNumber = heroDto.phoneNumber();
        this.heroGroup = heroDto.heroGroup();
    }
}
