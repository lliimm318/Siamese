package kr.hs.entrydsm.admin.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// redis connection
public class Banner {
    private long imageId;

    private LocalDateTime expiredAt;
}
