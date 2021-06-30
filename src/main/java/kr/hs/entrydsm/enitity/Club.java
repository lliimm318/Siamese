package kr.hs.entrydsm.enitity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_club")
public class Club {

    @Id
    @GeneratedValue
    private String id;

    private String password;

    private String name;

    private Boolean isExists;
}
