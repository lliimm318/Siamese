package kr.hs.entrydsm.admin.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_post")
public class Post {
    @Id
    private long id;

    private String title;

    private String author;

    private String description;

    private String content;

    private PostType type;

    private LocalDateTime createdAt;
}
