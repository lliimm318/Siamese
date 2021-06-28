package kr.hs.entrydsm.main.enitity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@Entity(name = "tbl_post")
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @GeneratedValue
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @OneToMany(mappedBy = "post")
    @JsonBackReference
    private List<Like> likes;

    @OneToOne
    @JsonManagedReference
    @JoinColumn(name = "id")
    private Image image;

    private String title;

    private String author;

    private String description;

    private String content;

    private PostType type;

    private LocalDateTime createdAt;

    public Post update(Post post) {
        this.title = post.title;
        this.author = post.author;
        this.description = post.description;
        this.content = post.content;
        this.type = post.type;

        return this;

    }
}