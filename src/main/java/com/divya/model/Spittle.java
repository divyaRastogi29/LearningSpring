package com.divya.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by divya on 28/9/16.
 */
public class Spittle {
    private  Long id;
    private  String message;
    private  String time;
    private Double latitude;
    private Double longitude;

    public Spittle(){

    }

    public Spittle(String message, String time){
        this.id = id;
        this.message = message;
        this.time = time;
    }

    public Spittle(String message, Double latitude, Double longitude){
        this.message = message ;
        this.latitude = latitude ;
        this.longitude = longitude ;
    }

    public Spittle(Long id ,String message, String time, Double latitude, Double longitude){
        this.id = id;
        this.message = message;
        this.time = time ;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object that){
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }

    @Override
    public String toString(){
        return id+" message is : "+message;
    }

}
