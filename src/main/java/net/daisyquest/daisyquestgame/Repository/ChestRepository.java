package net.daisyquest.daisyquestgame.Repository;

import net.daisyquest.daisyquestgame.Model.Chest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChestRepository extends MongoRepository<Chest, String> {

}
