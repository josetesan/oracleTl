package com.josetesan.oracletl;

import lombok.Data;

import java.util.Date;

@Data
public class EventRow {

    private Long id;
    private Date createDate;
    private String payload;
    private String tipo;
    private boolean processed;

    private EventRow(Builder builder) {
        setId(builder.id);
        setCreateDate(builder.createDate);
        setPayload(builder.payload);
        setTipo(builder.tipo);
        this.processed = false;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(EventRow copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.createDate = copy.getCreateDate();
        builder.payload = copy.getPayload();
        builder.tipo = copy.getTipo();
        return builder;
    }


    public static final class Builder {
        private Long id;
        private Date createDate;
        private String payload;
        private String tipo;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withCreateDate(Date val) {
            createDate = val;
            return this;
        }

        public Builder withPayload(String val) {
            payload = val;
            return this;
        }

        public Builder withTipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public EventRow build() {
            return new EventRow(this);
        }
    }
}
