package co.com.sofka.api;

import co.com.sofka.usecase.base.UseCase;
import co.com.sofka.model.format.DocumentFormat;
import co.com.sofka.usecase.service.CompressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

@RestController
public class CompressRestController {
    private CompressService compressService;

    public CompressRestController(CompressService compressService) {
        this.compressService = compressService;
    }

    @PostMapping("/reduces")
    public Mono<UseCase.ResponseValue> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        return Mono.fromFuture(compressService.reduce("undefine", file.getBytes()));
    }

    @GetMapping("/all")
    public Mono<List<DocumentFormat>> all() {
        return Mono.fromFuture(compressService.getAll());
    }
}