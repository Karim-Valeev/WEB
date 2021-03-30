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
<head>
    <title>${title}</title>
</head>
<body>
    <div>
        Title: ${title}
    </div>
    <div>
        Text: ${text}
    </div>
    <br>
    <div>
        <#list posts as post>
            <#if post.title != title>
                <span style="margin-right: 10px">
                    <a href="<@spring.url "${post.title}"/>">${post.title}</a>
                </span>
            <#else>
                <span>...</span>
            </#if>
        <#else>
            null
        </#list>
    </div>



</body>
</html>