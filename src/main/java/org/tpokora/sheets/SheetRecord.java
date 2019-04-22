package org.tpokora.sheets;

import java.util.Date;

public class SheetRecord {
    private final Date date;
    private final String temperature;
    private final String humidity;
    private final String pm10;
    private final String pm25;

    public static class Builder {
        private final Date date;

        private String temperature = "";
        private String humidity = "";
        private String pm10 = "";
        private String pm25 = "";

        public Builder(Date date) {
            this.date = date;
        }

        public Builder temperatur(String temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder humidity(String humidity) {
            this.humidity = humidity;
            return this;
        }

        public Builder pm10(String pm10) {
            this.pm10 = pm10;
            return this;
        }

        public Builder pm25(String pm25) {
            this.pm25 = pm25;
            return this;
        }

        public SheetRecord build() {
            return new SheetRecord(this);
        }
    }

    private SheetRecord(Builder builder) {
        date = builder.date;
        temperature = builder.temperature;
        humidity = builder.humidity;
        pm10 = builder.pm10;
        pm25 = builder.pm25;
    }

}
