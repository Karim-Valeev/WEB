<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link type="text/css" rel="stylesheet" href="<@spring.url "/css/style.css"/>"/>
    <title>Title</title>
</head>
<body>

    <div style="display: flex">
        <div class="column column-posts">
            POSTS
        </div>
        <div class="column column-categories">
            CATEGORIES
        </div>
    </div>


    <#list posts as post>
        <div style="display: flex">
            <div class="post-list">
                <div>Title:</div>
                <div>${post.title}</div>
                <div>Text:</div>
                <div>${post.text}</div>
            </div>

            <div class="post-list">
                <div>
                    Category:
                </div>
                <div>
                    ${post.category.name}
                </div>
            </div>
        </div>
    <#else>
        Posts don't exist yet.
    </#list>
</body>
</html>