package kr.hs.entrydsm.enitity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity(name = "tbl_post")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String author;

    private String title;

    private String description;

    private String content;

    @Enumerated(EnumType.STRING)
    private PostType type;

    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(mappedBy = "postId")
    @JsonBackReference
    private List<Like> likes;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    public Post update(Post post) {
        this.title = post.title;
        this.author = post.author;
        this.description = post.description;
        this.content = post.content;
        this.type = post.type;

        return this;
    }

}