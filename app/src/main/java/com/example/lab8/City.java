package com.example.lab8;

import java.util.Objects;

public class City {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    /**Override equals to check for logical equality based on name and province
     * @param o
     * @return Boolean True or False
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City citY = (City) o;
        return Objects.equals(city, citY.getCityName()) && Objects.equals(province, citY.getProvinceName());
    }

    /**Override hashCode as it's required when overriding equals
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }


}
