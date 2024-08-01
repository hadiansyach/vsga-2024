package com.example.appcatatan;

public class Catatan {
    private String fileName;
    private String timestamp;

    public Catatan(String fileName, String timestamp) {
        this.fileName = fileName;
        this.timestamp = timestamp;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
