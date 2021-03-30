package ru.kpfu.itis.valeev.services;

import ru.kpfu.itis.valeev.dto.WebsiteDto;
import ru.kpfu.itis.valeev.helpers.URLGenerationHelper;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.models.Website;
import ru.kpfu.itis.valeev.repositories.WebsiteRepository;

import java.util.List;

public class WebsiteServiceImpl implements WebsiteService{

    private WebsiteRepository websiteRepository;

    public WebsiteServiceImpl(WebsiteRepository websiteRepository) {
        this.websiteRepository = websiteRepository;
    }

    @Override
    public void addWebsite(WebsiteDto websiteDto) {
        String url = URLGenerationHelper.generateUrl(websiteDto.getCreator().getLogin(), websiteDto.getTitle());
        if(isUniqueUrl(url)){
            Website website = new Website(
                    websiteDto.getTitle(),
                    url,
                    websiteDto.getCreator().getId(),
                    websiteDto.getParentUrl(),
                    websiteDto.getBody()
            );
            websiteRepository.save(website);
        } else {
            throw new IllegalArgumentException("Url isn't unique");
        }

    }

    @Override
    public Website getWebsite(String url) {
        return websiteRepository.findByUrl(url);
    }

    @Override
    public List<Website> getPrimalWebsites(User user) {
        return websiteRepository.findAllByNullParent(user);
    }

    @Override
    public List<Website> getWebsiteChildren(Website website) {
        return websiteRepository.findAllByParent(website.getParentSiteUrl());
    }

    @Override
    public boolean isUniqueUrl(String url) {
        List<Website> websites = websiteRepository.findAllByUrl(url);
        return websites.size() == 0;
    }


    @Override
    public  List<Website> getHierarchyList(User user){
        List<Website> primalWebsites = websiteRepository.findAllByNullParent(user);
        if (primalWebsites.size() != 0){
            fillWebsites(primalWebsites);
            return primalWebsites;
        } else {
            return null;
        }

    }

    @Override
    public void fillWebsites(List<Website> websites) {
        if (websites.size() != 0){
            for(Website website : websites){
                website.setChildren(websiteRepository.findAllByParent(website.getUrl()));
                if (website.getChildren().size() != 0){
                    fillWebsites(website.getChildren());
                }
            }
        }
    }

}
