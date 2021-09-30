package co.com.sofka.usecase.listallpdf;

import co.com.sofka.model.document.Document;
//import co.com.sofka.model.document.DocumentData;
import co.com.sofka.usecase.base.UseCase;
import co.com.sofka.model.document.gateways.DocumentRepository;

import java.util.List;
import java.util.Optional;

public class ListAllPDFUseCase extends UseCase<ListAllPDFUseCase.Request, ListAllPDFUseCase.Response> {

    private DocumentRepository documentRepository;

    public ListAllPDFUseCase(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    protected void executeUseCase(Request requestValues) {
        Optional.of(documentRepository.findAll())
                .map(documents -> {
                    emit().onSuccess(new Response(documents));
                    return documents;
                }).orElseGet(() -> {
            emit().onError(new RuntimeException("No se pudo realizar la tarea"));
            return null;
        });
    }

    public static class Request implements UseCase.RequestValues {

    }

    public static class Response implements UseCase.ResponseValue {
        private final List<Document> documentData;

        public Response(List<Document> documentData) {
            this.documentData = documentData;
        }

        public List<Document> getDocuments() {
            return documentData;
        }
    }
}
