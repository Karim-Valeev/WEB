package ru.kpfu.itis.valeev.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.models.Website;

import javax.sql.DataSource;
import java.util.List;

public class WebsiteRepositoryJdbcTemplateImpl implements WebsiteRepository{

    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_INSERT_WEBSITE = "insert into website(html_file_src, url, creator, parent_site) values (?, ?,?,?)";

    //language=SQL
    private static final String SQL_SELECT_BY_PARENT = "select * from website where parent_site = ?";

    //language=SQL
    private static final String SQL_SELECT_BY_NULL_PARENT = "select * from website where website.creator = ? and parent_site is null";

    //language=SQL
    private static final String SQL_SELECT_BY_URL = "select * from website where url = ?";

    public WebsiteRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

//    Todo разобраться с полями User и Website
    private RowMapper<Website> websiteRowMapper = (row, i) -> Website.builder()
            .id(row.getLong("id"))
            .title(row.getString("title"))
            .htmlFileSrc(row.getString("html_file_src"))
            .url(row.getString("url"))
            .creator(row.getLong("creator"))
            .parentSiteUrl(row.getString("parent_site"))
            .body(row.getString("body"))
            .build();

    @Override
    public void save(Website website) {
        jdbcTemplate.update(SQL_INSERT_WEBSITE,
                website.getHtmlFileSrc(),
                website.getUrl(),
//                Пока у нас только один юзер
                1,
                website.getParentSiteUrl());
    }

    @Override
    public List<Website> findAllByParent(String parentSiteUrl) {
        return jdbcTemplate.query(SQL_SELECT_BY_PARENT, websiteRowMapper, parentSiteUrl);
    }

    @Override
    public Website findByUrl(String url) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_URL, websiteRowMapper, url);
    }

    @Override
    public List<Website> findAllByNullParent(User user) {
        return jdbcTemplate.query(SQL_SELECT_BY_NULL_PARENT, websiteRowMapper, user.getId());
    }

    @Override
    public List<Website> findAllByUrl(String url) {
        return  jdbcTemplate.query(SQL_SELECT_BY_URL, websiteRowMapper, url);
    }

    @Override
    public void update(Website website) {

    }

    @Override
    public void delete(Website website) {

    }

    @Override
    public Website findByID(Long id) {
        return null;
    }
}
