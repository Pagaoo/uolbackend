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

    public void createHero(HeroDto heroDto) {
        heroRepository.save(heroDto.from(heroDto));
    }

}
