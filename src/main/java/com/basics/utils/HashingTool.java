package com.basics.utils;

import com.basics.exception.HashingException;
import lombok.extern.slf4j.Slf4j;
import org.hashids.Hashids;

import java.util.Optional;

@Slf4j
public class HashingTool {
    private static final String SALT = "vnabd875hiHdha76jhHHDBV";
    private static final int MIN_HASH_LENGTH = 8;
    private static final Hashids hashids = new Hashids(SALT, MIN_HASH_LENGTH);

    public static String encode(Long id) {
        log.debug("HashingTool.encode: " + id);
        return hashids.encode(id);
    }

    public static Long decode(String hashedId) {
        log.debug("HashingTool.decode: " + hashedId);
        return Optional.of(hashids.decode(hashedId)[0]).orElseThrow(() -> new HashingException("Error of Id Hashing"));
    }

}
