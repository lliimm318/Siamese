package kr.hs.entrydsm.admin.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tbl_image")
public class Image {
    @GeneratedValue
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    private String path;
}
