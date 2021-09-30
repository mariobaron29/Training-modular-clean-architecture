package co.com.sofka.model.document.gateways;


import co.com.sofka.model.document.Document;

import java.util.List;

public interface DocumentRepository {

    List<Document> findAll();

    Document save(Document documentData);
}
