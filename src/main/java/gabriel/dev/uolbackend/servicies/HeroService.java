package gabriel.dev.uolbackend.servicies;

import gabriel.dev.uolbackend.CodinameSelector;
import gabriel.dev.uolbackend.controllers.HeroController;
import gabriel.dev.uolbackend.dto.HeroDto;
import gabriel.dev.uolbackend.enities.Hero;
import gabriel.dev.uolbackend.enities.HeroGroup;
import gabriel.dev.uolbackend.repositories.HeroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    private final Logger logger = LoggerFactory.getLogger(HeroService.class);
    private final HeroRepository heroRepository;
    private final CodinameSelector codinameSelector;

    public HeroService(HeroRepository heroRepository, CodinameSelector codinameSelector) {
        this.heroRepository = heroRepository;
        this.codinameSelector = codinameSelector;
    }

    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    public Hero createHero(HeroDto heroDto) {
        Hero newHero = new Hero(heroDto);
        String codiname = getCodiname(heroDto.heroGroup());
        newHero.setCodiname(codiname);
        return heroRepository.save(newHero);
    }

    private String getCodiname(HeroGroup heroGroup)  {
        return codinameSelector.selectCodiname(heroGroup);
    }

}
