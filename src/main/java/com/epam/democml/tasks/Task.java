package com.epam.democml.tasks;

import java.util.HashMap;
import java.util.Map;

/*
 * Класс, общий для всех задач
 */
public abstract class Task {
    // Собственный header для передачи номера task'а
    public static final String TASK = "Task";

    // Количество повторений для сообщений. По умолчанию 1. Переопределяется в случает необходимости
    protected Integer repeatCount = 1;

    // Тело сообщения
    protected Object body;

    // Заголовок сообщения
    protected Map<String, Object> headers = new HashMap<>();

    public Task () {
        prepare();
    }

    protected abstract void prepare ();

    public Object getBody () {
        return body;
    }

    public Map<String, Object> getHeaders () {
        return headers;
    }

    public Integer getRepeatCount () {
        return repeatCount;
    }

}
