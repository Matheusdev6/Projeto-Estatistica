package Projeto_Estatistica.DTOs;

import lombok.Getter;

@Getter
public class RequestDTO {
    private final String from;
    private final String to;
    private final boolean box_plot;
    private final boolean columns;
    private final String database;

    public RequestDTO(String from, String to, boolean box_plot, boolean columns, String database) {
        this.from = from;
        this.to = to;
        this.box_plot = box_plot;
        this.columns = columns;
        this.database = database;
    }
}
