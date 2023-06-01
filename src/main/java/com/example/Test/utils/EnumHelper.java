package com.example.Test.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

@UtilityClass
@Slf4j
public class EnumHelper {

    public static <T extends Enum<T>> String getEnumName(@Nullable T anEnum) {
        if (anEnum == null) {
            return null;
        }
        return anEnum.name();
    }
}