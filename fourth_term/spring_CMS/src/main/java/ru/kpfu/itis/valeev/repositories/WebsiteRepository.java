package ru.kpfu.itis.valeev.repositories;

import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.models.Website;

import java.util.List;

public interface WebsiteRepository extends CrudRepository<Website>{
    Website findByUrl(String url);
    List<Website> findAllByParent(String parentSiteUrl);
    List<Website> findAllByNullParent(User user);
    List<Website> findAllByUrl(String url);

}
