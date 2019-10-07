package MySqlTest.MySqlTest;

import org.springframework.data.repository.CrudRepository;

import MySqlTest.MySqlTest.Game;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Game, Integer> {

}