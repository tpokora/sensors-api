package org.tpokora.sheets;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SheetRecord implements Cloneable {
    private final LocalDateTime date;
    private final Double temperature;
    private final Double humidity;
    private final Double pm10;
    private final Double pm25;

    public LocalDateTime getDate() {
        return date;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getPm10() {
        return pm10;
    }

    public Double getPm25() {
        return pm25;
    }

    public static class Builder {
        private final LocalDateTime date;
        private Double temperature;
        private Double humidity;
        private Double pm10;
        private Double pm25;

        public Builder(LocalDateTime date) {
            this.date = date;
        }

        public Builder temperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder humidity(Double humidity) {
            this.humidity = humidity;
            return this;
        }

        public Builder pm10(Double pm10) {
            this.pm10 = pm10;
            return this;
        }

        public Builder pm25(Double pm25) {
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
        return Double.compare(sheetRecord.pm25, pm25) == 0
                && Double.compare(sheetRecord.pm10, pm10) == 0
                && Double.compare(sheetRecord.humidity, humidity) == 0
                && Double.compare(sheetRecord.temperature, temperature) == 0
                && sheetRecord.date.compareTo(date) == 0;
    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + Double.hashCode(temperature);
        result = 31 * result + Double.hashCode(humidity);
        result = 31 * result + Double.hashCode(pm10);
        result = 31 * result + Double.hashCode(pm10);
        return result;
    }

    @Override
    public String toString() {
        return String.format("date=%s, temperature=%1.2f, humidity=%1.2f, pm10=%1.2f, pm25=%1.2f",
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
