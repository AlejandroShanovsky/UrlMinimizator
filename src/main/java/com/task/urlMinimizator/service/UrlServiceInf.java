package com.task.urlMinimizator.service;

import com.task.urlMinimizator.beans.Url;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

public interface UrlServiceInf {
    void createUrl(String url, int countOfDays, boolean isActive, String requestInfo) throws UnknownHostException;

    void deleteUrl(Url url);

    void updateUrl(Url url);

    String getUrlInfo(Url url);

    List<Url> getAllUrls();
}
