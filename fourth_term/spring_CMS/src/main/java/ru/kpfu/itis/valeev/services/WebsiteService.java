package ru.kpfu.itis.valeev.services;

import ru.kpfu.itis.valeev.dto.WebsiteDto;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.models.Website;

import java.util.List;

public interface WebsiteService {

    void addWebsite(WebsiteDto websiteDto);
    Website getWebsite(String url);
    List<Website> getWebsiteChildren(Website website);
    boolean isUniqueUrl(String url);
    List<Website> getPrimalWebsites(User user);
    List<Website> getHierarchyList(User user);
    void fillWebsites(List<Website> websites);
}
