package com.tsb.util;

import com.tsb.exception.BadRequestException;
import com.tsb.exception.EmptyParameterException;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Objects;
import java.util.UUID;

public class ParameterValidator {
    public static Integer getPositiveInteger(HttpServletRequest req, String parameterName) {
        if (Objects.isNull(req.getParameter(parameterName))) {
            throw new EmptyParameterException(parameterName);
        }
        try {
            int res =  Integer.parseInt(req.getParameter(parameterName));
            if (res <= 0) {
                throw new BadRequestException(parameterName, req.getParameter(parameterName), "Должен быть положительным.");
            }
            return res;
        } catch (NumberFormatException e) {
            throw new BadRequestException(parameterName, req.getParameter(parameterName), "Должен быть числом.");
        }
    }

    public static String getPlayerName(HttpServletRequest req, String parameterName) {
        String name = req.getParameter(parameterName);
        if (Objects.isNull(name)) {
            throw new EmptyParameterException(parameterName);
        }
        if (name.isBlank()) {
            throw new BadRequestException("Имя не может состоять только из пробелов");
        }
        if (name.length() < 3 || name.length() > 50) {
            throw new BadRequestException("Имя не может состоять меньше чем из 3 символов или больше 50 символов");
        }
        if (!name.matches("([A-Za-zА-Яа-я]+)|([A-Za-zА-Яа-я]+\\s[A-Za-zА-Яа-я]+)")) {
            throw new BadRequestException("Имя не может состоять из спец. символов или чисел");
        }
        return name;
    }

    public static UUID getUUID(HttpServletRequest req, String parameterName) {
        String uuid = req.getParameter(parameterName);
        if (Objects.isNull(uuid)) {
            throw new EmptyParameterException(parameterName);
        }
        try {
            return UUID.fromString(uuid);
        } catch (Exception e) {
            throw new BadRequestException(parameterName, req.getParameter(parameterName), "Должен быть UUID.");
        }
    }
}
