package com.accenture.mortalcommand.fightscheduleapp.fights;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Fight {

    private String sport;
    private LocalDateTime playtime;
    private String location;

    public Fight(String sport, LocalDateTime playtime, String location) {
        this.sport = sport;
        this.playtime = playtime;
        this.location = location;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public LocalDateTime getPlaytime() {
        return playtime;
    }

    public void setPlaytime(LocalDateTime playtime) {
        this.playtime = playtime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
