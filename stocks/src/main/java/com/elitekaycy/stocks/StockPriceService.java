package com.elitekaycy.stocks;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class StockPriceService {
  private String API_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

  public StockPriceService() {
  }

  public Observable<String> fetchCurrentStockPrice() {
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      return Observable.fromCallable(() -> {
        HttpGet request = new HttpGet(API_URL);
        HttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity);
        return responseString;
      }).subscribeOn(Schedulers.io());
    } catch (IOException e) {
      return Observable.error(e);
    }
  }

}
