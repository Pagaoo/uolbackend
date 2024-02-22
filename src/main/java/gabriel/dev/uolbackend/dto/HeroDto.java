package gabriel.dev.uolbackend.dto;

import gabriel.dev.uolbackend.enities.Hero;
import gabriel.dev.uolbackend.enities.HeroGroup;

public record HeroDto(String name, String email, String phoneNumber, HeroGroup heroGroup) {

    public Hero from(HeroDto heroDto) {
        Hero hero = new Hero();
        hero.setName(heroDto.name);
        hero.setEmail(heroDto.email);
        hero.setPhoneNumber(heroDto.phoneNumber);
        hero.setHeroGroup(heroDto.heroGroup);
        return hero;
    }

}
