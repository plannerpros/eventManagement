package com.example.planner;

public class feedbackDatabase {
    String satisfied, futureEvents, takeaway, suggestions;


    public String getSatisfied() {
        return satisfied;
    }

    public feedbackDatabase(String satisfied, String futureEvents, String takeaway, String suggestions) {
        this.satisfied = satisfied;
        this.futureEvents = futureEvents;
        this.takeaway = takeaway;
        this.suggestions = suggestions;
    }

    public void setSatisfied(String satisfied) {
        this.satisfied = satisfied;
    }

    public String getFutureEvents() {
        return futureEvents;
    }

    public void setFutureEvents(String futureEvents) {
        this.futureEvents = futureEvents;
    }

    public String getTakeaway() {
        return takeaway;
    }

    public void setTakeaway(String takeaway) {
        this.takeaway = takeaway;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }
}
