package pe.edu.vallegrande.metamatrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.edu.vallegrande.metamatrix.dto.AnalysisResultDTO;
import pe.edu.vallegrande.metamatrix.entity.Metadata;
import pe.edu.vallegrande.metamatrix.exception.MetadataNotFoundException;
import pe.edu.vallegrande.metamatrix.repository.MetadataRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MetaMatrixService {

    private final MetadataRepository metadataRepository;

    @Value("${ibm.watson.nlu.api-url}")
    private String nluApiUrl;

    @Value("${ibm.watson.nlu.api-key}")
    private String nluApiKey;

    @Autowired
    public MetaMatrixService(MetadataRepository metadataRepository) {
        this.metadataRepository = metadataRepository;
    }

    public Flux<Metadata> getAllMetadata() {
        return metadataRepository.findAll();
    }

    public Flux<Metadata> getActiveMetadata() {
        return metadataRepository.findByActive('A');
    }

    public Flux<Metadata> getInactiveMetadata() {
        return metadataRepository.findByActive('I');
    }

    public Mono<Metadata> getMetadataById(Integer id) {
        return metadataRepository.findById(id)
                .switchIfEmpty(Mono.error(new MetadataNotFoundException("Metadato con id " + id + " no encontrado")));
    }

    public Mono<Metadata> analyzeTextAndSaveMetadata(String requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setBasicAuth("apikey", nluApiKey);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AnalysisResultDTO> responseEntity = restTemplate.exchange(
                nluApiUrl,
                HttpMethod.POST,
                requestEntity,
                AnalysisResultDTO.class
        );

        AnalysisResultDTO analysisResult = responseEntity.getBody();
        Metadata metadata = new Metadata();
        metadata.setTitle(analysisResult.getMetadata().getTitle());
        metadata.setPublicationDate(analysisResult.getMetadata().getPublication_date());
        metadata.setImageUrl(analysisResult.getMetadata().getImage());
        metadata.setFeeds(analysisResult.getMetadata().getFeeds());
        metadata.setAuthors(analysisResult.getMetadata().getAuthors());
        metadata.setActive('A'); // Establecer activo como 'A' por defecto

        return metadataRepository.save(metadata);
    }

    public Mono<Metadata> updateMetadata(Integer id, Metadata updatedMetadata) {
        return metadataRepository.findById(id)
                .flatMap(existingMetadata -> {
                    existingMetadata.updateTitle(updatedMetadata.getTitle());
                    existingMetadata.updatePublicationDate(updatedMetadata.getPublicationDate());
                    existingMetadata.updateImageUrl(updatedMetadata.getImageUrl());
                    existingMetadata.updateFeeds(updatedMetadata.getFeeds());
                    existingMetadata.updateAuthors(updatedMetadata.getAuthors());
                    return metadataRepository.save(existingMetadata);
                })
                .switchIfEmpty(Mono.error(new MetadataNotFoundException("Metadato con id " + id + " no encontrado")));
    }

    public Mono<Metadata> activateMetadata(Integer id) {
        return metadataRepository.findById(id)
                .flatMap(metadata -> {
                    metadata.setActive('A');
                    return metadataRepository.save(metadata);
                })
                .switchIfEmpty(Mono.error(new MetadataNotFoundException("Metadato con id " + id + " no encontrado")));
    }

    public Mono<Metadata> deactivateMetadata(Integer id) {
        return metadataRepository.findById(id)
                .flatMap(metadata -> {
                    metadata.setActive('I');
                    return metadataRepository.save(metadata);
                })
                .switchIfEmpty(Mono.error(new MetadataNotFoundException("Metadato con id " + id + " no encontrado")));
    }

    public Mono<Void> deleteMetadata(Integer id) {
        return metadataRepository.findById(id)
                .flatMap(metadata -> metadataRepository.deleteById(id)
                        .then(Mono.error(new MetadataNotFoundException("Fue eliminado exitosamente")))
                )
                .switchIfEmpty(Mono.error(new MetadataNotFoundException("Metadato con id " + id + " no encontrado")))
                .then();
    }
}