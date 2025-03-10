package com.elitekaycy.stocks;

import java.util.Map;

public class StockData {
  private Time time;
  private String disclaimer;
  private String chartName;
  private Map<String, Currency> bpi;

  // Getters and setters
  public Time getTime() {
    return time;
  }

  public void setTime(Time time) {
    this.time = time;
  }

  public String getDisclaimer() {
    return disclaimer;
  }

  public void setDisclaimer(String disclaimer) {
    this.disclaimer = disclaimer;
  }

  public String getChartName() {
    return chartName;
  }

  public void setChartName(String chartName) {
    this.chartName = chartName;
  }

  public Map<String, Currency> getBpi() {
    return bpi;
  }

  public Currency getBpi(String code) {
    return bpi.get(code);
  }

  public void setBpi(Map<String, Currency> bpi) {
    this.bpi = bpi;
  }

  public static class Time {
    private String updated;
    private String updatedISO;
    private String updateduk;

    // Getters and setters
    public String getUpdated() {
      return updated;
    }

    public void setUpdated(String updated) {
      this.updated = updated;
    }

    public String getUpdatedISO() {
      return updatedISO;
    }

    public void setUpdatedISO(String updatedISO) {
      this.updatedISO = updatedISO;
    }

    public String getUpdateduk() {
      return updateduk;
    }

    public void setUpdateduk(String updateduk) {
      this.updateduk = updateduk;
    }
  }

  public static class Currency {
    private String code;
    private String symbol;
    private String rate;
    private String description;
    private double rate_float;

    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public String getSymbol() {
      return symbol;
    }

    public void setSymbol(String symbol) {
      this.symbol = symbol;
    }

    public String getRate() {
      return rate;
    }

    public void setRate(String rate) {
      this.rate = rate;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public double getRate_float() {
      return rate_float;
    }

    public void setRate_float(double rate_float) {
      this.rate_float = rate_float;
    }
  }
}
