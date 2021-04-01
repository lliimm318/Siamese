package kr.hs.entrydsm.admin.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tbl_post")
public class Post {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

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
