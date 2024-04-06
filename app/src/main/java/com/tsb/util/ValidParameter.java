package com.tsb.util;

import com.tsb.exception.BadRequestException;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.UUID;

public class ValidParameter {

    public static Integer getValidNumber(HttpServletRequest req, String parameter) {
        if (Objects.isNull(req.getParameter(parameter))) {
            throw new BadRequestException("Не задан параметр " + parameter);
        }
        try {
            return Integer.parseInt(req.getParameter(parameter));
        } catch (Exception e) {
            throw new BadRequestException("Не валидный параметр " + parameter + ": " + req.getParameter(parameter));
        }
    }

    public static String getValidPlayerName(HttpServletRequest req, String parameter) {
        String name = req.getParameter(parameter);
        if (Objects.isNull(name)) {
            throw new BadRequestException("Не задан параметр " + parameter);
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

    public static UUID getValidId(HttpServletRequest req, String parameter) {
        String uuid = req.getParameter(parameter);
        if (Objects.isNull(uuid)) {
            throw new BadRequestException("Не задан индентификатор (id)");
        }
        try {
            return UUID.fromString(uuid);
        } catch (Exception e) {
            throw new BadRequestException("Не валидный идентификатор");
        }
    }
}
