package com.task.urlMinimizator.dao;

import com.task.urlMinimizator.beans.Url;

import java.util.List;

public interface UrlDao {
    void saveUrl(Url url);

    void deleteUrl(Url url);

    void updateUrl(Url url);

    List<Url> getAllUrls();
}
