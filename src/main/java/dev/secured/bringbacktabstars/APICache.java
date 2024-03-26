package dev.secured.bringbacktabstars;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import net.hypixel.api.reply.PlayerReply;

import javax.annotation.Nullable;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class APICache {

    private Cache<UUID, PlayerReply.Player> cache;

    public APICache() {
        cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();
    }

    public void put(UUID key, PlayerReply.Player value) {
        cache.put(key, value);
    }

    public PlayerReply.Player get(UUID key) {
        return cache.getIfPresent(key);
    }

}
