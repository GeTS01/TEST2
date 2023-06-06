package com.example.Test.utils;

import lombok.experimental.UtilityClass;
import org.springframework.lang.Nullable;

@UtilityClass
public class EnumHelper {

    public static <T extends Enum<T>> String getEnumName(@Nullable T anEnum) {
        if (anEnum == null) {
            return null;
        }
        return anEnum.name();
    }
}