package com.task.urlMinimizator.service;

import com.task.urlMinimizator.beans.Url;
import com.task.urlMinimizator.dao.UrlDao;
import com.task.urlMinimizator.utils.ClientInfoUtil;
import com.task.urlMinimizator.utils.DateGenerator;
import com.task.urlMinimizator.utils.UrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.UnknownHostException;

import java.util.*;

@Service
public class UrlServiceImpl implements UrlServiceInf {
    private final UrlDao urlDao;
    private final UrlGenerator urlGenerator;
    private final DateGenerator dateGenerator;
    private final ClientInfoUtil clientInfoUtil;

    @Autowired
    public UrlServiceImpl(UrlDao urlDao, UrlGenerator urlGenerator, DateGenerator dateGenerator,
                          ClientInfoUtil clientInfoUtil) {
        this.urlDao = urlDao;
        this.urlGenerator = urlGenerator;
        this.dateGenerator = dateGenerator;
        this.clientInfoUtil = clientInfoUtil;
    }


    @Override
    @Transactional
    public void createUrl(String urlLine, int countOfDaysBeforeUrlDeactivation, boolean isActive,
                          String requestInfo) throws UnknownHostException {
        Date creatingDateUrl = new GregorianCalendar().getTime();

        Url url = new Url.Builder().setFullReference(urlLine)
                .setShortReference(urlGenerator.generateShortUrl())
                .setDateOfCreationUrl(creatingDateUrl)
                .setDateOfEndingUrl(dateGenerator.createUrlEndingTime(creatingDateUrl, countOfDaysBeforeUrlDeactivation))
                .setIsActive(isActive)
                .setIpAddress(clientInfoUtil.getIpAddress())
                .setBrowser(requestInfo)
                .getInstance();

        urlDao.saveUrl(url);
    }

    @Override
    @Transactional
    public void deleteUrl(Url url) {
        urlDao.deleteUrl(url);
    }

    @Override
    @Transactional
    public void updateUrl(Url url) {
        urlDao.updateUrl(url);
    }

    @Override
    @Transactional
    public String getUrlInfo(Url url) {
        return url.toString();
    }

    @Override
    @Transactional
    public List<Url> getAllUrls() {
        return urlDao.getAllUrls();
    }
}
