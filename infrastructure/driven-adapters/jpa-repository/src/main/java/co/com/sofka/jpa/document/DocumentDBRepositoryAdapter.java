package co.com.sofka.jpa.document;

import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.model.document.Document;
import co.com.sofka.model.document.gateways.DocumentRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentDBRepositoryAdapter extends AdapterOperations<Document, DocumentData, String, DocumentDBRepository>
 implements DocumentRepository
{

    public DocumentDBRepositoryAdapter(DocumentDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.mapBuilder(d,Document.DocumentBuilder.class).build());
    }
}
