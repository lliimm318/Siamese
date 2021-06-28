package kr.hs.entrydsm.main.enitity;

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

    @GeneratedValue
    @Id
    private String id;

    private String password;

    private String name;

    private Boolean isExists;

}
