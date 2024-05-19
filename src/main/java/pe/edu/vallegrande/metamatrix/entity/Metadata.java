package pe.edu.vallegrande.metamatrix.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import pe.edu.vallegrande.metamatrix.dto.AuthorDTO;
import pe.edu.vallegrande.metamatrix.dto.FeedDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@NoArgsConstructor
@Table("metadata")
public class Metadata {

    @Id
    private Integer id;
    private String title;
    private LocalDateTime publicationDate;
    private String imageUrl;
    private String feeds;
    private String authors;
    private char active;

    public void setPublicationDate(String publicationDate) {
        if (publicationDate != null && !publicationDate.isEmpty()) {
            this.publicationDate = LocalDateTime.parse(publicationDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }

    public void setFeeds(List<FeedDTO> feeds) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.feeds = objectMapper.writeValueAsString(feeds);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void setAuthors(List<AuthorDTO> authors) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.authors = objectMapper.writeValueAsString(authors);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void updateTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
    }

    public void updatePublicationDate(LocalDateTime publicationDate) {
        if (publicationDate != null) {
            this.publicationDate = publicationDate;
        }
    }

    public void updateImageUrl(String imageUrl) {
        if (imageUrl != null && !imageUrl.isEmpty()) {
            this.imageUrl = imageUrl;
        }
    }

    public void updateFeeds(String feeds) {
        if (feeds != null && !feeds.isEmpty()) {
            this.feeds = feeds;
        }
    }

    public void updateAuthors(String authors) {
        if (authors != null && !authors.isEmpty()) {
            this.authors = authors;
        }
    }
}
