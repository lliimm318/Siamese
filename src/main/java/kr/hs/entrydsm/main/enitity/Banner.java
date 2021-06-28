package kr.hs.entrydsm.main.enitity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import javax.persistence.GeneratedValue;

@Getter
@Builder
@RedisHash("banner")
public class Banner {

    @Id
    @GeneratedValue
    private long imageId;

    @TimeToLive
    private long ttl;

}
