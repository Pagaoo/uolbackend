package gabriel.dev.uolbackend.dto;

import gabriel.dev.uolbackend.enities.HeroGroup;

public record HeroDto(String name, String email, String phoneNumber, HeroGroup heroGroup) {
}
