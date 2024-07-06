package org.fawry.model.errors;

import java.sql.Timestamp;

public class ResponseErrorModel {


    private String message;
    private Timestamp occurredAt;

    public ResponseErrorModel() {
    }

    public ResponseErrorModel(String message, Timestamp occuredAt) {
        this.message = message;
        this.occurredAt = occuredAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(Timestamp occurredAt) {
        this.occurredAt = occurredAt;
    }

    @Override
    public String toString() {
        return "ResponseErrorModel{" +
                ", message='" + message + '\'' +
                ", occurredAt=" + occurredAt +
                '}';
    }
}
