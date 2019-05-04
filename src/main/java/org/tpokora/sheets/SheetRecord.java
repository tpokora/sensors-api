package org.tpokora.sheets;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SheetRecord implements Cloneable {
    private final LocalDateTime date;
    private final String temperature;
    private final String humidity;
    private final String pm10;
    private final String pm25;

    public LocalDateTime getDate() {
        return date;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPm10() {
        return pm10;
    }

    public String getPm25() {
        return pm25;
    }

    public static class Builder {
        private final LocalDateTime date;

        private String temperature = "";
        private String humidity = "";
        private String pm10 = "";
        private String pm25 = "";

        public Builder(LocalDateTime date) {
            this.date = date;
        }

        public Builder temperature(String temperature) {
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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || !(o instanceof SheetRecord)) {
            return false;
        }

        SheetRecord sheetRecord = (SheetRecord) o;
        return sheetRecord.pm25.equals(pm25)
                && sheetRecord.pm10.equals(pm10)
                && sheetRecord.humidity.equals(humidity)
                && sheetRecord.temperature.equals(temperature)
                && sheetRecord.date.compareTo(date) == 0;
    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + temperature.hashCode();
        result = 31 * result + humidity.hashCode();
        result = 31 * result + pm10.hashCode();
        result = 31 * result + pm25.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("date=%s, temperature=%s, humidity=%s, pm10=%s, pm25=%s",
                date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), temperature, humidity, pm10, pm25);
    }

    @Override
    public SheetRecord clone() {
        try {
            return (SheetRecord) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
