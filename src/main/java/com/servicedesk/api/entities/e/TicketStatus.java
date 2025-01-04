package com.servicedesk.api.entities.e;

public enum TicketStatus {
    WAITING(1),
    AT_PROGRESS(2),
    CANCEL(3),
    FINISH(4);

    private int value;

    TicketStatus(int value) {
        this.value = value;
    }
}
