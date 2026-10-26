package Projeto_Estatistica.DTOs;

import lombok.Getter;

@Getter
public class RequestDTO {
    private final String from;
    private final String to;
    private final String database;

    public RequestDTO(String from, String to, String database) {
        this.from = from;
        this.to = to;
        this.database = database;
    }
}
