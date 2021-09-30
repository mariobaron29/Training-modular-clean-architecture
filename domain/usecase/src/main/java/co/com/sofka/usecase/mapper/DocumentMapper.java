package co.com.sofka.usecase.mapper;

import co.com.sofka.model.document.Document;
//import co.com.sofka.model.document.DocumentData;
import co.com.sofka.model.format.DocumentFormat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocumentMapper {
    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    @Mapping(source = "name", target = "name")
    DocumentFormat documentToFormat(Document document);
}
