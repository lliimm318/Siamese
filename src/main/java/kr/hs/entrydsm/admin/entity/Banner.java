package kr.hs.entrydsm.admin.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@Builder
@RedisHash("banner")
public class Banner {
    @Id
    private long imageId;

    @TimeToLive
    private long ttl;
}
