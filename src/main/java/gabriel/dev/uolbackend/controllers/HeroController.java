package gabriel.dev.uolbackend.controllers;

import gabriel.dev.uolbackend.dto.HeroDto;
import gabriel.dev.uolbackend.enities.Hero;
import gabriel.dev.uolbackend.servicies.HeroService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private final Logger logger = LoggerFactory.getLogger(HeroController.class);
    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Hero createHero(@RequestBody @Valid HeroDto heroDto) {
        logger.info("[HeroController] Create a hero");
        return heroService.createHero(heroDto);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Hero> getAllHeroes() {
        logger.info("[HeroController] Search all heroes");
        return heroService.getAllHeroes();
    }

}
