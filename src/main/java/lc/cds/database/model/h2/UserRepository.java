package lc.cds.database.model.h2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Component("h2-user-repository")
@Repository
public interface UserRepository extends CrudRepository<User, Long > {

	public List<User> findByName(String Name);


}
