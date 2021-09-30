package co.com.sofka.jpa.document;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface DocumentDBRepository extends CrudRepository<DocumentData, String>, QueryByExampleExecutor<DocumentData> {

}
