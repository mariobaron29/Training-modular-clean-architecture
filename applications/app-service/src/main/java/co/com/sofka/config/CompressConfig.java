package co.com.sofka.config;

import co.com.sofka.model.document.gateways.DocumentRepository;
import co.com.sofka.usecase.compresspdf.CompressPDFUseCase;
import co.com.sofka.usecase.listallpdf.ListAllPDFUseCase;
import co.com.sofka.usecase.service.CompressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompressConfig {

    @Autowired
    private DocumentRepository documentDBRepository;

    @Bean
    public CompressService configure() {
        CompressPDFUseCase compressPDFUseCase = new CompressPDFUseCase(documentDBRepository);
        ListAllPDFUseCase listAllPDFUseCase = new ListAllPDFUseCase(documentDBRepository);
        return new CompressService(compressPDFUseCase, listAllPDFUseCase);
    }
}
