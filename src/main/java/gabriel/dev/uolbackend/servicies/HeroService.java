package gabriel.dev.uolbackend.servicies;

import gabriel.dev.uolbackend.dto.HeroDto;
import gabriel.dev.uolbackend.enities.Hero;
import gabriel.dev.uolbackend.repositories.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    private final HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    public Hero createHero(final HeroDto heroDto) {
        return heroRepository.save(heroDto.from(heroDto));
        //Falta colocar o grupo do héroi
    }

}
