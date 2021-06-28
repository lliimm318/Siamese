package kr.hs.entrydsm.main.enitity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@Entity(name = "tbl_image")
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    private String path;

}
