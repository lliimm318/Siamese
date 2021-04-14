package kr.hs.entrydsm.common.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.joda.time.Hours;
import org.joda.time.Weeks;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public enum JWTType {
    CLUB_ACCESS_TOKEN(Hours.ONE.toStandardSeconds().getSeconds() * 1000),
    CLUB_REFRESH_TOKEN(Weeks.TWO.toStandardSeconds().getSeconds() * 1000);

    private final long expiration;
}
