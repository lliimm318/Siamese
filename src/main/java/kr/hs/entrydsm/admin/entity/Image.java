package kr.hs.entrydsm.admin.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tbl_image")
public class Image {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    private String path;
}
