package gabriel.dev.uolbackend.repositories;

import gabriel.dev.uolbackend.enities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
}
