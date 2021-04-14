package kr.hs.entrydsm.main.enitity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import kr.hs.entrydsm.main.service.post.PostDetailService;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String author;

    private String title;

    private String description;

    private String content;

    private LocalDateTime date;

    private PostType postType;

    @OneToMany
    @JsonBackReference
    private List<Like> likes;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "image_id")
    private Image image;
}